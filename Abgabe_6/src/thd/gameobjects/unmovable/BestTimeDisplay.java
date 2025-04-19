package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * A Text-Display component to display the current lap time in-game.
 */
public class BestTimeDisplay extends GameObject {

    /**
     * Creates a new LapTime Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public BestTimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 20;
        width = 90;
        height = 50;
        position.updateCoordinates(new Position(GameView.WIDTH - width - 30, (int) (GameView.HEIGHT - size - height)));
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("BEST", position.getX(), position.getY(), size, true, Color.WHITE, rotation,
                                 "bold.ttf");
        gameView.addTextToCanvas("0:00:0", position.getX() - 8, position.getY() + size * 1.4, size, true, Color.WHITE,
                                 rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "LapTime: " + position;
    }
}
