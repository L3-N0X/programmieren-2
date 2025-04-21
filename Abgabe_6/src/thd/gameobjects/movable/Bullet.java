package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;

import java.util.Objects;

/**
 * A simple bullet {@link GameObject}.
 */
class Bullet extends CollidingGameObject {

    /**
     * Creates a new bullet in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    Bullet(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(100, 100);
        speedInPixel = 9;
        size = 3;
        width = 6 * size;
        height = 3 * size;
        hitBoxOffsets(width / 4, height / 4, -width / 2, -height / 2);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {

    }

    Bullet(GameView gameView, GamePlayManager gamePlayManager, double x, double y, double rotation) {
        this(gameView, gamePlayManager);
        position.updateCoordinates(x, y);
        this.rotation = rotation;
    }

    @Override
    public void updatePosition() {
        double dx = Math.cos(rotation) * speedInPixel;
        double dy = Math.sin(rotation) * speedInPixel;
        position.updateCoordinates(position.getX() + dx, position.getY() + dy);
    }

    @Override
    public void updateStatus() {
        if (position.getX() > GameView.WIDTH
            || position.getY() > GameView.HEIGHT
            || position.getX() + height < 0
            || position.getY() + width < 0
        ) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas("LLLLL\nLLLLLL\nLLLLL", position.getX(), position.getY(), size,
                                       rotation / (2 * Math.PI) * 360);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, targetPosition, speedInPixel, rotation, size, width, height);
    }
}
