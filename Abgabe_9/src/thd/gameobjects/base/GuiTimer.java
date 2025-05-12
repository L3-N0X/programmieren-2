package thd.gameobjects.base;

import thd.game.utilities.GameView;

/**
 * A simple lap timer for the games GUI with some helper functions for formatting time.
 */
public class GuiTimer {

    private int startTime;
    private final GameView gameView;

    /**
     * Creates a new GuiTimer for the GUI.
     *
     * @param gameView the gameView of the game
     */
    public GuiTimer(GameView gameView) {
        this.gameView = gameView;
        startTime = -1;
    }

    /**
     * Resets the timer to zero, this starts the timer.
     */
    public void resetAndStart() {
        startTime = gameView.gameTimeInMilliseconds();
    }

    /**
     * Sets the time to a duration which is then displayed.
     *
     * @param durationInMilliseconds the duration in milliseconds.
     */
    public void updateDurationInMilliseconds(int durationInMilliseconds) {
        startTime = gameView.gameTimeInMilliseconds() - durationInMilliseconds;
    }

    /**
     * Calculates the time since last resetAndStart and formates the time.
     *
     * @return the time formated correctly
     */
    String timeSinceStartFormatted() {
        if (startTime != -1) {
            int timeSinceStart = timeSinceStart();
            int minutes = timeSinceStart / 60_000 % 60;
            int seconds = timeSinceStart / 1000 % 60;
            int hundredth = timeSinceStart / 100 % 10;
            return String.format("%01d:%02d:%01d", minutes, seconds, hundredth);
        } else {
            return "0:00:0";
        }
    }

    private int timeSinceStart() {
        return gameView.gameTimeInMilliseconds() - startTime;
    }
}
