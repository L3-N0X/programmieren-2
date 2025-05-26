package thd.game.utilities;

import thd.game.level.Difficulty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class provides methods to read and write the game difficulty to a file on the disc.
 */
public class FileAccess {
    private static final Path WICHTEL_GAME_FILE = Path.of(System.getProperty("user.home")).resolve("wichtelgame.txt");

    /**
     * Writes the given difficulty to a file on the disc.
     *
     * @param difficulty the difficulty to write to disc
     */
    public static void writeDifficultyToDisc(Difficulty difficulty) {
        try {
            Files.writeString(WICHTEL_GAME_FILE, difficulty.name(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the difficulty from a file on the disc.
     *
     * @return the difficulty read from the disc, or Difficulty.STANDARD if no file exists or the file is empty
     */
    public static Difficulty readDifficultyFromDisc() {
        if (Files.exists(WICHTEL_GAME_FILE)) {
            try {
                String content = Files.readString(WICHTEL_GAME_FILE);
                if (!content.isEmpty()) {
                    return Difficulty.valueOf(content);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Difficulty.STANDARD;
    }
}
