package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

class CollisionBox extends CollidingGameObject {

    /**
     * Creates a new game object that is able to collide.
     *
     * @param gameView        Window to show the game object on.
     * @param gamePlayManager Controls the game play.
     * @param offsetX         x-coordinate, relative to the game objects' x-coordinate.
     * @param offsetY         y-coordinate, relative to the game objects' y-coordinate.
     * @param offsetWidth     Width, relative to the game objects' width.
     * @param offsetHeight    Height, relative to the game objects' height.
     */
    CollisionBox(GameView gameView, GamePlayManager gamePlayManager, double offsetX, double offsetY,
                 double offsetWidth, double offsetHeight) {
        super(gameView, gamePlayManager);
        hitBoxOffsets(offsetX, offsetY, offsetWidth, offsetHeight);
    }

    @Override
    public void reactToCollisionWith(CollidingObject other) {
    }

    @Override
    public void addToCanvas() {

    }
}
