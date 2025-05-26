package thd.game.managers;

/**
 * An exception that gets thrown once the game runs into unexpected world tiles.
 */
public class UnexpectedWorldTileException extends RuntimeException {
    /**
     * Creates a new exception for unexpected world tiles.
     *
     * @param message the error Message
     */
    public UnexpectedWorldTileException(String message) {
        super(message);
    }
}
