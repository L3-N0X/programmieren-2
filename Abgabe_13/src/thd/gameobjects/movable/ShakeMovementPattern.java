package thd.gameobjects.movable;

import thd.gameobjects.base.Position;

import java.util.Random;

/**
 * A movement pattern that simulates a shaking effect by generating random positions.
 */
public class ShakeMovementPattern {

    private final Random random;

    /**
     * Constructs a new ShakeMovementPattern instance.
     */
    public ShakeMovementPattern() {
        random = new Random();
    }

    /**
     * Generates a new position for an object to shake.
     *
     * @param shakeDistance The distance in pixels the object should shake.
     * @return A new Position object with random coordinates within the shake distance.
     */
    public Position nextPosition(double shakeDistance) {
        if (shakeDistance > 0) {
            return new Position(random.nextDouble(shakeDistance), random.nextDouble(shakeDistance));
        } else {
            return new Position();
        }
    }
}
