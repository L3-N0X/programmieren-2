package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A BlockImage of a house as GameObject.
 */
public class HouseCorner extends GameObject {

    /**
     * Creates a new moving House BlockImage in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     * @see GameBlockImages for the Image that gets rendered
     */
    public HouseCorner(GameView gameView) {
        super(gameView);
        position.updateCoordinates(128 * GameBlockImages.BLOCK_SIZE, 112 * GameBlockImages.BLOCK_SIZE);
        speedInPixel = 0;
        size = GameBlockImages.BLOCK_SIZE;
        width = 128 * GameBlockImages.BLOCK_SIZE;
        height = 112 * GameBlockImages.BLOCK_SIZE;
    }

    @Override
    public void updatePosition() {
        position.left(speedInPixel);
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(GameBlockImages.Track.HOUSE_CORNER, position.getX(), position.getY(), GameBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
