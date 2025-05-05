package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

/**
 * A more abstract class CollidingObject to combine everything that collides.
 */
public abstract class CollidingObject extends GameObject {
    /**
     * Crates a new game object that is able to collide.
     *
     * @param gameView        Window to show the game object on.
     * @param gamePlayManager Controls the game play.
     */
    public CollidingObject(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
    }

    /**
     * Determines if this game object currently collides with the other game object. Both hitboxes are updated before
     * detection.
     *
     * @param other The other game object.
     * @return <code>true</code> if the there was a collision.
     */
    abstract boolean collidesWith(CollidingObject other);

    /**
     * If a game object is collided with another game object, it reacts to the collision. This method needs to be
     * overridden by game objects and implemented with appropriate reactions.
     *
     * @param other The other game object that is involved in the collision.
     */
    public abstract void reactToCollisionWith(CollidingObject other);

    /**
     * Shows hitbox of this game object as a red rectangle.
     */
    abstract void showHitBox();
}
