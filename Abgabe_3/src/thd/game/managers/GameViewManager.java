package thd.game.managers;

import thd.game.utilities.GameView;

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
    public GameViewManager() {
        gameView = new GameView();
        gameView.updateWindowTitle("Rally Speedway");
        gameView.updateStatusText("Leon Gött - Java Programmierung SS 2025");
        gameView.updateWindowIcon("icon.png");
        gameView.updateBackgroundColor(new Color(0x62d532));
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
