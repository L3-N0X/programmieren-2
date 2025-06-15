package thd.game.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a player's score with their name, best round time, level information, and achievement date.
 */
public class PlayerScore implements Comparable<PlayerScore> {
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
    public String formatBestRoundTime() {
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
    public String formatAchievedDate() {
        return achievedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - %s - Level %d - %s",
                             playerName, formatBestRoundTime(), levelName, formatAchievedDate(), levelNumber,
                             difficulty);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerScore other)) {
            return false;
        }
        return playerName.equals(other.playerName) &&
               bestRoundTimeMillis == other.bestRoundTimeMillis &&
               levelName.equals(other.levelName) &&
               levelNumber == other.levelNumber &&
               achievedDate.equals(other.achievedDate) &&
               difficulty.equals(other.difficulty);
    }

    @Override
    public int compareTo(PlayerScore other) {
        return Long.compare(this.bestRoundTimeMillis, other.bestRoundTimeMillis);
    }
}
