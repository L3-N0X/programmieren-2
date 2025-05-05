package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.util.ArrayList;

/**
 * Game objects that are able to collide with other game objects.
 */
abstract class MultipleCollidingGameObject extends CollidingObject {
    private final ArrayList<CollisionBox> collisionBoxes;

    /**
     * Crates a new game object that is able to collide.
     *
     * @param gameView        Window to show the game object on.
     * @param gamePlayManager Controls the game play.
     */
    MultipleCollidingGameObject(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        collisionBoxes = new ArrayList<>();
    }

    private MultipleCollidingGameObject addCollisionBox(CollisionBox collisionBox) {
        collisionBoxes.add(collisionBox);
        return this;
    }

    /**
     * Determines if this game object currently collides with the other game object. Both hitboxes are updated before
     * detection.
     *
     * @param other The other game object.
     * @return <code>true</code> if the there was a collision.
     */
    @Override
    final boolean collidesWith(CollidingObject other) {
        for (CollisionBox collisionBox : collisionBoxes) {
            if (collisionBox.collidesWith(other)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Shows hitbox of this game object as a red rectangle.
     */
    @Override
    void showHitBox() {
        for (CollisionBox collisionBox : collisionBoxes) {
            collisionBox.showHitBox();
        }
    }
}
