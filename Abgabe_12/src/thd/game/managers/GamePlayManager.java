package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * The {@link GamePlayManager} handles spawning and destroying gameObjects.
 */
public class GamePlayManager extends WorldShiftManager {
    private final GameObjectManager gameObjectManager;

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
     */
    public void roundCompleted() {
        if (gameView.timer(0, 1000, this)) {
            return;
        }
        lapTimeDisplay.getGuiTimer().pause();
        if (bestTimeDisplay.getGuiTimer().timeDuration() == 0
                || lapTimeDisplay.getGuiTimer().timeDuration() < bestTimeDisplay.getGuiTimer().timeDuration()) {
            bestTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());
        }
        lastTimeDisplay.getGuiTimer().updateTimeDuration(lapTimeDisplay.getGuiTimer().timeDuration());
        lapTimeDisplay.getGuiTimer().reset();
        lapTimeDisplay.getGuiTimer().start();
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameObjectManager.gameLoop();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
    }
}
