package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.managers.UnexpectedWorldTileException;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;

import java.util.ArrayList;

/**
 * A single tile of the track.
 */
public class MapTile extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<MapTile> {
    private final MapBlockImages.MapTileImage mapTileImage;
    private boolean active;

    /**
     * Creates a new track tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @param mapTileImage    the track tile which gets rendered
     */
    public MapTile(GameView gameView, GamePlayManager gamePlayManager, MapBlockImages.MapTileImage mapTileImage) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(0, 0);
        speedInPixel = 0;
        distanceToBackground = 5;
        size = MapBlockImages.BLOCK_SIZE;
        width = MapBlockImages.MapTileImage.TILE_WIDTH * MapBlockImages.BLOCK_SIZE;
        height = MapBlockImages.MapTileImage.TILE_HEIGHT * MapBlockImages.BLOCK_SIZE;
        active = false;
        this.mapTileImage = mapTileImage;
        super.hitBoxOffsets(0, 0, 0, 0);
    }

    MapBlockImages.MapTileImage getMapTileImage() {
        return mapTileImage;
    }

    ArrayList<MapSurface> mapSurfacesAtCarPosition(Car car) {
        ArrayList<MapSurface> mapSurfaces = new ArrayList<>();

        for (Position collisionPositionInBlocks : car.carCollisionPositionsInBlocks()) {
            double collisionX = car.getPosition().getX() + collisionPositionInBlocks.getX() * MapBlockImages.BLOCK_SIZE;
            double collisionY = car.getPosition().getY() + collisionPositionInBlocks.getY() * MapBlockImages.BLOCK_SIZE;

            double relativeX = collisionX - position.getX();
            double relativeY = collisionY - position.getY();

            int relativeXInBlocks = (int) (relativeX / MapBlockImages.BLOCK_SIZE);
            int relativeYInBlocks = (int) (relativeY / MapBlockImages.BLOCK_SIZE);

            if (relativeXInBlocks < 0 || relativeXInBlocks >= MapBlockImages.MapTileImage.TILE_WIDTH) {
                break;
            }
            if (relativeYInBlocks < 0 || relativeYInBlocks >= MapBlockImages.MapTileImage.TILE_HEIGHT) {
                break;
            }

            MapSurface mapSurface = switch (mapTileImage.getBlockArray()[relativeYInBlocks][relativeXInBlocks]) {
                case 'A' -> MapSurface.WATER;
                case 'D' -> MapSurface.GRASS;
                case 'E' -> MapSurface.BRICK;
                case 'F' -> MapSurface.TRACK;
                default -> throw new UnexpectedWorldTileException("Map Surface from specified color not found!");
            };
            mapSurfaces.add(mapSurface);
        }
        return mapSurfaces;
    }

    /**
     * Checks if a mapTile is a TrackTile or just a normal decorative tile.
     *
     * @return <code>true</code> if the mapTile is a track.
     */
    boolean isTrackTile() {
        return mapTileImage.toString().startsWith("TRACK");
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(mapTileImage.blockImage(), position.getX(),
                                       position.getY(), MapBlockImages.BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "MapTile: " + position + " Type: " + mapTileImage;
    }

    @Override
    public boolean tryToActivate(MapTile mapTile) {
        return position.getX() < GameView.WIDTH
               && position.getY() < GameView.HEIGHT
               && position.getX() > -width
               && position.getY() > -height
               && mapTile != null; // wichtel
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

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof Car car) {
            if (mapTileImage == MapBlockImages.MapTileImage.TRACK_START_FINISH && position.getX() > MapBlockImages.MapTileImage.TILE_WIDTH * MapBlockImages.BLOCK_SIZE + 20) {
                gamePlayManager.addPoints(1);
            }
        }
    }
}
