package thd.game.utilities;

import thd.game.level.Difficulty;
import thd.gameobjects.base.PlayerScore;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to read and write the game difficulty and player scores to a file on the disc.
 */
public class FileAccess {
    private static final Path SAVEGAME_DIRECTORY = Path.of(System.getProperty("user.home")).resolve("game");
    private static final String SAVEGAME_FILENAME = "leon_goett_game.txt";
    /**
     * The file where the game difficulty and player scores are saved.
     */
    public static final Path SAVEGAME_FILE = SAVEGAME_DIRECTORY.resolve(SAVEGAME_FILENAME);

    private static final String SEPARATOR = "---SCORES---";

    /**
     * Writes the given difficulty to a file on the disc.
     *
     * @param difficulty the difficulty to write to disc
     */
    public static void writeDifficultyToDisc(Difficulty difficulty) {
        List<PlayerScore> scores = readPlayerScores();
        writeGameData(difficulty, scores);
    }

    /**
     * Reads the difficulty from a file on the disc.
     *
     * @return the difficulty read from the disc, or Difficulty.STANDARD if no file exists or the file is empty
     */
    public static Difficulty readDifficultyFromDisc() {
        if (Files.exists(SAVEGAME_FILE)) {
            try {
                String content = Files.readString(SAVEGAME_FILE);
                String[] parts = content.split(SEPARATOR);
                String difficultyLine = parts[0].trim();

                if (!difficultyLine.isEmpty()) {
                    for (Difficulty diff : Difficulty.values()) {
                        if (diff.name().equals(difficultyLine)) {
                            return diff;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Difficulty.STANDARD;
    }

    /**
     * Writes a player score to the disc.
     *
     * @param score the player score to write
     */
    public static void writePlayerScore(PlayerScore score) {
        List<PlayerScore> scores = readPlayerScores();
        scores.add(score);
        Difficulty difficulty = readDifficultyFromDisc();
        writeGameData(difficulty, scores);
    }

    /**
     * Reads all player scores from the disc.
     *
     * @return list of player scores, empty list if none exist
     */
    public static List<PlayerScore> readPlayerScores() {
        if (!Files.exists(SAVEGAME_FILE)) {
            return new ArrayList<>();
        }

        try {
            String content = Files.readString(SAVEGAME_FILE);
            String[] parts = content.split(SEPARATOR);

            if (parts.length < 2) {
                return new ArrayList<>();
            }

            List<PlayerScore> scores = new ArrayList<>();
            String[] scoreLines = parts[1].split("\\R");

            for (String line : scoreLines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split("\\|");
                if (data.length == 6) {
                    scores.add(new PlayerScore(data[0], Long.parseLong(data[1]), data[2], Integer.parseInt(data[3]),
                                               LocalDateTime.parse(data[4]), data[5]));
                }
            }
            return scores;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Writes both difficulty and player scores to the disc.
     *
     * @param difficulty the difficulty setting
     * @param scores     the list of player scores
     */
    private static void writeGameData(Difficulty difficulty, List<PlayerScore> scores) {
        try {
            StringBuilder content = new StringBuilder();
            content.append(difficulty.name()).append("\n");
            content.append(SEPARATOR).append("\n");

            for (PlayerScore score : scores) {
                content.append(score.getPlayerName()).append("|").append(score.getBestRoundTimeMillis()).append(
                        "|").append(score.getLevelName()).append("|").append(score.getLevelNumber()).append("|").append(
                        score.getAchievedDate()).append("|").append(score.getDifficulty()).append("\n");
            }

            if (!Files.exists(SAVEGAME_DIRECTORY)) {
                Files.createDirectories(SAVEGAME_DIRECTORY);
            }
            Files.writeString(SAVEGAME_FILE, content.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
