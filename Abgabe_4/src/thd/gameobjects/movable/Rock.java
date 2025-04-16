package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A background tile of a rock formation with many rocks.
 */
public class Rock extends GameObject {
    private static final double IMAGE_SCALE_FACTOR = 5;

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     */
    public Rock(GameView gameView) {
        super(gameView);
        position.updateCoordinates(1100, 50);
        speedInPixel = 2;
        size = 1;
        width = 750;
        height = 750;
    }

    @Override
    public void updatePosition() {
        position.left(speedInPixel);
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("rocks_very_many.png", position.getX(), position.getY(), IMAGE_SCALE_FACTOR, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
