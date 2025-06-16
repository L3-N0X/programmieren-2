package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Car;
import thd.gameobjects.movable.MapTile;
import thd.gameobjects.unmovable.*;

import javax.sound.sampled.LineUnavailableException;
import java.util.LinkedList;
import java.util.List;

class GameWorldManager extends GamePlayManager {
    private final List<GameObject> activatableGameObjects;

    protected GameWorldManager(GameView gameView) throws LineUnavailableException {
        super(gameView);
        car = new Car(gameView, this);
        lapTimeDisplay = new LapTimeDisplay(gameView, this);
        bestTimeDisplay = new BestTimeDisplay(gameView, this);
        lastTimeDisplay = new LastTimeDisplay(gameView, this);
        lapCounterDisplay = new LapCounterDisplay(gameView, this);
        overlay = new Overlay(gameView, this);
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
        spawnGameObject(lapCounterDisplay);
        spawnGameObject(overlay);
    }

    private void spawnGameObjectsFromWorldString() {
        String[] lines = level.world.split("\\R");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char trackTileChar = lines[i].charAt(j);
                MapTile mapMapTile = new MapTile(gameView, this, trackTileChar);
                car.addCollidingGameObjectsForPathDecision(mapMapTile);

                double tileWidthInPixels = BLOCK_SIZE * MAP_TILE_WIDTH - 1;
                double tileHeightInPixels = BLOCK_SIZE * MAP_TILE_HEIGHT - 1;

                double offsetXInPixels = TILE_OFFSET_COLUMNS_IN_BLOCKS * BLOCK_SIZE;
                double offsetYInPixels = TILE_OFFSET_LINES_IN_BLOCKS * BLOCK_SIZE;

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
        if (lines.length > 0 && !lines[0].isEmpty()) {
            int tileCountY = lines.length;
            int tileCountX = lines[0].length();

            double singleTileWidth = BLOCK_SIZE * MAP_TILE_WIDTH - 1;
            double singleTileHeight = BLOCK_SIZE * MAP_TILE_HEIGHT - 1;

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

        // Calculate the proper world bounds including offsets
        double offsetXInPixels = TILE_OFFSET_COLUMNS_IN_BLOCKS * BLOCK_SIZE;
        double offsetYInPixels = TILE_OFFSET_LINES_IN_BLOCKS * BLOCK_SIZE;

        // Calculate min/max coordinates considering the tile positioning
        double minX = -level.worldOffsetColumns * (BLOCK_SIZE * MAP_TILE_WIDTH - 1) - offsetXInPixels;
        double maxX = minX + mapPixelWidth;
        double minY = -level.worldOffsetLines * (BLOCK_SIZE * MAP_TILE_HEIGHT - 1) - offsetYInPixels;
        double maxY = minY + mapPixelHeight;

        // Calculate the car's starting position based on the start tile location
        // The car starts centered on screen, which corresponds to the start tile
        // position
        // Since the world is positioned relative to the start tile, the car's virtual
        // position in world coordinates needs to be calculated correctly
        double tileWidthInPixels = BLOCK_SIZE * MAP_TILE_WIDTH - 1;
        double tileHeightInPixels = BLOCK_SIZE * MAP_TILE_HEIGHT - 1;

        // Find the actual start tile position in world coordinates
        // The start tile is at the world offset position, which corresponds to
        // where the 'S' character is located in the level string
        double startTileWorldX = minX + (level.worldOffsetColumns * tileWidthInPixels);
        double startTileWorldY = minY + (level.worldOffsetLines * tileHeightInPixels);

        // Car starts at the center of the start tile
        double carStartX = startTileWorldX + (tileWidthInPixels / 2.0);
        double carStartY = startTileWorldY + (tileHeightInPixels / 2.0);

        // Initialize the sector tracker with proper bounds and starting position
        getSectorTracker().initializeForNewLevel(minX, maxX, minY, maxY, carStartX, carStartY);
    }
}
