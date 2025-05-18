package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * A Text-Display component to display any time in-game.
 */
public abstract class TimeDisplay extends GameObject {
    protected final GuiTimer guiTimer;
    protected String timerLabel;

    /**
     * Creates a new TimeDisplay Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public TimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 20;
        width = 90;
        height = 50;
        distanceToBackground = 30;
        timerLabel = "Timer";
        position.updateCoordinates(new Position(30, (int) (GameView.HEIGHT - size - height)));
        guiTimer = new GuiTimer(gameView);
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(timerLabel, position.getX(), position.getY(), size, true, Color.WHITE, rotation,
                                 "bold.ttf");

        gameView.addTextToCanvas(guiTimer.minutesSinceStart(),
                                 position.getX() - size,
                                 position.getY() + size * 1.4,
                                 size, true, Color.WHITE, rotation, "bold.ttf");

        gameView.addTextToCanvas(":",
                                 position.getX() + size * 1.2,
                                 position.getY() + size * 1.4,
                                 size, true, Color.WHITE, rotation, "bold.ttf");

        gameView.addTextToCanvas(guiTimer.secondsSinceStart(),
                                 position.getX() + size * 1.6,
                                 position.getY() + size * 1.4,
                                 size, true, Color.WHITE, rotation, "bold.ttf");

        gameView.addTextToCanvas(":",
                                 position.getX() + size * 4,
                                 position.getY() + size * 1.4,
                                 size, true, Color.WHITE, rotation, "bold.ttf");

        gameView.addTextToCanvas(guiTimer.hundredthSinceStart(),
                                 position.getX() + size * 4.5,
                                 position.getY() + size * 1.4,
                                 size, true, Color.WHITE, rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "Time: " + guiTimer.timeSinceStartFormatted();
    }
}
