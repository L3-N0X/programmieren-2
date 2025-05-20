package thd.game.managers;

import thd.game.level.*;
import thd.game.utilities.GameView;

import java.util.List;

class LevelManager extends GameWorldManager {
    private List<Level> levels;
    private static final int LIVES = 1;

    protected LevelManager(GameView gameView) {
        super(gameView);
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
        initializeGameObjects();
        overlay.showMessage(level.name, 4);
    }

    protected boolean hasNextLevel() {
        return level.number < levels.size();
    }

    protected void switchToNextLevel() {
        if (hasNextLevel()) {
            level = levels.get(levels.indexOf(level) + 1);
        } else {
            throw new NoMoreLevelsAvailableException(
                    "You've reached the last level! There are no further levels implemented yet!");
        }
    }

    private void initializeGameObjects() {
        car.reset();
    }

    protected void initializeGame() {
        levels = List.of(new Level1(), new Level2(), new Level3());
        level = levels.get(0);
        lives = LIVES;
        points = 0;
    }
}
