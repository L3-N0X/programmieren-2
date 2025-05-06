package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * A single tile of the track.
 */
public class TrackTile extends GameObject implements ShiftableGameObject, ActivatableGameObject<TrackTile> {
    private final GameBlockImages.TrackTiles trackTile;
    private boolean active;

    /**
     * Creates a new track tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @param trackTile       the track tile which gets rendered
     */
    public TrackTile(GameView gameView, GamePlayManager gamePlayManager, GameBlockImages.TrackTiles trackTile) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(0, 0);
        speedInPixel = 0;
        distanceToBackground = 5;
        size = GameBlockImages.BLOCK_SIZE;
        width = GameBlockImages.TrackTiles.TILE_WIDTH * GameBlockImages.BLOCK_SIZE;
        height = GameBlockImages.TrackTiles.TILE_HEIGHT * GameBlockImages.BLOCK_SIZE;
        active = false;
        this.trackTile = trackTile;
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(trackTile.blockImage(), position.getX(),
                                       position.getY(), GameBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "TrackTile: " + position;
    }

    @Override
    public boolean tryToActivate(TrackTile trackTile) {
        return position.getX() < GameView.WIDTH
               && position.getY() < GameView.HEIGHT
               && position.getX() > -width
               && position.getY() > -height
               && trackTile != null; // wichtel
    }

    @Override
    public void deactivate() {
        active = false;
    }

    @Override
    public void activate() {
        active = true;
    }

    @Override
    public boolean isActive() {
        return active;
    }
}
