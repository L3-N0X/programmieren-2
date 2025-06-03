package thd.game.level;

/**
 * This enum represents the difficulty of a level in the game.
 */
public enum Difficulty {
    /**
     * The easy difficulty level.
     */
    EASY("Einfach"),
    /**
     * The medium difficulty level.
     */
    STANDARD("Standard"),
    /**
     * The hard difficulty level.
     */
    HARD("Hard");

    /**
     * The name of the difficulty level, used for display purposes.
     */
    public final String name;

    Difficulty(String name) {
        this.name = name;
    }

    /**
     * Finds a Difficulty enum constant by its name.
     *
     * @param name The name of the difficulty level to find.
     * @return The Difficulty enum constant that matches the given name.
     */
    public static Difficulty fromName(String name) {
        for (Difficulty difficulty : Difficulty.values()) {
            if (difficulty.name.equalsIgnoreCase(name)) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("No difficulty found with name: " + name);
    }
}
