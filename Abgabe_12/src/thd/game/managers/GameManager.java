package thd.game.managers;

import thd.game.level.ColorPalette;
import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.utilities.FileAccess;
import thd.game.utilities.GameView;
import thd.game.utilities.PlayerScore;
import thd.screens.GameInfo;
import thd.screens.Screens;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.util.Objects;

/**
 * Manages the game logic, including level management, lap tracking, and game state.
 */
public class GameManager extends LevelManager {
    private static final char[] STANDARD_CHARS = {'A', 'D', 'E', 'F', 'H', 'I'};
    private static final char[][] LEVEL_CHARS = {
            {'A', 'D', 'E', 'F', 'H', 'I'}, // Level 1 (original)
            {'J', 'K', 'l', 'M', 'N', 'O'}, // Level 2
            {'P', 'Q', 'R', 'S', 'T', 'U'}, // Level 3
            {'V', 'q', 'X', 'Y', 'Z', 'a'}, // Level 4
            {'b', 'c', 'd', 'e', 'f', 'g'} // Level 5
    };

    GameManager(GameView gameView) throws LineUnavailableException {
        super(gameView);
        startNewGame();
    }

    /**
     * Translates block image characters to level-specific characters to ensure different cache entries for different
     * color palettes.
     *
     * @param blockImage   the original block image string
     * @param currentLevel the current level to translate for
     * @return the translated block image string with level-specific characters
     */
    public static String translateBlockImageForLevel(String blockImage, thd.game.level.Level currentLevel) {
        if (currentLevel == null || currentLevel.number == 1) {
            return blockImage; // Level 1 uses original characters
        }

        StringBuilder translated = new StringBuilder();
        char[] levelChars = LEVEL_CHARS[currentLevel.number - 1];

        for (char c : blockImage.toCharArray()) {
            char translatedChar = c;
            for (int i = 0; i < STANDARD_CHARS.length; i++) {
                if (c == STANDARD_CHARS[i]) {
                    translatedChar = levelChars[i];
                    break;
                }
            }
            translated.append(translatedChar);
        }
        return translated.toString();
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

                // Always offer name input for score saving
                String playerName = Screens.showNameInputScreen(gameView, GameInfo.ENTER_NAME_MESSAGE);

                if (!playerName.isEmpty()) {
                    PlayerScore newScore = new PlayerScore(
                            playerName,
                            bestTimeDisplay.getGuiTimer().timeDuration(),
                            level.name,
                            level.number,
                            java.time.LocalDateTime.now(),
                            Level.difficulty.name);
                    FileAccess.writePlayerScore(newScore);
                }

                Screens.showEndScreen(
                        gameView,
                        String.format(
                                GameInfo.END_SCREEN_MESSAGE,
                                level.name, bestTimeDisplay.getGuiTimer().timeDurationFormatted()));
                startNewGame();
            }
        }
    }

    private boolean lapCompleted() {
        return isLapJustCompleted();
    }

    private boolean endOfGame() {
        return currentLap >= MAX_LAPS;
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

        if (Objects.equals(selection, GameInfo.BEST_LIST_BUTTON)) {
            Screens.showBestListScreen(gameView);
            startNewGame(); // Return to menu after viewing
            return;
        } else if (!Objects.equals(selection, GameInfo.EXIT_BUTTON)) {
            Level.difficulty = Difficulty.fromName(selection);
        }

        thd.game.utilities.FileAccess.writeDifficultyToDisc(Level.difficulty);
        initializeGame();
    }

    @Override
    protected void initializeLevel() {
        overlay.stopShowing();
        overlay.showMessage(level.name, 2);
        super.initializeLevel();

        resetCurrentLap();
        updateColorPalette(level.colorPalette);
        car.updateParameters(level.roadCondition);
    }

    /**
     * Updates the color palette of the game view.
     *
     * @param colorPalette the new color palette to update the game view with.
     */
    private void updateColorPalette(ColorPalette colorPalette) {
        char[] levelChars = levelCharacterSet(level.number);

        gameView.updateColorForBlockImage(levelChars[0], colorPalette.colorAt(0));
        gameView.updateColorForBlockImage(levelChars[1], colorPalette.colorAt(1));
        gameView.updateColorForBlockImage(levelChars[2], colorPalette.colorAt(2));
        gameView.updateColorForBlockImage(levelChars[3], colorPalette.colorAt(3));
        gameView.updateColorForBlockImage(levelChars[4], colorPalette.colorAt(4));
        gameView.updateColorForBlockImage(levelChars[5], colorPalette.colorAt(5));
    }

    /**
     * Gets the character set for a specific level.
     *
     * @param levelNumber the level number
     * @return the character array for that level
     */
    private char[] levelCharacterSet(int levelNumber) {
        return LEVEL_CHARS[levelNumber - 1];
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        gameView.updateBackgroundColor(new Color(0x62d532));
        initializeLevel();
    }
}
