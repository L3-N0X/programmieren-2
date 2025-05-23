package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.util.Objects;

/**
 * Represents an object in the game.
 */
public abstract class GameObject {

    protected final GameView gameView;
    protected final GamePlayManager gamePlayManager;
    protected final Position position;
    protected final Position targetPosition;
    protected char distanceToBackground;
    protected double speedInPixel;
    protected double rotation;
    protected double size;
    protected double width;
    protected double height;

    /**
     * Creates a new GameObject.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public GameObject(GameView gameView, GamePlayManager gamePlayManager) {
        this.gameView = gameView;
        this.gamePlayManager = gamePlayManager;
        position = new Position();
        targetPosition = new Position();
        distanceToBackground = 0;
    }

    /**
     * Updates the position of the game object.
     */
    public void updatePosition() {
    }

    /**
     * Updates the status of the game object.
     */
    public void updateStatus() {
    }

    /**
     * Draws the game object to the canvas.
     */
    public abstract void addToCanvas();

    /**
     * Returns the current position of the game object.
     *
     * @return position of the game object.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns width of game object.
     *
     * @return Width of game object
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height of game object.
     *
     * @return Height of game object
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the distance to the background. 0 = background, higher numbers = more in the foreground.
     *
     * @return distance to the background
     */
    public char getDistanceToBackground() {
        return distanceToBackground;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameObject other = (GameObject) o;
        return Objects.equals(position, other.position)
               && Objects.equals(targetPosition, other.targetPosition)
               && distanceToBackground == other.distanceToBackground
               && Double.compare(speedInPixel, other.speedInPixel) == 0
               && Double.compare(rotation, other.rotation) == 0
               && Double.compare(size, other.size) == 0
               && Double.compare(width, other.width) == 0
               && Double.compare(height, other.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, targetPosition, distanceToBackground, speedInPixel, rotation, size, width,
                            height);
    }
}
