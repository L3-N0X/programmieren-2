package thd.game.utilities;

import java.time.LocalDateTime;

/**
 * Represents a player's score with their name, best round time, level
 * information, and achievement date.
 */
public class PlayerScore {
    public final String playerName;
    public final long bestRoundTimeMillis;
    public final String levelName;
    public final int levelNumber;
    public final LocalDateTime achievedDate;
    public final String difficulty;

    /**
     * Creates a new PlayerScore instance.
     *
     * @param playerName          the player's name
     * @param bestRoundTimeMillis the best round time in milliseconds
     * @param levelName           the name of the level
     * @param levelNumber         the number of the level
     * @param achievedDate        the date when this score was achieved
     */
    public PlayerScore(String playerName, long bestRoundTimeMillis, String levelName, int levelNumber,
            LocalDateTime achievedDate, String difficulty) {
        this.playerName = playerName;
        this.bestRoundTimeMillis = bestRoundTimeMillis;
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.achievedDate = achievedDate;
        this.difficulty = difficulty;
    }

    /**
     * Gets the formatted time as MM:SS.mmm
     *
     * @return formatted time string
     */
    public String getFormattedTime() {
        long minutes = bestRoundTimeMillis / 60000;
        long seconds = (bestRoundTimeMillis % 60000) / 1000;
        long millis = bestRoundTimeMillis % 1000;
        return String.format("%02d:%02d.%03d", minutes, seconds, millis);
    }

    /**
     * Gets the formatted date as dd.MM.yyyy HH:mm
     *
     * @return formatted date string
     */
    public String getFormattedDate() {
        return achievedDate.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }
}