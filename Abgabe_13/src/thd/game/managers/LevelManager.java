package thd.game.managers;

import thd.game.level.*;
import thd.game.utilities.GameView;

import javax.sound.sampled.LineUnavailableException;
import java.util.List;

class LevelManager extends GameWorldManager {
    private List<Level> levels;

    protected LevelManager(GameView gameView) throws LineUnavailableException {
        super(gameView);
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
        initializeGameObjects();
        lapTimeDisplay.getGuiTimer().reset();
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

    /**
     * Resets the current level without changing to a different level.
     */
    @Override
    protected void resetCurrentLevel() {
        initializeLevel();
    }

    private void initializeGameObjects() {
        car.reset();
    }

    protected void initializeGame() {
        levels = List.of(new Level1(), new Level2(), new Level3(), new Level4(), new Level5(), new Level6());
        level = levels.get(0);
        lapTimeDisplay.getGuiTimer().stop();
    }
}
