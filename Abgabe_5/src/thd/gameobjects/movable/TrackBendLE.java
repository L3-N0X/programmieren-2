package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A background tile of a rock formation with many rocks.
 */
public class TrackBendLE extends GameObject {

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     */
    public TrackBendLE(GameView gameView) {
        super(gameView);
        position.updateCoordinates(128 * GameBlockImages.BLOCK_SIZE, 0);
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
        gameView.addBlockImageToCanvas(GameBlockImages.TrackTiles.BEND_LE.blockImage(), position.getX(), position.getY(), GameBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
