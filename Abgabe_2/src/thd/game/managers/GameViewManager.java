package thd.game.managers;

import thd.game.utilities.GameView;

import java.awt.*;

public class GameViewManager {
    private final GameView gameView;
    private final GameManager gameManager;

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
