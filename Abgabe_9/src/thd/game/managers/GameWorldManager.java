package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Car;
import thd.gameobjects.movable.GameBlockImages;
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
    }

    private void spawnGameObjectsFromWorldString() {
        String[] lines = level.world.split("\\R");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                GameBlockImages.TrackTiles trackTile = switch (lines[i].charAt(j)) {
                    case 'G' -> GameBlockImages.TrackTiles.GRASS;
                    case 'S' -> GameBlockImages.TrackTiles.START_FINISH;
                    case '-' -> GameBlockImages.TrackTiles.HORIZONTAL;
                    case 'N' -> GameBlockImages.TrackTiles.NECK;
                    case '|' -> GameBlockImages.TrackTiles.VERTICAL;
                    case 'X' -> GameBlockImages.TrackTiles.CROSSROAD;
                    case 'R' -> GameBlockImages.TrackTiles.ROCKS_VERY_MANY;
                    case 'r' -> GameBlockImages.TrackTiles.ROCKS_MANY;
                    case 'Q' -> GameBlockImages.TrackTiles.ROCKS_NOT_SO_MANY;
                    case 'q' -> GameBlockImages.TrackTiles.ROCKS_FEW;
                    case 'H' -> GameBlockImages.TrackTiles.HOUSE_BIG;
                    case 'h' -> GameBlockImages.TrackTiles.HOUSE_CORNER;
                    case 'P' -> GameBlockImages.TrackTiles.POND;
                    case 'D' -> GameBlockImages.TrackTiles.BEND_RN;
                    case 'C' -> GameBlockImages.TrackTiles.BEND_RS;
                    case 'd' -> GameBlockImages.TrackTiles.BEND_LN;
                    case 'c' -> GameBlockImages.TrackTiles.BEND_LS;
                    case 'B' -> GameBlockImages.TrackTiles.BEND_LW;
                    case 'A' -> GameBlockImages.TrackTiles.BEND_RW;
                    case 'b' -> GameBlockImages.TrackTiles.BEND_RE;
                    case 'a' -> GameBlockImages.TrackTiles.BEND_LE;
                    case 'V' -> GameBlockImages.TrackTiles.DIAGONAL_SE;
                    case 'v' -> GameBlockImages.TrackTiles.DIAGONAL_NW;
                    case 'u' -> GameBlockImages.TrackTiles.DIAGONAL_SW;
                    case 'U' -> GameBlockImages.TrackTiles.DIAGONAL_NE;
                    case 'M' -> GameBlockImages.TrackTiles.CURVE_N;
                    case 'm' -> GameBlockImages.TrackTiles.CURVE_S;
                    case 'w' -> GameBlockImages.TrackTiles.CURVE_E;
                    case 'W' -> GameBlockImages.TrackTiles.CURVE_W;
                    default -> throw new UnexpectedWorldTileException("The world contained an unknown tile!");
                };
                TrackTile mapTrackTile = new TrackTile(gameView, this, trackTile);

                double tileWidthInPixels = GameBlockImages.BLOCK_SIZE * GameBlockImages.TrackTiles.TILE_WIDTH - 1;
                double tileHeightInPixels = GameBlockImages.BLOCK_SIZE * GameBlockImages.TrackTiles.TILE_HEIGHT - 1;

                double offsetXInPixels = tileOffsetColumnsInBlocks * GameBlockImages.BLOCK_SIZE;
                double offsetYInPixels = tileOffsetLinesInBlocks * GameBlockImages.BLOCK_SIZE;

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

    protected void initializeLevel() {
        activatableGameObjects.clear();
        destroyAllGameObjects();
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
        clearListsForPathDecisionsInGameObjects();
    }

    private void clearListsForPathDecisionsInGameObjects() {
    }
}
