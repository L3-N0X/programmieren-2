package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.LapTimer;
import thd.gameobjects.base.Position;

import java.awt.*;
import java.util.Objects;

/**
 * A Text-Display component to display the current lap time in-game.
 */
public class LapTimeDisplay extends GameObject {
    private final LapTimer lapTimer;

    /**
     * Creates a new LapTime Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public LapTimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 20;
        width = 90;
        height = 50;
        position.updateCoordinates(new Position(30, (int) (GameView.HEIGHT - size - height)));
        lapTimer = new LapTimer(gameView);
    }

    /**
     * Starts the lap timer.
     */
    public void startLap() {
        lapTimer.reset();
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("Time", position.getX(), position.getY(), size, true, Color.WHITE, rotation,
                                 "bold.ttf");
        gameView.addTextToCanvas(lapTimer.timeSinceStartFormatted(), position.getX() - 8,
                                 position.getY() + size * 1.4, size, true, Color.WHITE,
                                 rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "LapTime: " + lapTimer.timeSinceStartFormatted();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LapTimeDisplay other = (LapTimeDisplay) o;
        return super.equals(o) && Objects.equals(lapTimer, other.lapTimer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lapTimer, super.hashCode());
    }
}
