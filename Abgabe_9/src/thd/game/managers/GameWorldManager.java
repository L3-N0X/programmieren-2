package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Car;
import thd.gameobjects.movable.Jimmy;
import thd.gameobjects.movable.MapBlockImages;
import thd.gameobjects.movable.MapTile;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

import java.util.LinkedList;
import java.util.List;

class GameWorldManager extends GamePlayManager {
    private final List<GameObject> activatableGameObjects;

    protected GameWorldManager(GameView gameView) {
        super(gameView);
        car = new Car(gameView, this);
        lapTimeDisplay = new LapTimeDisplay(gameView, this);
        bestTimeDisplay = new BestTimeDisplay(gameView, this);
        lastTimeDisplay = new LastTimeDisplay(gameView, this);
        activatableGameObjects = new LinkedList<>();
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    private void spawnGameObjects() {
        spawnGameObject(car);
        spawnGameObject(lapTimeDisplay);
        spawnGameObject(bestTimeDisplay);
        spawnGameObject(lastTimeDisplay);
        spawnGameObject(new Jimmy(gameView, this));
    }

    private void spawnGameObjectsFromWorldString() {
        String[] lines = level.world.split("\\R");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                MapBlockImages.MapTileImage trackTile = switch (lines[i].charAt(j)) {
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
                MapTile mapMapTile = new MapTile(gameView, this, trackTile);
                car.addCollidingGameObjectsForPathDecision(mapMapTile);

                double tileWidthInPixels = MapBlockImages.BLOCK_SIZE * MapBlockImages.MapTileImage.TILE_WIDTH - 1;
                double tileHeightInPixels = MapBlockImages.BLOCK_SIZE * MapBlockImages.MapTileImage.TILE_HEIGHT - 1;

                double offsetXInPixels = TILE_OFFSET_COLUMNS_IN_BLOCKS * MapBlockImages.BLOCK_SIZE;
                double offsetYInPixels = TILE_OFFSET_LINES_IN_BLOCKS * MapBlockImages.BLOCK_SIZE;

                double x = (j - level.worldOffsetColumns) * tileWidthInPixels - offsetXInPixels;
                double y = (i - level.worldOffsetLines) * tileHeightInPixels - offsetYInPixels;

                mapMapTile.getPosition().updateCoordinates(x, y);
                addActivatableGameObject(mapMapTile);
                if (false) { // wichtel
                    spawnGameObject(mapMapTile);
                }
            }
        }
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        activateGameObjects();
    }

    private void activateGameObjects() {
        for (GameObject gameObject : activatableGameObjects) {
            if (gameObject instanceof MapTile mapTile) {
                boolean shouldBeActive = mapTile.tryToActivate(mapTile);
                if (shouldBeActive && !mapTile.isActive()) {
                    mapTile.activate();
                    spawnGameObject(mapTile);
                } else if (!shouldBeActive && mapTile.isActive()) {
                    mapTile.deactivate();
                    deactivateGameObject(mapTile);
                }
            }
        }
    }

    private void calculateMapPixelSize() {
        String[] lines = level.world.split("\\R");
        if (lines.length > 0 && lines[0].length() > 0) {
            int tileCountY = lines.length;
            int tileCountX = lines[0].length();

            double singleTileWidth = MapBlockImages.BLOCK_SIZE * MapBlockImages.MapTileImage.TILE_WIDTH - 1;
            double singleTileHeight = MapBlockImages.BLOCK_SIZE * MapBlockImages.MapTileImage.TILE_HEIGHT - 1;

            this.mapPixelWidth = tileCountX * singleTileWidth;
            this.mapPixelHeight = tileCountY * singleTileHeight;
        }
    }

    protected void initializeLevel() {
        activatableGameObjects.clear();
        destroyAllGameObjects();
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
        calculateMapPixelSize();
        clearListsForPathDecisionsInGameObjects();
    }

    private void clearListsForPathDecisionsInGameObjects() {
    }
}
