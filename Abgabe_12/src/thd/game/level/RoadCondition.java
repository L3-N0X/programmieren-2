package thd.game.level;

/**
 * This enum represents the road conditions of a level in the game.
 */
public enum RoadCondition {
    DRY("Trocken"),
    WET("Nass"),
    ICY("Glatt");

    /**
     * The name of the road condition, used for display purposes.
     */
    public final String name;

    RoadCondition(String name) {
        this.name = name;
    }

    public static RoadCondition fromName(String name) {
        for (RoadCondition roadcondition : RoadCondition.values()) {
            if (roadcondition.name.equalsIgnoreCase(name)) {
                return roadcondition;
            }
        }
        throw new IllegalArgumentException("No roadcondition found with name: " + name);
    }
}
