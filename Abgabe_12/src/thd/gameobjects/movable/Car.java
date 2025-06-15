package thd.gameobjects.movable;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.level.RoadCondition;
import thd.game.managers.GameManager;
import thd.game.managers.GamePlayManager;
import thd.game.managers.GameViewManager;
import thd.game.managers.WorldSectorTracker;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.EngineAudioGenerator;
import thd.gameobjects.base.MainCharacter;
import thd.gameobjects.base.Position;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.util.*;

/**
 * A car that can be controlled by the player. It can drive, steer, accelerate, and crash. It reacts to collisions with
 * map tiles and can drift when driving at high speeds.
 * <p>
 * This class extends {@link CollidingGameObject} and implements {@link MainCharacter}. It manages the car's state,
 * speed, rotation, and interactions with the game world. It also handles the car's visual representation and sound
 * effects based on its state.
 */
public class Car extends CollidingGameObject implements MainCharacter {
    private static final double STEERING_THRESHOLD = 0.4;

    private static final int STEERING_COOLDOWN_IN_MILLISECONDS = 350;

    private static final int ROTATION_STEPS = 32;
    private static final int ROTATION_OFFSET = 8;

    private static final Map<Difficulty, DifficultyParameters> DIFFICULTY_PARAMETERS = new EnumMap<>(Difficulty.class);
    private static final Map<RoadCondition, RoadParameters> ROAD_PARAMETERS = new EnumMap<>(RoadCondition.class);

    private record DifficultyParameters(double maxSpeed, double acceleration, double breakRate) {
    }

    private record RoadParameters(double driftInitiationSpeedThreshold, double driftAngularVelocity,
                                  double driftFriction, double driftRecoveryRate, double driftAngleRecoveryStep) {
    }

    private record CarParameters(double driftInitiationSpeedThreshold,
                                 double driftAngularVelocity,
                                 double driftFriction,
                                 double driftRecoveryRate,
                                 double driftAngleRecoveryStep,
                                 double maxSpeed,
                                 double acceleration,
                                 double breakRate) {
    }

