package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;

import java.util.Objects;

/**
 * A BlockImage of a house as GameObject.
 */
public class HouseBig extends CollidingGameObject {

    /**
     * Creates a new moving House BlockImage in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @see GameBlockImages for the Image that gets rendered
     */
    public HouseBig(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(2 * GameBlockImages.TrackTiles.TILE_WIDTH * GameBlockImages.BLOCK_SIZE,
                                   GameBlockImages.TrackTiles.TILE_HEIGHT * GameBlockImages.BLOCK_SIZE);
        speedInPixel = 0;
        size = GameBlockImages.BLOCK_SIZE;
        width = GameBlockImages.TrackTiles.TILE_WIDTH * GameBlockImages.BLOCK_SIZE;
        height = GameBlockImages.TrackTiles.TILE_HEIGHT * GameBlockImages.BLOCK_SIZE;
        hitBoxOffsets(8 * GameBlockImages.BLOCK_SIZE, 32 * GameBlockImages.BLOCK_SIZE, -8 * GameBlockImages.BLOCK_SIZE,
                      -8 * GameBlockImages.BLOCK_SIZE);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof Bullet) {
            gamePlayManager.addPoints(300);
            gamePlayManager.destroyGameObject(this);
        }
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, targetPosition, speedInPixel, rotation, size, width, height);
    }
}
