package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;
import thd.gameobjects.base.TimeDisplay;

/**
 * A Text-Display component to display any time in-game.
 */
public class LastTimeDisplay extends TimeDisplay {
    /**
     * Creates a new TimeDisplay Object with the correct size and position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    public LastTimeDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        timerLabel = "Last";
        position.updateCoordinates(new Position(
                (double) GameView.WIDTH / 2 - width / 2,
                (int) (GameView.HEIGHT - size - height)));
    }

    private void updateLastTimeInMilliseconds(int durationInMilliseconds) {
        guiTimer.updateDurationInMilliseconds(durationInMilliseconds);
    }
}
