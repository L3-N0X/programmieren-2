package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.managers.UnexpectedWorldTileException;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * A single tile of the track.
 */
public class TrackTile extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<TrackTile> {
    private final MapBlockImages.TrackTiles trackTile;
    private boolean active;

    private enum MapSurface {
        WATER('A'),
        GRASS('D'),
        BRICK('E'),
        TRACK('F');
        private final char color;

        MapSurface(char color) {
            this.color = color;
        }

        static MapSurface fromColor(char color) {
            return switch (color) {
                case 'A' -> WATER;
                case 'D' -> GRASS;
                case 'E' -> BRICK;
                case 'F' -> TRACK;
                default -> throw new UnexpectedWorldTileException("Map Surface from color " + color + " not found!");
            };
        }
    }

    /**
     * Creates a new track tile in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     * @param trackTile       the track tile which gets rendered
     */
    public TrackTile(GameView gameView, GamePlayManager gamePlayManager, MapBlockImages.TrackTiles trackTile) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(0, 0);
        speedInPixel = 0;
        distanceToBackground = 5;
        size = MapBlockImages.BLOCK_SIZE;
        width = MapBlockImages.TrackTiles.TILE_WIDTH * MapBlockImages.BLOCK_SIZE;
        height = MapBlockImages.TrackTiles.TILE_HEIGHT * MapBlockImages.BLOCK_SIZE;
        active = false;
        this.trackTile = trackTile;
        if (this.trackTile == MapBlockImages.TrackTiles.START_FINISH) {
            super.hitBoxOffsets(0, 0, -width + 30, 0);
        } else {
            super.hitBoxOffsets(0, 0, 0, 0);
        }
    }

    private MapSurface mapSurfaceAtCarPosition(Car car) {
        //System.out.println("Position from car: X " + car.getPosition().getX() + " Y " + car.getPosition().getY());
        //System.out.println("Position from trackTile: X " + position.getX() + " Y " + position.getY());

        double relativeX = car.getPosition().getX() - position.getX();
        double relativeY = car.getPosition().getY() - position.getY();

        int relativeXInBlocks = (int) (relativeX / MapBlockImages.BLOCK_SIZE);
        int relativeYInBlocks = (int) (relativeY / MapBlockImages.BLOCK_SIZE);

        if (relativeXInBlocks < 0 || relativeXInBlocks >= MapBlockImages.TrackTiles.TILE_WIDTH) {
            System.out.print("OOB X - ");
            return MapSurface.TRACK;
        }
        if (relativeYInBlocks < 0 || relativeYInBlocks >= MapBlockImages.TrackTiles.TILE_HEIGHT) {
            System.out.print("OOB Y - ");
            return MapSurface.TRACK;
        }

        return MapSurface.fromColor(trackTile.getBlockArray()[relativeYInBlocks][relativeXInBlocks]);
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(trackTile.blockImage(), position.getX(),
                                       position.getY(), MapBlockImages.BLOCK_SIZE, rotation);
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

    @Override
    public void reactToCollisionWith(CollidingObject other) {
        if (other instanceof Car car) {
            if (this.trackTile == MapBlockImages.TrackTiles.START_FINISH) {
                gamePlayManager.addPoints(1);
            }

            // Collision with a house
            if (mapSurfaceAtCarPosition(
                    car) == MapSurface.BRICK && (trackTile == MapBlockImages.TrackTiles.HOUSE_BIG || trackTile == MapBlockImages.TrackTiles.HOUSE_CORNER)) {
                car.crash();
            }
        }
    }
}
