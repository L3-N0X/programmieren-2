package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A BlockImage of a house as GameObject.
 */
public class HouseBig extends GameObject {

    /**
     * Creates a new moving House BlockImage in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @see GameBlockImages for the Image that gets rendered
     */
    public HouseBig(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates((128 * 2) * GameBlockImages.BLOCK_SIZE, 112 * GameBlockImages.BLOCK_SIZE);
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
        gameView.addBlockImageToCanvas(GameBlockImages.TrackTiles.HOUSE_BIG.blockImage(), position.getX(),
                                       position.getY(), GameBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
