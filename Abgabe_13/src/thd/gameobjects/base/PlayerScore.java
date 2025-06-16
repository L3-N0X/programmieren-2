package thd.gameobjects.base;

import java.time.LocalDateTime;

/**
 * Represents a player's score with their name, best round time, level information, and achievement date.
 */
public class PlayerScore implements Comparable<PlayerScore> {
    private final String playerName;
    private final long bestRoundTimeMillis;
    private final String levelName;
    private final int levelNumber;
    private final LocalDateTime achievedDate;
    private final String difficulty;

    /**
     * Creates a new PlayerScore instance.
     *
     * @param playerName          the player's name
     * @param bestRoundTimeMillis the best round time in milliseconds
     * @param levelName           the name of the level
     * @param levelNumber         the number of the level
     * @param achievedDate        the date when this score was achieved
     * @param difficulty          the difficulty of the level
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
     * Gets the player's name.
     *
     * @return the player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Gets the best round time in milliseconds.
     *
     * @return the best round time in milliseconds
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the best round time in milliseconds.
     *
     * @return the best round time in milliseconds
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Gets the level number.
     *
     * @return the level number
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * Gets the date when this score was achieved.
     *
     * @return the date when this score was achieved
     */
    public LocalDateTime getAchievedDate() {
        return achievedDate;
    }

    /**
     * Gets the best round time in milliseconds.
     *
     * @return the best round time in milliseconds
     */
    public long getBestRoundTimeMillis() {
        return bestRoundTimeMillis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerScore other = (PlayerScore) o;
        return playerName.equals(other.playerName)
               && bestRoundTimeMillis == other.bestRoundTimeMillis
               && levelName.equals(other.levelName)
               && levelNumber == other.levelNumber
               && achievedDate.equals(other.achievedDate)
               && difficulty.equals(other.difficulty);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(playerName, bestRoundTimeMillis, levelName, levelNumber, achievedDate,
                                      difficulty);
    }

    @Override
    public int compareTo(PlayerScore other) {
        return Long.compare(this.bestRoundTimeMillis, other.bestRoundTimeMillis);
    }
}
