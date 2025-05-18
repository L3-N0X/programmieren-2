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
        String minutes = minutesSinceStart();
        String seconds = secondsSinceStart();
        String hundredth = hundredthSinceStart();
        return String.format("%s:%s:%s", minutes, seconds, hundredth);
    }

    String minutesSinceStart() {
        if (startTime != -1) {
            int minutes = timeSinceStart() / 60_000 % 60;
            return String.format("%02d", minutes);
        }
        return "00";
    }

    String secondsSinceStart() {
        if (startTime != -1) {
            int seconds = timeSinceStart() / 1000 % 60;
            return String.format("%02d", seconds);
        }
        return "00";
    }

    String hundredthSinceStart() {
        if (startTime != -1) {
            int hundredth = timeSinceStart() / 100 % 10;
            return String.format("%01d", hundredth);
        }
        return "0";
    }

    private int timeSinceStart() {
        return gameView.gameTimeInMilliseconds() - startTime;
    }
}
