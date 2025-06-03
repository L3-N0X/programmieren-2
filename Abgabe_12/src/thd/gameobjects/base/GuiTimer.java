package thd.gameobjects.base;

import thd.game.utilities.GameView;

import java.util.Objects;

/**
 * A simple lap timer for the games GUI with some helper functions for formatting time.
 */
public class GuiTimer implements Comparable<GuiTimer> {

    private final GameView gameView;

    private enum State {
        STOPPED,
        RUNNING,
        PAUSED
    }

    private State state;
    private long startTimeMillis;
    private long beforePauseTimeMillis;

    /**
     * Creates a new GuiTimer for the GUI.
     *
     * @param gameView the gameView of the game
     */
    GuiTimer(GameView gameView) {
        this.gameView = gameView;
        state = State.STOPPED;
        startTimeMillis = 0;
        beforePauseTimeMillis = 0;
    }

    /**
     * Starts the timer.
     */
    public void start() {
        if (this.state == State.STOPPED || this.state == State.PAUSED) {
            this.startTimeMillis = gameView.gameTimeInMilliseconds();
            this.state = State.RUNNING;
        }
    }

    /**
     * Pauses the timer.
     */
    public void pause() {
        if (this.state == State.RUNNING) {
            this.beforePauseTimeMillis += (gameView.gameTimeInMilliseconds() - this.startTimeMillis);
            this.startTimeMillis = 0;
            this.state = State.PAUSED;
        }
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        if (this.state == State.RUNNING) {
            this.beforePauseTimeMillis += (gameView.gameTimeInMilliseconds() - this.startTimeMillis);
            this.startTimeMillis = 0;
        }

        if (this.state != State.STOPPED) {
            this.state = State.STOPPED;
        }
    }

    /**
     * Resets the timer. Sets the elapsed duration to zero and the state to STOPPED.
     */
    public void reset() {
        this.startTimeMillis = 0;
        this.beforePauseTimeMillis = 0;
        this.state = State.STOPPED;
    }

    /**
     * Calculates the total elapsed duration in milliseconds based on the current state. This is the duration the timer
     * currently shows.
     *
     * @return The total elapsed duration in milliseconds.
     */
    public long timeDuration() {
        if (this.state == State.RUNNING) {
            return beforePauseTimeMillis + (gameView.gameTimeInMilliseconds() - this.startTimeMillis);
        } else {
            return beforePauseTimeMillis;
        }
    }

    /**
     * Sets the timer to the given duration in milliseconds.
     *
     * @param durationMillis The duration in milliseconds to set the timer to.
     */
    public void updateTimeDuration(long durationMillis) {
        if (durationMillis < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.beforePauseTimeMillis = durationMillis;
        this.startTimeMillis = 0;
        this.state = State.PAUSED;
    }

    /**
     * Formats the current timer duration.
     *
     * @return The current duration formatted as mm:ss:d
     */
    String timeDurationFormatted() {
        String minutes = minutesSinceStart();
        String seconds = secondsSinceStart();
        String hundredth = hundredthSinceStart();
        return String.format("%s:%s:%s", minutes, seconds, hundredth);
    }

    String minutesSinceStart() {
        long minutes = timeDuration() / 60_000 % 60;
        return String.format("%02d", minutes);
    }

    String secondsSinceStart() {
        long seconds = timeDuration() / 1000 % 60;
        return String.format("%02d", seconds);
    }

    String hundredthSinceStart() {
        long hundredth = timeDuration() / 100 % 10;
        return String.format("%01d", hundredth);
    }

    @Override
    public int compareTo(GuiTimer other) {
        return Long.compare(this.timeDuration(), other.timeDuration());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GuiTimer other = (GuiTimer) o;
        return state == other.state
               && startTimeMillis == other.startTimeMillis
               && beforePauseTimeMillis == other.beforePauseTimeMillis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, startTimeMillis, beforePauseTimeMillis);
    }
}
