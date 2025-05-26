package thd.game.managers;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.utilities.GameView;

class GameManager extends LevelManager {
    private int lastPoints;

    GameManager(GameView gameView) {
        super(gameView);
        startNewGame();
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameManagement();
    }

    private void gameManagement() {
        if (endOfGame()) {
            if (!overlay.isMessageShown()) {
                overlay.showMessage("GAME OVER");
            }
            if (gameView.timer(2000, 0, this)) {
                overlay.stopShowing();
                startNewGame();
            }
        } else if (endOfLevel()) {
            if (!overlay.isMessageShown()) {
                overlay.showMessage("GREAT JOB!");
            }
            if (gameView.timer(2000, 0, this)) {
                lastPoints = points;
                overlay.stopShowing();
                switchToNextLevel();
                initializeLevel();
            }
        }
    }

    private boolean endOfLevel() {
        return points > lastPoints;
    }

    private boolean endOfGame() {
        return lives == 0 || (!hasNextLevel() && endOfLevel());
    }

    private void startNewGame() {
        Level.difficulty = Difficulty.STANDARD;
        car.updateParameters();
        initializeGame();
    }

    @Override
    protected void initializeLevel() {
        overlay.showMessage(level.name, 2);
        super.initializeLevel();
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        initializeLevel();
    }
}
