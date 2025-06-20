package thd.game.managers;

import thd.game.utilities.GameView;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;

/**
 * Manages the GameView and has the main game loop to plot each frame.
 */
public class GameViewManager {
    private final GameView gameView;
    private final GameManager gameManager;

    /**
     * Creates a new GameView, does its setup and starts the main game loop.
     */
    public GameViewManager() throws LineUnavailableException {
        gameView = new GameView();
        gameView.updateWindowTitle("Rally Speedway");
        gameView.updateStatusText("Leon Gött - Java Programmierung SS 2025");
        gameView.updateWindowIcon("icon.png");

        gameView.updateColorForBlockImage('A', new Color(44, 61, 236));
        gameView.updateColorForBlockImage('D', new Color(98, 213, 50));
        gameView.updateColorForBlockImage('E', new Color(175, 60, 88));
        gameView.updateColorForBlockImage('F', new Color(205, 205, 205));
        gameView.updateColorForBlockImage('H', new Color(238, 123, 149));
        gameView.updateColorForBlockImage('I', new Color(255, 255, 70));

        gameManager = new GameManager(gameView);
        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            gameManager.gameLoop();
            gameView.plotCanvas();
        }
    }
}
