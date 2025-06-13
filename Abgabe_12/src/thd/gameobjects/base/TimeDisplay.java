package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * A Text-Display component to display any time in-game.
 */
public abstract class TimeDisplay extends GameObject {
    private final GuiTimer guiTimer;
    protected String timerLabel;

    protected final Position defaultPosition;

    private Color textColor;
    private int flashCount;

    /**
     * Creates a new TimeDisplay Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public TimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 25;
        width = size * 4.3;
        height = size * 1.5;
        distanceToBackground = 30;
        timerLabel = "Timer";
        textColor = Color.WHITE;
        defaultPosition = new Position(30, (int) (GameView.HEIGHT - size - height));
        guiTimer = new GuiTimer(gameView);
        placeAtDefaultPosition();
    }

    /**
     * Places the timer at the default position.
     */
    public void placeAtDefaultPosition() {
        position.updateCoordinates(defaultPosition.getX(), defaultPosition.getY());
    }

    @Override
    public void updatePosition() {
        Position shakeOffset = gamePlayManager.getShakeOffset();
        position.updateCoordinates(
                defaultPosition.getX() + shakeOffset.getX(),
                defaultPosition.getY() + shakeOffset.getY()
        );
    }

    @Override
    public void addToCanvas() {
        if (guiTimer.isUpdated() && gameView.timer(500, 0, this)) {
            textColor = textColor.equals(Color.WHITE) ? Color.RED : Color.WHITE;
            flashCount++;
        }
        gameView.addTextToCanvas(timerLabel, position.getX(), position.getY(), size, true, textColor, rotation,
                                 "kongtext.ttf");

        gameView.addTextToCanvas(guiTimer.minutesSinceStart(),
                                 position.getX() - size,
                                 position.getY() + size * 1.2,
                                 size, true, textColor, rotation, "kongtext.ttf");

        gameView.addTextToCanvas(":",
                                 position.getX() + size * 0.8,
                                 position.getY() + size * 1.2,
                                 size, true, textColor, rotation, "kongtext.ttf");

        gameView.addTextToCanvas(guiTimer.secondsSinceStart(),
                                 position.getX() + size * 1.6,
                                 position.getY() + size * 1.2,
                                 size, true, textColor, rotation, "kongtext.ttf");

        gameView.addTextToCanvas(":",
                                 position.getX() + size * 3.5,
                                 position.getY() + size * 1.2,
                                 size, true, textColor, rotation, "kongtext.ttf");

        gameView.addTextToCanvas(guiTimer.hundredthSinceStart(),
                                 position.getX() + size * 4.3,
                                 position.getY() + size * 1.2,
                                 size, true, textColor, rotation, "kongtext.ttf");

        if (flashCount > 5) {
            flashCount = 0;
            guiTimer.resetUpdated();
        }
    }

    /**
     * Returns the {@link GuiTimer} of this TimeDisplay, which is used to keep track of the time and control the timer.
     *
     * @return the {@link GuiTimer} of this TimeDisplay.
     */
    public GuiTimer getGuiTimer() {
        return guiTimer;
    }

    @Override
    public String toString() {
        return "Time: " + guiTimer.timeDurationFormatted();
    }
}
