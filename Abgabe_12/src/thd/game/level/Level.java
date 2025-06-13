package thd.game.level;

/**
 * A simple Level class with all information about a single level.
 */
public class Level {
    /**
     * The name of the level.
     */
    public String name;
    /**
     * The number of the level.
     */
    protected int number;
    /**
     * The world for the level where the user spawns in, as worldString.
     */
    public String world;
    /**
     * The horizontal offset for the world starting point, in columns.
     */
    public int worldOffsetColumns;
    /**
     * The vertical offset for the world starting point in lines.
     */
    public int worldOffsetLines;

    /**
     * The difficulty of the level.
     */
    public static Difficulty difficulty = Difficulty.STANDARD;

    /**
     * This uses the start tile form the world and calculates the offset correctly.
     */
    protected void calculateOffsetsFromWorldString() {
        String[] lines = world.split("\\R");

        for (int i = 0; i < lines.length; i++) {
            int col = lines[i].indexOf('S');
            if (col != -1) {
                worldOffsetLines = i - 1;
                worldOffsetColumns = col - 1;
                return;
            }
        }
    }
}
