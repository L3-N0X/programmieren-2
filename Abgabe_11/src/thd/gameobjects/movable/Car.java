package thd.gameobjects.movable;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.managers.GamePlayManager;
import thd.game.managers.GameViewManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.MainCharacter;
import thd.gameobjects.base.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A background tile of a rock formation with many rocks.
 */
public class Car extends CollidingGameObject implements MainCharacter {
    private static final double STEERING_THRESHOLD = 0.4;

    private static final int STEERING_COOLDOWN_IN_MILLISECONDS = 350;
    private static final int SHOT_DURATION_IN_MILLISECONDS = 300;

    private static final int ROTATION_STEPS = 32;
    private static final int ROTATION_OFFSET = 8;

    private static final Map<Difficulty, CarParameters> DIFFICULTY_PARAMETERS = new EnumMap<>(Difficulty.class);

    private record CarParameters(double driftInitiationSpeedThreshold,
                                 double driftAngularVelocity,
                                 double driftFriction,
                                 double driftRecoveryRate,
                                 double driftAngleRecoveryStep,
                                 double maxSpeed,
                                 double acceleration,
                                 double breakRate
    ) {
    }

    static {
        DIFFICULTY_PARAMETERS.put(Difficulty.EASY,
                                  new CarParameters(7.0, Math.toRadians(-1.5), 0.15,
                                                    0.04, Math.toRadians(0.3), 12.0,
                                                    0.2, 2.5));
        DIFFICULTY_PARAMETERS.put(Difficulty.STANDARD,
                                  new CarParameters(8.5, Math.toRadians(-2.0), 0.2,
                                                    0.032, Math.toRadians(0.2), 17.0,
                                                    0.3, 2.8));
        DIFFICULTY_PARAMETERS.put(Difficulty.HARD,
                                  new CarParameters(10.0, Math.toRadians(-2.5), 0.25,
                                                    0.025, Math.toRadians(0.15), 22.0,
                                                    0.4, 3.2));
    }

    private CarParameters carParameters;

    private State currentState;
    private CarBlockImages.Fire currentCrashState;

    private String blockImage;

    private Driver driver;

    private final CarBlockImages.CarRotation[] carRotationTiles;
    private final LinkedList<CollidingGameObject> collidingGameObjectsForPathDecision;

    private int carRotation;

    private MapTile lastTrackTile;
    private int lastCarRotationOnTrack;
    private double lastCarSpeed;
    private int lastCarSound;
    private String lastSoundFile;

    double driftAngle;
    double driftFactor;

    private int lastSteeringTime;
    private int lastAcceleratingTime;
    private int lastUpdateTime;
    private int shotDurationInMilliseconds;

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public Car(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
        size = GamePlayManager.BLOCK_SIZE;
        width = CarBlockImages.TILE_WIDTH * size;
        height = CarBlockImages.TILE_HEIGHT * size;
        carRotation = ROTATION_OFFSET;
        currentState = State.IDLE;
        currentCrashState = CarBlockImages.Fire.FIRE_00;
        carRotationTiles = CarBlockImages.CarRotation.values();
        blockImage = carRotationTiles[carRotation].blockImage();
        collidingGameObjectsForPathDecision = new LinkedList<>();
        distanceToBackground = 10;
        rotation = 0;
        lastCarSpeed = 0;
        lastCarSound = -1;
        lastSoundFile = "";
        driftAngle = 0.0;
        driftFactor = 0.0;
        carParameters = DIFFICULTY_PARAMETERS.get(Level.difficulty);
        hitBoxOffsets(8, 8, -16, -16);
    }

    /**
     * Updates the car parameters based on the current difficulty level.
     */
    public void updateParameters() {
        carParameters = DIFFICULTY_PARAMETERS.get(Level.difficulty);
        if (GameViewManager.DEBUG) {
            System.out.println("Car parameters updated for difficulty: " + Level.difficulty);
        }
    }

