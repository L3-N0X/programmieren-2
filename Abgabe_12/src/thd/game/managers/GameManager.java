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
        if (lapCompleted()) {
            if (!overlay.isMessageShown()) {
                gameView.playSound("complete.wav", false);
                overlay.showMessage(lapCompletionMessage(getJustCompletedLapNumber()));
            }
            if (gameView.timer(2000, 0, this)) {
                overlay.stopShowing();
                clearLapCompletionFlag();
                if (endOfGame()) {

                    return;
                }
            }
        } else if (endOfGame()) {
            gameView.updateBackgroundColor(Color.BLACK);
            if (!overlay.isMessageShown()) {
                gameView.playSound("gameover.wav", false);
                overlay.showMessage("GAME OVER");
            }
            if (gameView.timer(2000, 0, this)) {
                overlay.stopShowing();
                Screens.showEndScreen(
                        gameView,
                        "Rennen auf Map " + level.name + " erfolgreich beendet!"
                        + "\nIhre beste Zeit: " + bestTimeDisplay.getGuiTimer().timeDurationFormatted()
                        + "\n\nWählen Sie \"Neues Spiel\", um ein weiteres Rennen zu starten!");
                startNewGame();
            }
        }
    }

    private boolean lapCompleted() {
        return isLapJustCompleted();
    }

    private boolean endOfGame() {
        return currentLap == MAX_LAPS;
    }

    private String lapCompletionMessage(int lapNumber) {
        return switch (lapNumber) {
            case 1 -> "Lap 1 Complete!";
            case 2 -> "Lap 2 Complete!";
            case 3 -> "Final Lap Complete!";
            default -> "Lap Complete!";
        };
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
