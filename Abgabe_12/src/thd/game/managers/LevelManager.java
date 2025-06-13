package thd.game.managers;

import thd.game.level.*;
import thd.game.utilities.GameView;

import javax.sound.sampled.LineUnavailableException;
import java.util.List;

class LevelManager extends GameWorldManager {
    private List<Level> levels;
    private static final int LIVES = 1;

    protected LevelManager(GameView gameView) throws LineUnavailableException {
        super(gameView);
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
        initializeGameObjects();
        lapTimeDisplay.getGuiTimer().reset();
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

    /**
     * Cycles to the next level in the list of levels.
     */
    @Override
    protected void cycleToNextLevel() {
        level = levels.get((levels.indexOf(level) + 1) % levels.size());
        initializeLevel();
    }

    /**
     * Cycles to the previous level in the list of levels.
     */
    @Override
    protected void cycleToPreviousLevel() {
        level = levels.get((levels.indexOf(level) - 1 + levels.size()) % levels.size());
        initializeLevel();
    }

    private void initializeGameObjects() {
        car.reset();
    }

    protected void initializeGame() {
        levels = List.of(new Level1(), new Level2(), new Level3());
        level = levels.get(0);
        lives = LIVES;
        points = 0;
        lapTimeDisplay.getGuiTimer().stop();
    }
}
