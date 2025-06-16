package thd.game.level;

/**
 * This Exception gets thrown when there are no further levels in the game.
 */
public class NoMoreLevelsAvailableException extends RuntimeException {
    /**
     * Creates a new NoMoreLevelsAvailableException which states that no further levels are in the game.
     *
     * @param message the message of the exception.
     */
    public NoMoreLevelsAvailableException(String message) {
        super(message);
    }
}
