package thd.game.managers;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.utilities.FileAccess;
import thd.game.utilities.GameView;
import thd.screens.GameInfo;
import thd.screens.Screens;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.util.Objects;

class GameManager extends LevelManager {
    private int lastPoints;

    GameManager(GameView gameView) throws LineUnavailableException {
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
                gameView.playSound("gameover.wav", false);
                overlay.showMessage("GAME OVER");
            }
            if (gameView.timer(2000, 0, this)) {
                overlay.stopShowing();
                Screens.showEndScreen(
                        gameView,
                        "Rennen erfolgreich beendet! Sie haben " + points + " Punkte erreicht.");
                startNewGame();
            }
        } else if (endOfLevel()) {
            if (!overlay.isMessageShown()) {
                gameView.playSound("complete.wav", false);
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
        Level.difficulty = FileAccess.readDifficultyFromDisc();
        String selection = Screens.showStartScreen(gameView, GameInfo.TITLE, GameInfo.DESCRIPTION,
                                                   Level.difficulty.name);
        if (!Objects.equals(selection, "Beenden")) {
            Level.difficulty = Difficulty.fromName(selection);
        }

        FileAccess.writeDifficultyToDisc(Level.difficulty);
        car.updateParameters();
        initializeGame();
    }

    @Override
    protected void initializeLevel() {
        overlay.stopShowing();
        overlay.showMessage(level.name, 2);
        super.initializeLevel();
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        gameView.updateBackgroundColor(new Color(0x62d532));
        initializeLevel();
    }
}
