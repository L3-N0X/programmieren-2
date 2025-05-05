package thd.gameobjects.base;

/**
 * This interface resembles a game object which gets activated only at certain conditions. For this condition, the game
 * object with type T is used.
 *
 * @param <T> the type of game object.
 */
public interface ActivatableGameObject<T> {
    /**
     * Check if the activatable game object already needs to be activated.
     *
     * @param info the info required for activation.
     * @return <code>true</code> when the game object gets activated.
     */
    boolean tryToActivate(T info);
}
