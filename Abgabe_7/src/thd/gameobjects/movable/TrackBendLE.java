package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A background tile of a rock formation with many rocks.
 */
public class TrackBendLE extends GameObject {

    /**
     * Creates a new moving Rock tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public TrackBendLE(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(GameBlockImages.TrackTiles.TILE_WIDTH * GameBlockImages.BLOCK_SIZE, 0);
        speedInPixel = 0;
        size = GameBlockImages.BLOCK_SIZE;
        width = GameBlockImages.TrackTiles.TILE_WIDTH * GameBlockImages.BLOCK_SIZE;
        height = GameBlockImages.TrackTiles.TILE_HEIGHT * GameBlockImages.BLOCK_SIZE;
    }

    @Override
    public void updatePosition() {
        position.left(speedInPixel);
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(GameBlockImages.TrackTiles.BEND_LE.blockImage(), position.getX(),
                                       position.getY(), GameBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }

    //@Override
    //public boolean equals(Object o) {
    //    if (o == this) {
    //        return true;
    //    }
    //    if (o == null || getClass() != o.getClass()) {
    //        return false;
    //    }
    //    return super.equals(o);
    //}
}
