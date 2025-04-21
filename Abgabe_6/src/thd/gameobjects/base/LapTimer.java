package thd.gameobjects.base;

import thd.game.utilities.GameView;

/**
 * A simple lap timer for the games GUI with some helper functions for formatting time.
 */
public class LapTimer {

    private int startTime;
    private final GameView gameView;

    /**
     * Creates a new LapTimer for the GUI.
     *
     * @param gameView the gameView of the game
     */
    public LapTimer(GameView gameView) {
        this.gameView = gameView;
        startTime = -1;
    }

    /**
     * Resets the timer to zero.
     */
    public void reset() {
        startTime = gameView.gameTimeInMilliseconds();
    }

    /**
     * Calculates the time since last reset and formates the time.
     *
     * @return the time formated correctly
     */
    public String timeSinceStartFormatted() {
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
