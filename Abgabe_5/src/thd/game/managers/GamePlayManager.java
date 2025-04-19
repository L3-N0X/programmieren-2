package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Square;

/**
 * The {@link GamePlayManager} handles spawning and destroying gameObjects.
 */
public class GamePlayManager extends UserControlledGameObjectPool {
    private final GameObjectManager gameObjectManager;
    private int currentNumberOfVisibleSquares;

    protected GamePlayManager(GameView gameView) {
        super(gameView);
        gameObjectManager = new GameObjectManager();
    }

    /**
     * This will spawn a new gameObject in the game.
     *
     * @param gameObject The gameObject that gets spawned.
     */
    public void spawnGameObject(GameObject gameObject) {
        gameObjectManager.add(gameObject);
    }

    /**
     * This will destroy a existing gameObject in the game.
     *
     * @param gameObject The gameObject that gets destroyed.
     */
    public void destroyGameObject(GameObject gameObject) {
        gameObjectManager.remove(gameObject);
    }

    protected void destroyAllGameObjects() {
        gameObjectManager.removeAll();
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameObjectManager.gameLoop();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
        if (gameView.timer(1000, 1, this) && currentNumberOfVisibleSquares < 5) {
            spawnGameObject(new Square(gameView, this));
            currentNumberOfVisibleSquares++;
        }
    }
}