    static {
        DIFFICULTY_PARAMETERS.put(Difficulty.EASY,
                                  new DifficultyParameters(12.0,
                                                           0.2, 2.5));
        DIFFICULTY_PARAMETERS.put(Difficulty.STANDARD,
                                  new DifficultyParameters(17.0,
                                                           0.3, 2.8));
        DIFFICULTY_PARAMETERS.put(Difficulty.HARD,
                                  new DifficultyParameters(22.0,
                                                           0.4, 3.2));
        ROAD_PARAMETERS.put(RoadCondition.DRY,
                            new RoadParameters(7.0, Math.toRadians(-1.5), 0.15,
                                               0.04, Math.toRadians(0.3)));
        ROAD_PARAMETERS.put(RoadCondition.WET,
                            new RoadParameters(6.0, Math.toRadians(-1.6), 0.12,
                                               0.033, Math.toRadians(0.26)));
        ROAD_PARAMETERS.put(RoadCondition.ICY,
                            new RoadParameters(4.0, Math.toRadians(-1.7), 0.1,
                                               0.027, Math.toRadians(0.17)));
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

    private double driftAngle;
    private double driftFactor;

    private int lastSteeringTime;
    private int lastAcceleratingTime;
    private int lastUpdateTime;

    private final EngineAudioGenerator engineAudio;

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public Car(GameView gameView, GamePlayManager gamePlayManager) throws LineUnavailableException {
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
        driftAngle = 0.0;
        driftFactor = 0.0;
        hitBoxOffsets(8, 8, -16, -16);
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
        engineAudio = new EngineAudioGenerator();
    }

    /**
     * Updates the car parameters based on the current difficulty level.
     *
     * @param roadCondition The current road condition which affects the car's drift parameters.
     */
    public void updateParameters(RoadCondition roadCondition) {
        DifficultyParameters difficultyParameters = DIFFICULTY_PARAMETERS.get(Level.difficulty);
        RoadParameters roadParameters = ROAD_PARAMETERS.get(roadCondition);

        this.carParameters = new CarParameters(
                roadParameters.driftInitiationSpeedThreshold(),
                roadParameters.driftAngularVelocity(),
                roadParameters.driftFriction(),
                roadParameters.driftRecoveryRate(),
                roadParameters.driftAngleRecoveryStep(),
                difficultyParameters.maxSpeed(),
                difficultyParameters.acceleration(),
                difficultyParameters.breakRate());
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
        resetSurfaceState();
        switch (mapSurface) {
            case BRICK -> {
                switch (mapTileImage) {
                    case HOUSE_BIG, HOUSE_CORNER -> crash();
                    case ROCKS_FEW, ROCKS_MANY, ROCKS_NOT_SO_MANY, ROCKS_VERY_MANY -> {
                        crashIfTooFast();
                    }
                    default -> {
                    }
                }
            }
            case TRACK -> { // is stone color for house tiles
                switch (mapTileImage) {
                    case HOUSE_BIG, HOUSE_CORNER -> crash();
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

    private void crashIfTooFast() {
        if (speedInPixel > carParameters.maxSpeed / 4) {
            crash();
        } else if (speedInPixel > carParameters.maxSpeed / 8) {
            if (gameView.timer((int) (Math.random() * 300 + 100), 0, this)) {
                gameView.playSound("rocks.wav", false);
            }
        }
    }

    private void resetSurfaceState() {
        if (currentState == State.GRASS || currentState == State.WATER) {
            currentState = State.ACCELERATING;
        }
    }

    /**
     * Calculates the distance the car shakes from its current state.
     *
     * @return the distance the car shakes from its current state in pixels.
     */
    public double shakeDistanceFromState() {
        return switch (currentState) {
            case IDLE, ACCELERATING, BREAKING -> 0.0;
            case GRASS -> 0.6 * speedInPixel;
            case WATER -> 0.8 * speedInPixel;
            case CRASHED -> 1 * speedInPixel;
        };
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
        double normalizedSpeed = (speedInPixel - carParameters.driftInitiationSpeedThreshold)
                                 / (carParameters.maxSpeed - carParameters.driftInitiationSpeedThreshold);

        if (normalizedSpeed < 0) {
            normalizedSpeed = 0;
        }

        double quadraticDriftAddition = 0.12 * normalizedSpeed * normalizedSpeed;

        driftFactor += quadraticDriftAddition;
        if (driftFactor > 1.0) {
            driftFactor = 1.0;
            if (gameView.timer((int) (Math.random() * 200 + 100), 0, this)) {
                gameView.playSound("drift.wav", false);
            }
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

        double dx = Math.cos(effectiveMovementAngleRad) * speedInPixel;
        double dy = Math.sin(effectiveMovementAngleRad) * speedInPixel;

        gamePlayManager.moveWorldToLeft(dx);
        gamePlayManager.moveWorldUp(dy);
        lastUpdateTime = gameView.gameTimeInMilliseconds();
    }

    private double normalizeAngle(double angle) {
        double newAngle = angle;
        while (newAngle < 0) {
            newAngle += 2 * Math.PI;
        }
        while (newAngle >= 2 * Math.PI) {
            newAngle -= 2 * Math.PI;
        }
        return newAngle;
    }

    @Override
    public void updateStatus() {
        super.updateStatus();
        switch (currentState) {
            case IDLE -> {
                // Reset acceleration timer while idle to prevent acceleration buildup
                lastAcceleratingTime = gameView.gameTimeInMilliseconds();
                blockImage = carRotationTiles[carRotation].blockImage();
            }
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
            default -> blockImage = carRotationTiles[carRotation].blockImage();
        }
        engineAudio.update();
        engineAudio.updateSpeed(speedInPixel, carParameters.maxSpeed, currentState == State.GRASS);
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
    @Override
    public void startDriving() {
        if (currentState != State.CRASHED) {
            // Reset acceleration timer when starting to drive from idle state
            gamePlayManager.startLapTimer();

            if (currentState == State.IDLE) {
                lastAcceleratingTime = gameView.gameTimeInMilliseconds();
            }
            currentState = State.ACCELERATING;
        }
    }

    /**
     * Sets the current state to crashed and stops the car.
     */
    private void crash() {
        if (currentState == State.CRASHED) {
            return;
        } else if (GameViewManager.debug) {
            return;
        }
        currentState = State.CRASHED;
        gameView.playSound("crash.wav", false);
        engineAudio.turnEngineOn(false);

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
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
        currentState = State.IDLE;

        lastUpdateTime = 0;
        engineAudio.start();
        engineAudio.turnEngineOn(true);

        carRotation = ROTATION_OFFSET;
        lastCarRotationOnTrack = ROTATION_OFFSET;
    }

    ArrayList<Position> carCollisionPositionsInBlocks() {
        return carRotationTiles[carRotation].getCollisionPositionsInBlocks();
    }

    private void respawn() {
        speedInPixel = 0;
        if (lastTrackTile != null) {
            rotateCarToLastTrackTile();
            placeCarOnLastTrackTile();
        }
        resetTimeAndState();
    }

    private void rotateCarToLastTrackTile() {
        ArrayList<Integer> possibleSpawnRotations = lastTrackTile.getMapTileImage().getPossibleRotations();
        carRotation = findClosestRotation(lastCarRotationOnTrack, possibleSpawnRotations);
    }

    private void placeCarOnLastTrackTile() {
        double lastTrackTileWorldX = lastTrackTile.getPosition().getX();
        double lastTrackTileWorldY = lastTrackTile.getPosition().getY();
        double tileWidthInPixels = GamePlayManager.BLOCK_SIZE * GamePlayManager.MAP_TILE_WIDTH;
        double tileHeightInPixels = GamePlayManager.BLOCK_SIZE * GamePlayManager.MAP_TILE_HEIGHT;
        double screenCenterX = GameView.WIDTH / 2.0;
        double screenCenterY = GameView.HEIGHT / 2.0;
        double initialCarOffsetX = width / 2.0;
        double initialCarOffsetY = height / 2.0;

        gameView.stopAllSounds();
        engineAudio.start();
        engineAudio.turnEngineOn(true);

        Position adjustedOffsets = applyDiagonalOffsets(new Position(initialCarOffsetX, initialCarOffsetY),
                                                        tileWidthInPixels,
                                                        tileHeightInPixels);

        double tileOffsetX = screenCenterX - (lastTrackTileWorldX + tileWidthInPixels / 2.0) + adjustedOffsets.getX();
        double tileOffsetY = screenCenterY - (lastTrackTileWorldY + tileHeightInPixels / 2.0) + adjustedOffsets.getY();

        gamePlayManager.moveWorldToRight(tileOffsetX);
        gamePlayManager.moveWorldDown(tileOffsetY);
    }

    private Position applyDiagonalOffsets(Position carOffsets, double tileWidthInPixels,
                                          double tileHeightInPixels) {
        double newCarOffsetX = carOffsets.getX();
        double newCarOffsetY = carOffsets.getY();
        if (lastTrackTile.getMapTileImage() != null) {
            switch (lastTrackTile.getMapTileImage()) {
                case TRACK_DIAGONAL_SW -> {
                    newCarOffsetX += tileWidthInPixels / 4;
                    newCarOffsetY -= tileHeightInPixels / 4;
                }
                case TRACK_DIAGONAL_NE -> {
                    newCarOffsetX -= tileWidthInPixels / 4;
                    newCarOffsetY += tileHeightInPixels / 4;
                }
                case TRACK_DIAGONAL_NW -> {
                    newCarOffsetX += tileWidthInPixels / 4;
                    newCarOffsetY += tileHeightInPixels / 4;
                }
                case TRACK_DIAGONAL_SE -> {
                    newCarOffsetX -= tileWidthInPixels / 4;
                    newCarOffsetY -= tileHeightInPixels / 4;
                }
                default -> {
                }
            }
        }
        return new Position(newCarOffsetX, newCarOffsetY);
    }

    private void resetTimeAndState() {
        lastSteeringTime = 0;
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
        lastUpdateTime = 0;
        gamePlayManager.pauseLapTimer();
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
        String translatedBlockImage = GameManager.translateBlockImageForLevel(
                blockImage, gamePlayManager.currentLevel());
        gameView.addBlockImageToCanvas(translatedBlockImage, position.getX(), position.getY(), size, 0);
        if (GameViewManager.debug) {
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

            WorldSectorTracker sectorTracker = gamePlayManager.getSectorTracker();
            Set<Integer> visitedSectors = sectorTracker.getVisitedSectors();
            int currentSector = sectorTracker.currentSector();

            gameView.addTextToCanvas(
                    "Sectors - Visited: " + visitedSectors + " Current: " + currentSector, 5,
                    110, 14, true, Color.BLACK, 0);
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
