package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * A background tile of a rock formation with many rocks.
 */
public class Car extends GameObject {
    private boolean shotInProgress;

    private GameBlockImages.CarTiles[] carTiles;
    private int carRotation;

    private static final double MAX_SPEED = 5;
    private static final double ACCELERATION = 0.1;
    private static final double BREAK_RATE = 1.3;

    /**
     * State variable if the car is currently breaking.
     */
    public boolean isBreaking;
    /**
     * State variable if the car already started driving.
     */
    public boolean startedDriving;

    private int lastSteeringTime;
    private int lastAcceleratingTime;
    private int lastUpdateTime;

    private static final int ROTATION_STEPS = 32;
    private static final int STEERING_COOLDOWN_IN_MILLIS = 150;

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     */
    public Car(GameView gameView) {
        super(gameView);
        position.updateCoordinates(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
        size = GameBlockImages.BLOCK_SIZE;
        width = 22 * size;
        height = 22 * size;
        carRotation = 8;  // to the East
        carTiles = GameBlockImages.CarTiles.values();
    }

    /**
     * Steer to the left, car needs speed to turn.
     */
    public void left() {
        if (gameView.gameTimeInMilliseconds() > lastSteeringTime + STEERING_COOLDOWN_IN_MILLIS && speedInPixel > 0.4) {
            carRotation = (carRotation - 1 + ROTATION_STEPS) % ROTATION_STEPS;
            lastSteeringTime = gameView.gameTimeInMilliseconds();
        }
    }

    /**
     * Steer to the right, car needs speed to turn.
     */
    public void right() {
        if (gameView.gameTimeInMilliseconds() > lastSteeringTime + STEERING_COOLDOWN_IN_MILLIS && speedInPixel > 0.4) {
            carRotation = (carRotation + 1) % ROTATION_STEPS;
            lastSteeringTime = gameView.gameTimeInMilliseconds();
        }
    }

    /**
     * Accelerates the car to a maximum speed.
     */
    public void up() {
        speedInPixel += ACCELERATION * Math.pow(timeDeltaInSeconds(lastAcceleratingTime), 0.5);
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

    private double timeDeltaInSeconds(int time) {
        return (gameView.gameTimeInMilliseconds() - time) / 1000.0;
    }

    @Override
    public void updatePosition() {
        rotation = (((carRotation + 24) % 32) / 32.0) * 2 * Math.PI;
        double dx = Math.cos(rotation) * speedInPixel;
        double dy = Math.sin(rotation) * speedInPixel;
        position.updateCoordinates(position.getX() + dx, position.getY() + dy);
        lastUpdateTime = gameView.gameTimeInMilliseconds();
    }

    /**
     * Moves the car to the down with the current speed.
     */
    public void shoot() {
        shotInProgress = true;
    }

    @Override
    public void updateStatus() {
        if (gameView.timer(5000, 1, this)) {
            size++;
        }
    }

    /**
     * Update the acceleration timer.
     */
    public void updateAccelerationTimer() {
        lastAcceleratingTime = gameView.gameTimeInMilliseconds();
    }

    @Override
    public void addToCanvas() {
        if (shotInProgress) {
            gameView.addTextToCanvas("X", position.getX(), position.getY(), 34, true, Color.BLACK, rotation, "droidsansmono.ttf");
        } else {
            gameView.addBlockImageToCanvas(carTiles[carRotation].blockImage(), position.getX(), position.getY(), size, 0);
        }
        //if (GameViewManager.DEBUG) {
        //    gameView.addTextToCanvas("Speed: " + speedInPixel, 5, 30, 14, true, Color.BLACK, 0);
        //}
        shotInProgress = false;
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
