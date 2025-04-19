package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * A simple square {@link GameObject}
 */
public class Square extends GameObject {

    /**
     * Creates a new Square in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public Square(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(100, 100);
        speedInPixel = 5;
        size = GameBlockImages.BLOCK_SIZE;
        width = 30;
        height = 30;
    }

    @Override
    public void updatePosition() {
        position.right(speedInPixel);
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
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 3, false, Color.RED);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
