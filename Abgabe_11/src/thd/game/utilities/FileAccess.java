package thd.game.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import thd.game.level.Difficulty;

/**
 * This class provides methods to read and write the game difficulty to a file
 * on the disc.
 */
public class FileAccess {
    private static final Path SAVEGAME_DIRECTORY = Path.of(System.getProperty("user.home")).resolve("game");
    private static final String SAVEGAME_FILENAME = "leon_goett_game.txt";
    /**
     * The file where the game difficulty is saved.
     */
    public static final Path SAVEGAME_FILE = SAVEGAME_DIRECTORY.resolve(SAVEGAME_FILENAME);

    /**
     * Writes the given difficulty to a file on the disc.
     *
     * @param difficulty the difficulty to write to disc
     */
    public static void writeDifficultyToDisc(Difficulty difficulty) {
        try {
            if (!Files.exists(SAVEGAME_DIRECTORY)) {
                Files.createDirectories(SAVEGAME_DIRECTORY);
            }
            Files.writeString(SAVEGAME_FILE, difficulty.name(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Reads the difficulty from a file on the disc.
     *
     * @return the difficulty read from the disc, or Difficulty.STANDARD if no file
     *         exists or the file is empty
     */
    public static Difficulty readDifficultyFromDisc() {
        if (Files.exists(SAVEGAME_FILE)) {
            try {
                String content = Files.readString(SAVEGAME_FILE);
                if (!content.isEmpty()) {
                    for (Difficulty diff : Difficulty.values()) {
                        if (diff.name().equals(content)) {
                            return diff;
                        }
                    }
                    return Difficulty.STANDARD;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Difficulty.STANDARD;
    }
}
