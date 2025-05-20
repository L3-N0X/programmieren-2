package thd.game.managers;

import thd.game.utilities.GameView;

class GameManager extends LevelManager {
    private int lastPoints;

    GameManager(GameView gameView) {
        super(gameView);
        initializeGame();
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameManagement();
    }

    private void gameManagement() {
        if (endOfGame()) {
            initializeGame();
        } else if (endOfLevel()) {
            switchToNextLevel();
            initializeLevel();
        }
    }

    private boolean endOfLevel() {
        boolean levelEnd = false;
        if (points > lastPoints) {
            levelEnd = true;
        }
        lastPoints = points;
        return levelEnd;
    }

    private boolean endOfGame() {
        return lives == 0 || (!hasNextLevel() && endOfLevel());
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
