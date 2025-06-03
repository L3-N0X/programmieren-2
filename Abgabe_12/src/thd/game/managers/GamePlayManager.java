package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.MapTile;

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

    protected int lives;
    protected int points;

    protected GamePlayManager(GameView gameView) {
        super(gameView);
        gameObjectManager = new GameObjectManager();
        sectorTracker = new WorldSectorTracker();
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

        // Update world bounds when spawning map tiles
        if (gameObject instanceof MapTile) {
            sectorTracker.updateWorldBounds((MapTile) gameObject);
        }
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
    }

    /**
     * This will destroy an existing gameObject in the game, but keep it in
     * shiftable.
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
     * Add points to the point counter.
     *
     * @param points the amount to be added
     */
    private void addPoints(int points) {
        this.points += points;
    }

    /**
     * Decreases the life counter by one.
     */
    private void lifeLost() {
        this.lives--;
    }

    /**
     * Pauses the lap timer.
     */
    public void pauseLapTimer() {
        lapTimeDisplay.getGuiTimer().pause();
    }

    /**
     * Updates the timers after a round is completed.
     * Only processes if all sectors have been visited.
     */
    public void roundCompleted() {
        if (gameView.timer(0, 1000, this)) {
            return;
        }

        // Debug: Log sector check results
        boolean allSectorsVisited = sectorTracker.allSectorsVisited();
        System.out
                .println("[DEBUG GamePlayManager] roundCompleted() called - All sectors visited: " + allSectorsVisited +
                        ", Sectors count: " + sectorTracker.getSectorsVisitedCount() +
                        ", Visited sectors: " + sectorTracker.getVisitedSectors());

        // Only complete the round if all sectors have been visited
        if (!allSectorsVisited) {
            System.out.println("[DEBUG GamePlayManager] Lap completion DENIED - not all sectors visited!");
            return; // Invalid lap completion - not all sectors visited
        }

        System.out.println("[DEBUG GamePlayManager] Lap completion APPROVED - updating timers!");

        lapTimeDisplay.getGuiTimer().pause();
        if (bestTimeDisplay.getGuiTimer().timeDuration() == 0
                || lapTimeDisplay.getGuiTimer().timeDuration() < bestTimeDisplay.getGuiTimer().timeDuration()) {
            bestTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());
        }
        lastTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());
        lapTimeDisplay.getGuiTimer().reset();
        lapTimeDisplay.getGuiTimer().start();

        // Reset sector tracking for the new lap
        sectorTracker.resetForNewLap();
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

    /**
     * Updates the virtual car position when the world shifts.
     * Should be called from moveWorldToLeft/moveWorldUp methods.
     * 
     * @param deltaX How much the world moved horizontally
     * @param deltaY How much the world moved vertically
     */
    public void updateCarWorldPosition(double deltaX, double deltaY) {
        sectorTracker.updateVirtualCarPosition(deltaX, deltaY);
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
