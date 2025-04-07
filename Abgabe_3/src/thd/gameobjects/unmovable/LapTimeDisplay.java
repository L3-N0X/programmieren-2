package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * A Text-Display component to display the current lap time in-game.
 */
public class LapTimeDisplay extends GameObject {

    /**
     * Creates a new LapTime Object with the correct size and position.
     *
     * @param gameView the main {@link thd.game.utilities.GameView} where the text later gets added to
     */
    public LapTimeDisplay(GameView gameView) {
        super(gameView);
        size = 20;
        position.updateCoordinates(new Position(30, (int) (GameView.HEIGHT - size - 50)));
        width = 150;
        height = 50;
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("Time", position.getX(), position.getY(), size, true, Color.WHITE, rotation, "bold.ttf");
        gameView.addTextToCanvas("0:00:0", position.getX() - 8, position.getY() + size * 1.4, size, true, Color.WHITE, rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "LapTime: " + position;
    }
}
