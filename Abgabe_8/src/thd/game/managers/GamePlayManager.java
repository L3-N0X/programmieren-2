package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;

/**
 * The {@link GamePlayManager} handles spawning and destroying gameObjects.
 */
public class GamePlayManager extends WorldShiftManager {
    private final GameObjectManager gameObjectManager;

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
        if (gameObject instanceof CollidingGameObject) {
            car.removeCollidingGameObjectsForPathDecision((CollidingGameObject) gameObject);
        }
    }

    /**
     * This will destroy an existing gameObject in the game, but keep it in shiftable.
     *
     * @param gameObject The gameObject that gets destroyed.
     */
    public void deactivateGameObject(GameObject gameObject) {
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
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Decreases the life counter by one.
     */
    public void lifeLost() {
        this.lives--;
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
