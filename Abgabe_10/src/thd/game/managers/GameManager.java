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
            overlay.showMessage("GAME OVER");
            System.out.println("still end of game");
            if (gameView.timer(2000, 0, this)) {
                overlay.stopShowing();
                startNewGame();
            }
        } else if (endOfLevel()) {
            overlay.showMessage("GREAT JOB!");
            System.out.println("still end of level");
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

    public void startNewGame() {
        Level.difficulty = Difficulty.EASY;
        initializeGame();
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        initializeLevel();
    }
}
