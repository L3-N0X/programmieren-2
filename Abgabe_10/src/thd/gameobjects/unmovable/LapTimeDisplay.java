package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;
import thd.gameobjects.base.TimeDisplay;

/**
 * A Text-Display component to display any time in-game.
 */
public class LapTimeDisplay extends TimeDisplay {
    /**
     * Creates a new TimeDisplay Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public LapTimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        timerLabel = "TIME";
        position.updateCoordinates(new Position(30, (int) (GameView.HEIGHT - size - height)));
    }

    /**
     * Start the lap timer, this resets the current time.
     */
    public void startLapTimer() {
        guiTimer.start();
    }
}
