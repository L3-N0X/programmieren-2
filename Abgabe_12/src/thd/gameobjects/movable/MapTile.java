package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.managers.UnexpectedWorldTileException;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.Position;
import thd.gameobjects.base.ShiftableGameObject;

import java.util.ArrayList;

/**
 * A single tile of the track.
 */
public class MapTile extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<MapTile> {
    private MapBlockImages.MapTileImage mapTileImage;
    private boolean active;

    /**
     * Creates a new track tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets
     *                        added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @param mapTileImage    the track tile which gets rendered
     */
    public MapTile(GameView gameView, GamePlayManager gamePlayManager, MapBlockImages.MapTileImage mapTileImage) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(0, 0);
        speedInPixel = 0;
        distanceToBackground = 5;
        size = GamePlayManager.BLOCK_SIZE;
        width = GamePlayManager.MAP_TILE_WIDTH * GamePlayManager.BLOCK_SIZE;
        height = GamePlayManager.MAP_TILE_HEIGHT * GamePlayManager.BLOCK_SIZE;
        active = false;
        this.mapTileImage = mapTileImage;
        super.hitBoxOffsets(0, 0, 0, 0);
    }

    /**
     * Creates a new track tile in the game at a default position. Uses a char to
     * parse a mapTile from the string
     * representation.
     *
     * @param gameView         the main {@link GameView} where the text later gets
     *                         added to
     * @param gamePlayManager  Manages the game with spawning, despawning and more.
     * @param mapTileImageChar the track tile which gets rendered, as char
     */
    public MapTile(GameView gameView, GamePlayManager gamePlayManager, char mapTileImageChar) {
        this(gameView, gamePlayManager, null);
        this.mapTileImage = switch (mapTileImageChar) {
            case 'G' -> MapBlockImages.MapTileImage.GRASS;
            case 'S' -> MapBlockImages.MapTileImage.TRACK_START_FINISH;
            case '-' -> MapBlockImages.MapTileImage.TRACK_HORIZONTAL;
            case 'N' -> MapBlockImages.MapTileImage.NECK;
            case '|' -> MapBlockImages.MapTileImage.TRACK_VERTICAL;
            case 'X' -> MapBlockImages.MapTileImage.TRACK_CROSSROAD;
            case 'R' -> MapBlockImages.MapTileImage.ROCKS_VERY_MANY;
            case 'r' -> MapBlockImages.MapTileImage.ROCKS_MANY;
            case 'Q' -> MapBlockImages.MapTileImage.ROCKS_NOT_SO_MANY;
            case 'q' -> MapBlockImages.MapTileImage.ROCKS_FEW;
            case 'H' -> MapBlockImages.MapTileImage.HOUSE_BIG;
            case 'h' -> MapBlockImages.MapTileImage.HOUSE_CORNER;
            case 'P' -> MapBlockImages.MapTileImage.POND;
            case 'D' -> MapBlockImages.MapTileImage.TRACK_BEND_RN;
            case 'C' -> MapBlockImages.MapTileImage.TRACK_BEND_RS;
            case 'd' -> MapBlockImages.MapTileImage.TRACK_BEND_LN;
            case 'c' -> MapBlockImages.MapTileImage.TRACK_BEND_LS;
            case 'B' -> MapBlockImages.MapTileImage.TRACK_BEND_LW;
            case 'A' -> MapBlockImages.MapTileImage.TRACK_BEND_RW;
            case 'b' -> MapBlockImages.MapTileImage.TRACK_BEND_RE;
            case 'a' -> MapBlockImages.MapTileImage.TRACK_BEND_LE;
            case 'V' -> MapBlockImages.MapTileImage.TRACK_DIAGONAL_SE;
            case 'v' -> MapBlockImages.MapTileImage.TRACK_DIAGONAL_NW;
            case 'u' -> MapBlockImages.MapTileImage.TRACK_DIAGONAL_SW;
            case 'U' -> MapBlockImages.MapTileImage.TRACK_DIAGONAL_NE;
            case 'M' -> MapBlockImages.MapTileImage.TRACK_CURVE_N;
            case 'm' -> MapBlockImages.MapTileImage.TRACK_CURVE_S;
            case 'w' -> MapBlockImages.MapTileImage.TRACK_CURVE_E;
            case 'W' -> MapBlockImages.MapTileImage.TRACK_CURVE_W;
            default -> throw new UnexpectedWorldTileException("The world contained an unknown tile!");
        };
    }

    MapBlockImages.MapTileImage getMapTileImage() {
        return mapTileImage;
    }

    ArrayList<MapSurface> mapSurfacesAtCarPosition(Car car) {
        ArrayList<MapSurface> mapSurfaces = new ArrayList<>();

        for (Position collisionPositionInBlocks : car.carCollisionPositionsInBlocks()) {
            double collisionX = car.getPosition().getX()
                    + collisionPositionInBlocks.getX() * GamePlayManager.BLOCK_SIZE;
            double collisionY = car.getPosition().getY()
                    + collisionPositionInBlocks.getY() * GamePlayManager.BLOCK_SIZE;

            double relativeX = collisionX - position.getX();
            double relativeY = collisionY - position.getY();

            int relativeXInBlocks = (int) (relativeX / GamePlayManager.BLOCK_SIZE);
            int relativeYInBlocks = (int) (relativeY / GamePlayManager.BLOCK_SIZE);

            if (relativeXInBlocks < 0 || relativeXInBlocks >= GamePlayManager.MAP_TILE_WIDTH) {
                break;
            }
            if (relativeYInBlocks < 0 || relativeYInBlocks >= GamePlayManager.MAP_TILE_HEIGHT) {
                break;
            }

            MapSurface mapSurface = MapSurface
                    .fromColor((mapTileImage.getBlockArray()[relativeYInBlocks][relativeXInBlocks]));
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
                position.getY(), GamePlayManager.BLOCK_SIZE, rotation);
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
        if (other instanceof Car) {
            if (mapTileImage == MapBlockImages.MapTileImage.TRACK_START_FINISH) {
                boolean atFinishLine = gamePlayManager.getSectorTracker().isCarAtFinishLine(this);
                boolean allSectorsVisited = gamePlayManager.getSectorTracker().allSectorsVisited();

                if (atFinishLine && allSectorsVisited) {
                    gamePlayManager.roundCompleted();
                }
            }
        }
    }
}
