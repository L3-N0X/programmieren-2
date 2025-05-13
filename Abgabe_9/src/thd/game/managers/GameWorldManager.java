package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Car;
import thd.gameobjects.movable.Jimmy;
import thd.gameobjects.movable.MapBlockImages;
import thd.gameobjects.movable.TrackTile;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

import java.util.LinkedList;
import java.util.List;

class GameWorldManager extends GamePlayManager {
    private final List<GameObject> activatableGameObjects;

    private final int tileOffsetColumnsInBlocks;
    private final int tileOffsetLinesInBlocks;

    protected GameWorldManager(GameView gameView) {
        super(gameView);
        car = new Car(gameView, this);
        lapTimeDisplay = new LapTimeDisplay(gameView, this);
        bestTimeDisplay = new BestTimeDisplay(gameView, this);
        lastTimeDisplay = new LastTimeDisplay(gameView, this);
        tileOffsetColumnsInBlocks = 0;
        tileOffsetLinesInBlocks = 68;
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
                MapBlockImages.TrackTiles trackTile = switch (lines[i].charAt(j)) {
                    case 'G' -> MapBlockImages.TrackTiles.GRASS;
                    case 'S' -> MapBlockImages.TrackTiles.START_FINISH;
                    case '-' -> MapBlockImages.TrackTiles.HORIZONTAL;
                    case 'N' -> MapBlockImages.TrackTiles.NECK;
                    case '|' -> MapBlockImages.TrackTiles.VERTICAL;
                    case 'X' -> MapBlockImages.TrackTiles.CROSSROAD;
                    case 'R' -> MapBlockImages.TrackTiles.ROCKS_VERY_MANY;
                    case 'r' -> MapBlockImages.TrackTiles.ROCKS_MANY;
                    case 'Q' -> MapBlockImages.TrackTiles.ROCKS_NOT_SO_MANY;
                    case 'q' -> MapBlockImages.TrackTiles.ROCKS_FEW;
                    case 'H' -> MapBlockImages.TrackTiles.HOUSE_BIG;
                    case 'h' -> MapBlockImages.TrackTiles.HOUSE_CORNER;
                    case 'P' -> MapBlockImages.TrackTiles.POND;
                    case 'D' -> MapBlockImages.TrackTiles.BEND_RN;
                    case 'C' -> MapBlockImages.TrackTiles.BEND_RS;
                    case 'd' -> MapBlockImages.TrackTiles.BEND_LN;
                    case 'c' -> MapBlockImages.TrackTiles.BEND_LS;
                    case 'B' -> MapBlockImages.TrackTiles.BEND_LW;
                    case 'A' -> MapBlockImages.TrackTiles.BEND_RW;
                    case 'b' -> MapBlockImages.TrackTiles.BEND_RE;
                    case 'a' -> MapBlockImages.TrackTiles.BEND_LE;
                    case 'V' -> MapBlockImages.TrackTiles.DIAGONAL_SE;
                    case 'v' -> MapBlockImages.TrackTiles.DIAGONAL_NW;
                    case 'u' -> MapBlockImages.TrackTiles.DIAGONAL_SW;
                    case 'U' -> MapBlockImages.TrackTiles.DIAGONAL_NE;
                    case 'M' -> MapBlockImages.TrackTiles.CURVE_N;
                    case 'm' -> MapBlockImages.TrackTiles.CURVE_S;
                    case 'w' -> MapBlockImages.TrackTiles.CURVE_E;
                    case 'W' -> MapBlockImages.TrackTiles.CURVE_W;
                    default -> throw new UnexpectedWorldTileException("The world contained an unknown tile!");
                };
                TrackTile mapTrackTile = new TrackTile(gameView, this, trackTile);

                double tileWidthInPixels = MapBlockImages.BLOCK_SIZE * MapBlockImages.TrackTiles.TILE_WIDTH - 1;
                double tileHeightInPixels = MapBlockImages.BLOCK_SIZE * MapBlockImages.TrackTiles.TILE_HEIGHT - 1;

                double offsetXInPixels = tileOffsetColumnsInBlocks * MapBlockImages.BLOCK_SIZE;
                double offsetYInPixels = tileOffsetLinesInBlocks * MapBlockImages.BLOCK_SIZE;

                double x = (j - level.worldOffsetColumns) * tileWidthInPixels - offsetXInPixels;
                double y = (i - level.worldOffsetLines) * tileHeightInPixels - offsetYInPixels;

                mapTrackTile.getPosition().updateCoordinates(x, y);
                addActivatableGameObject(mapTrackTile);
                if (false) { // wichtel
                    spawnGameObject(mapTrackTile);
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
            if (gameObject instanceof TrackTile trackTile) {
                boolean shouldBeActive = trackTile.tryToActivate(trackTile);
                if (shouldBeActive && !trackTile.isActive()) {
                    trackTile.activate();
                    spawnGameObject(trackTile);
                } else if (!shouldBeActive && trackTile.isActive()) {
                    trackTile.deactivate();
                    deactivateGameObject(trackTile);
                }
            }
        }
    }

    private void calculateMapPixelSize() {
        String[] lines = level.world.split("\\R");
        if (lines.length > 0 && lines[0].length() > 0) {
            int tileCountY = lines.length;
            int tileCountX = lines[0].length();

            double singleTileWidth = MapBlockImages.BLOCK_SIZE * MapBlockImages.TrackTiles.TILE_WIDTH - 1;
            double singleTileHeight = MapBlockImages.BLOCK_SIZE * MapBlockImages.TrackTiles.TILE_HEIGHT - 1;

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
