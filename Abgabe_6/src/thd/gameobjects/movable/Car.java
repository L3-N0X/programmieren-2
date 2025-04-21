package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.managers.GameViewManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.MainCharacter;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

/**
 * A background tile of a rock formation with many rocks.
 */
public class Car extends CollidingGameObject implements MainCharacter {
    /**
     * State variable if the car is currently breaking.
     */
    public boolean isBreaking;
    /**
     * State variable if the car already started driving.
     */
    public boolean startedDriving;

    private static final double MAX_SPEED = 5;
    private static final double ACCELERATION = 0.1;
    private static final double BREAK_RATE = 1.3;
    private static final double STEERING_THRESHOLD = 0.4;
    private static final int SHOT_DURATION_IN_MILLISECONDS = 300;

    private static final int ROTATION_STEPS = 32;
    private static final int ROTATION_OFFSET = 8;

    private static final int STEERING_COOLDOWN_IN_MILLISECONDS = 200;

    private final GameBlockImages.CarTiles[] carTiles;
    private final LinkedList<CollidingGameObject> collidingGameObjectsForPathDecision;

    private int carRotation;

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
        size = GameBlockImages.BLOCK_SIZE;
        width = GameBlockImages.CarTiles.TILE_WIDTH * size;
        height = GameBlockImages.CarTiles.TILE_HEIGHT * size;
        carRotation = ROTATION_OFFSET;
        carTiles = GameBlockImages.CarTiles.values();
        collidingGameObjectsForPathDecision = new LinkedList<>();
        hitBoxOffsets(8, 8, -16, -16);
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
     * Removes GameObjects to the list of GameObjects the car can collide with.
     *
     * @param collidingGameObject The gameObjects that should get removed
     */
    public void removeCollidingGameObjectsForPathDecision(CollidingGameObject collidingGameObject) {
        collidingGameObjectsForPathDecision.remove(collidingGameObject);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {

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
    }

    /**
     * Accelerates the car to a maximum speed.
     */
    public void up() {
        speedInPixel += ACCELERATION * Math.sqrt(timeDeltaInSeconds(lastAcceleratingTime));
        speedInPixel = Math.min(speedInPixel, MAX_SPEED);
    }

    /**
     * Decelerates the car until it stays still again.
     */
    public void down() {
        if (speedInPixel > 0) {
            speedInPixel -= BREAK_RATE * timeDeltaInSeconds(lastUpdateTime);
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
        rotation = ((double) ((carRotation - ROTATION_OFFSET) % ROTATION_STEPS) / ROTATION_STEPS) * 2 * Math.PI;
        double dx = Math.cos(rotation) * speedInPixel;
        double dy = Math.sin(rotation) * speedInPixel;
        position.updateCoordinates(position.getX() + dx, position.getY() + dy);
        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                position.updateCoordinates(position.getX() - dx, position.getY() - dy);
                speedInPixel = 0;
                gamePlayManager.lifeLost();
                break;
            }
        }
        lastUpdateTime = gameView.gameTimeInMilliseconds();
    }

    @Override
    public void updateStatus() {
        super.updateStatus();
    }

    /**
     * Update the acceleration timer.
     */
    public void updateAccelerationTimer() {
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(carTiles[carRotation].blockImage(), position.getX(), position.getY(), size, 0);
        if (GameViewManager.DEBUG) {
            gameView.addTextToCanvas("Speed: " + speedInPixel, 5, 30, 14, true, Color.BLACK, 0);
        }
    }

    @Override
    public String toString() {
        return "Car: " + position + "Speed:" + speedInPixel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car other = (Car) o;
        return super.equals(o)
               && Objects.equals(collidingGameObjectsForPathDecision, other.collidingGameObjectsForPathDecision)
               && isBreaking == other.isBreaking
               && startedDriving == other.startedDriving
               && carRotation == other.carRotation
               && lastSteeringTime == other.lastSteeringTime
               && lastAcceleratingTime == other.lastAcceleratingTime
               && lastUpdateTime == other.lastUpdateTime
               && shotDurationInMilliseconds == other.shotDurationInMilliseconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBreaking, startedDriving, carRotation, lastSteeringTime, lastAcceleratingTime,
                            lastUpdateTime, shotDurationInMilliseconds, super.hashCode());
    }
}
