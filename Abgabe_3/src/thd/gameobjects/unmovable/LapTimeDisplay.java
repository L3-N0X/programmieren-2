package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * A Text-Display component to display the current lap time in-game.
 */
public class LapTimeDisplay {
    private final GameView gameView;
    private final Position position;
    private final double size;
    private final double width;
    private final double height;
    private final double rotation;

    /**
     * Creates a new LapTime Object with the correct size and position.
     *
     * @param gameView the main {@link thd.game.utilities.GameView} where the text later gets added to
     */
    public LapTimeDisplay(GameView gameView) {
        this.gameView = gameView;
        size = 20;
        rotation = 0;
        position = new Position(30, (int) (GameView.HEIGHT - size - 50));
        width = 150;
        height = 50;
    }

    /**
     * Adds this object to the {@link thd.game.utilities.GameView}, this should be called each frame to update the existing object.
     */
    public void addToCanvas() {
        gameView.addTextToCanvas("Time", position.getX(), position.getY(), size, true, Color.WHITE, rotation, "bold.ttf");
        gameView.addTextToCanvas("0:00:0", position.getX() - 8, position.getY() + size * 1.4, size, true, Color.WHITE, rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "LapTime: " + position;
    }
}
