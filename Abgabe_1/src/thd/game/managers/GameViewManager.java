package thd.game.managers;

import thd.game.utilities.GameView;

public class GameViewManager {
    private final GameView gameView;
    private final GameManager gameManager;

    public GameViewManager() {
        gameView = new GameView();
        gameView.updateWindowTitle("Rally Speedway");
        gameView.updateStatusText("Leon Gött - Java Programmierung SS 2025");
        gameView.updateWindowIcon(gameView.readTextFileFromResources("icon.png"));
        gameManager = new GameManager(gameView);
        gameManager.startGameLoop();
    }
}
