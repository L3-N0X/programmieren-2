package thd.gameobjects.base;

import java.util.Random;

/**
 * Represents a movement pattern in the game.
 */
public class MovementPattern {
    protected final Random random;

    protected MovementPattern() {
        random = new Random();
    }

    /**
     * Creates a new start position.
     *
     * @return The new start position
     */
    protected Position startPosition() {
        return new Position(0, 0);
    }

    /**
     * Calculates the next position.
     *
     * @return The next position
     */
    protected Position nextPosition() {
        return new Position(0, 0);
    }
}
