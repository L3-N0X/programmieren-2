package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

/**
 * A background tile of a rock formation with many rocks.
 */
public class Rock {
    private final GameView gameView;
    private final Position position;
    private final double speedInPixel;
    private final double rotation;
    private static final double IMAGE_SCALE_FACTOR = 5;
    private final int size;
    private final int width;
    private final int height;

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView the main {@link thd.game.utilities.GameView} where the text later gets added to
     */
    public Rock(GameView gameView) {
        this.gameView = gameView;
        position = new Position(1100, 50);
        speedInPixel = 2;
        rotation = 0;
        size = 1;
        width = 750;
        height = 750;
    }

    /**
     * Changes the position of the GameObject with a predefined movement.
     */
    public void updatePosition() {
        position.left(speedInPixel);
    }

    /**
     * Adds this object to the {@link thd.game.utilities.GameView}, this should be called each frame to update the existing object.
     */
    public void addToCanvas() {
        gameView.addImageToCanvas("rocks_very_many.png", position.getX(), position.getY(), IMAGE_SCALE_FACTOR, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
