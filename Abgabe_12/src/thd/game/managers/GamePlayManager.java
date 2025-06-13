package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;

/**
 * The {@link GamePlayManager} handles spawning and destroying gameObjects.
 */
public class GamePlayManager extends WorldShiftManager {
    private final GameObjectManager gameObjectManager;
    private final WorldSectorTracker sectorTracker;

    static final int TILE_OFFSET_COLUMNS_IN_BLOCKS = 0;
    static final int TILE_OFFSET_LINES_IN_BLOCKS = 68;
    /**
     * The size of one Pixel, equal for all BlockImages.
     */
    public static final double BLOCK_SIZE = 4;
    /**
     * The width of a CarTile in blocks.
     */
    public static final int MAP_TILE_HEIGHT = 112;
    /**
     * The height of a CarTile in blocks.
     */
    public static final int MAP_TILE_WIDTH = 128;

    protected int currentLap;
    /**
     * The maximum number of laps in a race.
     */
    public static final int MAX_LAPS = 3;
    private boolean lapJustCompleted;
    private int justCompletedLapNumber;

    protected GamePlayManager(GameView gameView) {
        super(gameView);
        gameObjectManager = new GameObjectManager();
        sectorTracker = new WorldSectorTracker();
        currentLap = 0;
        lapJustCompleted = false;
        justCompletedLapNumber = 0;
    }

    /**
     * This will spawn a new gameObject in the game.
     *
     * @param gameObject The gameObject that gets spawned.
     */
    @Override
    public void spawnGameObject(GameObject gameObject) {
        super.spawnGameObject(gameObject);
        gameObjectManager.add(gameObject);
    }

    /**
     * This will destroy an existing gameObject in the game.
     *
     * @param gameObject The gameObject that gets destroyed.
     */
    @Override
    public void destroyGameObject(GameObject gameObject) {
        super.destroyGameObject(gameObject);
        gameObjectManager.remove(gameObject);
        if (gameObject instanceof CollidingGameObject) {
            car.removeCollidingGameObjectsForPathDecision((CollidingGameObject) gameObject);
        }
    }

    /**
     * This will destroy an existing gameObject in the game, but keep it in shiftable.
     *
     * @param gameObject The gameObject that gets destroyed.
     */
    protected void deactivateGameObject(GameObject gameObject) {
        gameObjectManager.remove(gameObject);
    }

    @Override
    protected void destroyAllGameObjects() {
        super.destroyAllGameObjects();
        gameObjectManager.removeAll();
    }

    /**
     * Pauses the lap timer.
     */
    public void pauseLapTimer() {
        lapTimeDisplay.getGuiTimer().pause();
    }

    /**
     * Updates the timers after a round is completed. Only processes if all sectors have been visited.
     */
    public void roundCompleted() {
        boolean allSectorsVisited = sectorTracker.allSectorsVisited();

        if (!allSectorsVisited) {
            return;
        }

        lapTimeDisplay.getGuiTimer().pause();
        if (bestTimeDisplay.getGuiTimer().timeDuration() == 0
            || lapTimeDisplay.getGuiTimer().timeDuration() < bestTimeDisplay.getGuiTimer().timeDuration()) {
            bestTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());
        }
        lastTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());

        currentLap++;

        lapJustCompleted = true;
        justCompletedLapNumber = currentLap;

        if (currentLap < MAX_LAPS) {
            lapTimeDisplay.getGuiTimer().reset();
            lapTimeDisplay.getGuiTimer().start();
            sectorTracker.resetForNewLap();
        }
    }

    /**
     * Gets the current lap number.
     *
     * @return The current lap number.
     */
    public int getCurrentLap() {
        return currentLap;
    }

    protected boolean isLapJustCompleted() {
        return lapJustCompleted;
    }

    protected int getJustCompletedLapNumber() {
        return justCompletedLapNumber;
    }

    protected void clearLapCompletionFlag() {
        lapJustCompleted = false;
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameObjectManager.gameLoop();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
    }

    /**
     * Gets the sector tracker for world position monitoring.
     *
     * @return The WorldSectorTracker instance
     */
    public WorldSectorTracker getSectorTracker() {
        return sectorTracker;
    }

    @Override
    public void moveWorldToLeft(double pixels) {
        super.moveWorldToLeft(pixels);
        sectorTracker.updateVirtualCarPosition(-pixels, 0);
    }

    @Override
    public void moveWorldToRight(double pixels) {
        super.moveWorldToRight(pixels);
        sectorTracker.updateVirtualCarPosition(pixels, 0);
    }

    @Override
    public void moveWorldUp(double pixels) {
        super.moveWorldUp(pixels);
        sectorTracker.updateVirtualCarPosition(0, -pixels);
    }

    @Override
    public void moveWorldDown(double pixels) {
        super.moveWorldDown(pixels);
        sectorTracker.updateVirtualCarPosition(0, pixels);
    }
}