    /**
     * Adds GameObjects to the list of GameObjects the car can collide with.
     *
     * @param collidingGameObject The gameObjects that should get added
     */
    public void addCollidingGameObjectsForPathDecision(CollidingGameObject collidingGameObject) {
        collidingGameObjectsForPathDecision.add(collidingGameObject);
    }

    /**
     * Removes GameObjects from the list of GameObjects the car can collide with.
     *
     * @param collidingGameObject The gameObjects that should get removed
     */
    public void removeCollidingGameObjectsForPathDecision(CollidingGameObject collidingGameObject) {
        collidingGameObjectsForPathDecision.remove(collidingGameObject);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof MapTile mapTile) {
            for (MapSurface mapSurface : mapTile.mapSurfacesAtCarPosition(this)) {
                handleCollisionWithMapTile(mapSurface, mapTile);

                MapBlockImages.MapTileImage mapTileImage = mapTile.getMapTileImage();
                handleMapSurface(mapSurface, mapTileImage);
            }
        }
    }

    private void handleCollisionWithMapTile(MapSurface mapSurface, MapTile mapTile) {
        if (mapTile.isTrackTile() && mapSurface == MapSurface.TRACK) {
            lastTrackTile = mapTile;
            lastCarRotationOnTrack = carRotation;
        }
    }

    private void handleMapSurface(MapSurface mapSurface, MapBlockImages.MapTileImage mapTileImage) {
        if (currentState == State.GRASS || currentState == State.WATER) {
            currentState = State.ACCELERATING;
        }
        switch (mapSurface) {
            case BRICK -> {
                switch (mapTileImage) {
                    case HOUSE_BIG, HOUSE_CORNER -> crash();
                    case ROCKS_FEW, ROCKS_MANY, ROCKS_NOT_SO_MANY, ROCKS_VERY_MANY -> {
                        if (speedInPixel > carParameters.maxSpeed / 4) {
                            crash();
                        }
                    }
                    default -> {
                    }
                }
            }
            case GRASS -> {
                if (isDriving()) {
                    currentState = State.GRASS;
                }
            }
            case WATER -> {
                if (isDriving()) {
                    currentState = State.WATER;
                }
            }
            default -> {
            }
        }
    }

    /**
     * Steer to the left, car needs speed to turn.
     */
    public void left() {
        if (gameView.gameTimeInMilliseconds() > lastSteeringTime + STEERING_COOLDOWN_IN_MILLISECONDS * (1 / Math.sqrt(
                speedInPixel)) && speedInPixel > STEERING_THRESHOLD) {
            carRotation = (carRotation - 1 + ROTATION_STEPS) % ROTATION_STEPS;
            lastSteeringTime = gameView.gameTimeInMilliseconds();
        }
        if (speedInPixel > carParameters.driftInitiationSpeedThreshold) {
            calculateDriftFactor();
            driftAngle -= carParameters.driftAngularVelocity * driftFactor;
        }
    }

    /**
     * Steer to the right, car needs speed to turn.
     */
    public void right() {
        if (gameView.gameTimeInMilliseconds() > lastSteeringTime + STEERING_COOLDOWN_IN_MILLISECONDS * (1 / Math.sqrt(
                speedInPixel)) && speedInPixel > STEERING_THRESHOLD) {
            carRotation = (carRotation + 1) % ROTATION_STEPS;
            lastSteeringTime = gameView.gameTimeInMilliseconds();
        }
        if (speedInPixel > carParameters.driftInitiationSpeedThreshold) {
            calculateDriftFactor();
            driftAngle += carParameters.driftAngularVelocity * driftFactor;
        }
    }

    private void calculateDriftFactor() {
        double normalizedSpeed = (speedInPixel - carParameters.driftInitiationSpeedThreshold) / (carParameters.maxSpeed - carParameters.driftInitiationSpeedThreshold);

        if (normalizedSpeed < 0) {
            normalizedSpeed = 0;
        }

        double quadraticDriftAddition = 0.12 * normalizedSpeed * normalizedSpeed;

        driftFactor += quadraticDriftAddition;
        if (driftFactor > 1.0) {
            driftFactor = 1.0;
        }
    }

    /**
     * Accelerates the car to a maximum speed.
     */
    public void up() {
        double speedIncrease = carParameters.acceleration * Math.sqrt(timeDeltaInSeconds(lastAcceleratingTime));
        speedInPixel += carParameters.acceleration * Math.sqrt(timeDeltaInSeconds(lastAcceleratingTime));
        switch (currentState) {
            case GRASS -> {
                if (speedInPixel > carParameters.maxSpeed * 0.7) {
                    speedInPixel -= speedIncrease;
                    speedInPixel *= 0.9;
                }
            }
            case WATER -> {
                if (speedInPixel > carParameters.maxSpeed * 0.6) {
                    speedInPixel -= speedIncrease;
                    speedInPixel *= 0.8;
                }
            }
            default -> {
            }
        }
        speedInPixel = Math.min(speedInPixel, carParameters.maxSpeed);
    }

    /**
     * Decelerates the car until it stays still again.
     */
    public void down() {
        currentState = State.BREAKING;
        if (speedInPixel > 0) {
            speedInPixel -= carParameters.breakRate * timeDeltaInSeconds(lastUpdateTime);
            if (speedInPixel < 0.05) {
                speedInPixel = 0;
            }
        }
    }

    /**
     * Spawns a new bullet into the currently facing direction.
     */
    @Override
    public void shoot() {
        if (gameView.timer(shotDurationInMilliseconds, 1, this)) {
            Bullet bullet = new Bullet(gameView, gamePlayManager, position.getX() + width / 2,
                                       position.getY() + height / 3, rotation);
            gamePlayManager.spawnGameObject(bullet);
            shotDurationInMilliseconds = SHOT_DURATION_IN_MILLISECONDS;
        }
    }

    private double timeDeltaInSeconds(int time) {
        return (gameView.gameTimeInMilliseconds() - time) / 1000.0;
    }

    @Override
    public void updatePosition() {
        if (currentState == State.CRASHED) {
            return;
        }

        rotation = ((double) ((carRotation - ROTATION_OFFSET) % ROTATION_STEPS) / ROTATION_STEPS) * 2.0 * Math.PI;

        if (driftFactor > 0) {
            speedInPixel -= carParameters.driftFriction * driftFactor;
            if (speedInPixel < 0) {
                speedInPixel = 0;
            }

            driftFactor -= carParameters.driftRecoveryRate;

            if (driftAngle > carParameters.driftAngleRecoveryStep) {
                driftAngle -= carParameters.driftAngleRecoveryStep;
            } else if (driftAngle < -carParameters.driftAngleRecoveryStep) {
                driftAngle += carParameters.driftAngleRecoveryStep;
            } else {
                driftAngle = 0;
            }

            if (driftFactor <= 0) {
                driftFactor = 0;
                driftAngle = 0;
            }
        } else {
            driftFactor = 0;
            driftAngle = 0;
        }

        rotation = normalizeAngle(rotation);

        double effectiveMovementAngleRad = normalizeAngle(rotation + (driftAngle * driftFactor));

        if (GameViewManager.DEBUG) {
            System.out.printf(
                    "Car Update: Speed=%.2f, Rotation=%.2f, DriftAngle=%.2f, DriftFactor=%.2f, EffectiveAngle=%.2f%n",
                    speedInPixel,
                    Math.toDegrees(rotation),
                    Math.toDegrees(driftAngle),
                    driftFactor,
                    Math.toDegrees(effectiveMovementAngleRad));
        }

        double dx = Math.cos(effectiveMovementAngleRad) * speedInPixel;
        double dy = Math.sin(effectiveMovementAngleRad) * speedInPixel;

        gamePlayManager.moveWorldToLeft(dx);
        gamePlayManager.moveWorldUp(dy);
        lastUpdateTime = gameView.gameTimeInMilliseconds();
    }

    private double normalizeAngle(double angle) {
        while (angle < 0) angle += 2 * Math.PI;
        while (angle >= 2 * Math.PI) angle -= 2 * Math.PI;
        return angle;
    }

    @Override
    public void updateStatus() {
        super.updateStatus();
        String soundFile = "";
        switch (currentState) {
            case CRASHED -> {
                if (gameView.timer(200, 0, this)) {
                    blockImage = currentCrashState.blockImage();
                    switchToNextCrashState();
                }
                if (gameView.timer(5000, 0, this)) {
                    gamePlayManager.destroyGameObject(driver);
                    respawn();
                }
            }
            case IDLE -> blockImage = carRotationTiles[carRotation].blockImage();
            default -> {
                blockImage = carRotationTiles[carRotation].blockImage();
                if (gameView.timer(100 - (int) Math.ceil(speedInPixel / carParameters.maxSpeed * 6), 0, this)) {
                    soundFile = "speed_" + (int) Math.ceil(speedInPixel / carParameters.maxSpeed * 10) + ".wav";
                }
            }
        }

        if (!soundFile.isEmpty() && !lastSoundFile.equals(soundFile)) {
            gameView.stopSound(lastCarSound);
            lastCarSound = gameView.playSound(soundFile, true);
        }
        lastSoundFile = soundFile;
    }

    /**
     * Returns <code>true</code> if the current state is anything but idle.
     *
     * @return <code>true</code> if the car is not idle.
     */
    public boolean isDriving() {
        return currentState != State.IDLE && currentState != State.CRASHED;
    }

    /**
     * This method sets the state to accelerating.
     */
    public void startDriving() {
        if (currentState != State.CRASHED) {
            currentState = State.ACCELERATING;
        }
    }

    /**
     * Sets the current state to crashed and stops the car.
     */
    private void crash() {
        if (currentState == State.CRASHED) {
            return;
        } else if (GameViewManager.DEBUG) {
            return;
        }
        currentState = State.CRASHED;
        gamePlayManager.pauseLapTimer();
        gameView.stopAllSounds();

        gameView.playSound("crash.wav", false);
        double dx = Math.cos(rotation) * speedInPixel;
        double dy = Math.sin(rotation) * speedInPixel;
        gamePlayManager.moveWorldToLeft(-dx);
        gamePlayManager.moveWorldUp(-dy);

        driver = new Driver(gameView, gamePlayManager, position.getX(), position.getY());
        gamePlayManager.spawnGameObject(driver);
        if (carRotation <= 16) {
            if (speedInPixel > carParameters.maxSpeed * 0.7) {
                driver.crashRollRight();
            } else {
                driver.crashRight();
            }
        } else {
            if (speedInPixel > carParameters.maxSpeed * 0.7) {
                driver.crashRollLeft();
            } else {
                driver.crashLeft();
            }
        }
        speedInPixel = 0;
    }

    /**
     * Update the acceleration timer.
     */
    public void updateAccelerationTimer() {
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
    }

    private void switchToNextCrashState() {
        int nextState = (currentCrashState.ordinal() + 1) % CarBlockImages.Fire.values().length;
        currentCrashState = CarBlockImages.Fire.values()[nextState];
    }

    /**
     * Resets the cars rotation and timers.
     */
    public void reset() {
        rotation = 0;
        speedInPixel = 0;
        lastSteeringTime = 0;
        lastAcceleratingTime = 0;
        lastCarSpeed = 0;
        currentState = State.IDLE;

        lastUpdateTime = 0;
        gameView.stopAllSounds();

        carRotation = ROTATION_OFFSET;
        lastCarRotationOnTrack = ROTATION_OFFSET;
    }

    ArrayList<Position> carCollisionPositionsInBlocks() {
        return carRotationTiles[carRotation].getCollisionPositionsInBlocks();
    }

    private void respawn() {
        speedInPixel = 0;
        if (lastTrackTile != null) {
            ArrayList<Integer> possibleSpawnRotations = lastTrackTile.getMapTileImage().getPossibleRotations();
            carRotation = findClosestRotation(lastCarRotationOnTrack, possibleSpawnRotations);

            double lastTrackTileWorldX = lastTrackTile.getPosition().getX();
            double lastTrackTileWorldY = lastTrackTile.getPosition().getY();

            double tileWidthInPixels = GamePlayManager.BLOCK_SIZE * GamePlayManager.MAP_TILE_WIDTH;
            double tileHeightInPixels = GamePlayManager.BLOCK_SIZE * GamePlayManager.MAP_TILE_HEIGHT;

            double screenCenterX = GameView.WIDTH / 2.0;
            double screenCenterY = GameView.HEIGHT / 2.0;

            double carOffsetX = width / 2.0;
            double carOffsetY = height / 2.0;

            gameView.stopAllSounds();

            if (null != lastTrackTile.getMapTileImage()) {
                switch (lastTrackTile.getMapTileImage()) {
                    case TRACK_DIAGONAL_SW -> {
                        carOffsetX += tileWidthInPixels / 4;
                        carOffsetY -= tileHeightInPixels / 4;
                    }
                    case TRACK_DIAGONAL_NE -> {
                        carOffsetX -= tileWidthInPixels / 4;
                        carOffsetY += tileHeightInPixels / 4;
                    }
                    case TRACK_DIAGONAL_NW -> {
                        carOffsetX += tileWidthInPixels / 4;
                        carOffsetY += tileHeightInPixels / 4;
                    }
                    case TRACK_DIAGONAL_SE -> {
                        carOffsetX -= tileWidthInPixels / 4;
                        carOffsetY -= tileHeightInPixels / 4;
                    }
                    default -> {
                    }
                }
            }

            double tileOffsetX = screenCenterX - (lastTrackTileWorldX + tileWidthInPixels / 2.0) + carOffsetX;
            double tileOffsetY = screenCenterY - (lastTrackTileWorldY + tileHeightInPixels / 2.0) + carOffsetY;

            gamePlayManager.moveWorldToRight(tileOffsetX);
            gamePlayManager.moveWorldDown(tileOffsetY);
        }
        lastSteeringTime = 0;
        lastAcceleratingTime = 0;
        lastUpdateTime = 0;
        lastCarSpeed = 0;
        currentState = State.IDLE;
    }

    private int findClosestRotation(int targetRotation, ArrayList<Integer> validRotations) {
        int closestRotation = -1;
        int minDifference = Integer.MAX_VALUE;

        for (int validRotation : validRotations) {
            int rotationDifference = Math.abs(targetRotation - validRotation);
            int rotationWithoutDirection = Math.min(rotationDifference, 32 - rotationDifference);

            if (rotationWithoutDirection < minDifference) {
                minDifference = rotationWithoutDirection;
                closestRotation = validRotation;
            }
        }

        return closestRotation;
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(blockImage, position.getX(), position.getY(), size, 0);
        if (GameViewManager.DEBUG) {
            gameView.addTextToCanvas(
                    "Speed: " + Math.round(speedInPixel * 100) / 100.0 + " Rotation: " + Math.toDegrees(rotation), 5,
                    30, 14,
                    true, Color.BLACK,
                    0);
            gameView.addTextToCanvas(
                    "DriftAngle: " + Math.round(Math.toDegrees(driftAngle) * 100) / 100.0, 5,
                    45, 14, true, Color.BLACK, 0);
            gameView.addTextToCanvas(
                    "DriftFactor: " + Math.round(driftFactor * 100) / 100.0, 5,
                    80, 14, true, Color.BLACK, 0);
            double currentEffectiveAngleRad = normalizeAngle(rotation + (driftAngle * driftFactor));
            gameView.addTextToCanvas(
                    "EffectiveAngle: " + Math.round(Math.toDegrees(currentEffectiveAngleRad) * 100) / 100.0,
                    5, 95, 14, true, Color.BLACK, 0);
            if (lastTrackTile != null) {
                gameView.addTextToCanvas(lastTrackTile.getPosition().toString(), 5, 60, 14, true, Color.BLACK, 0);
            }
        }
    }

    @Override
    public String toString() {
        return "Car: " + position + "Speed: " + speedInPixel + "State: " + currentState;
    }

    private enum State {
        IDLE, ACCELERATING, BREAKING, CRASHED, GRASS, WATER
    }
}
