package thd.game.level;

/**
 * The training level.
 */
public class Level1 extends Level {
    /**
     * Creates the level and sets all variables.
     */
    public Level1() {
        name = "TRAINING MAP";
        number = 1;
        world = """
                rRPRrHqrrPrRRPUuhcRr
                rRrRrrRRRrrVmurUMvRR
                VB-S--burRrDqdHRRhqR
                DrqRrRRUuRP|r|RRrrrR
                |RqRrRrRUuRcR|qRhPrq
                |rrRRVmuRUMvQ|PrQrHQ
                CRhRVvHWRRrrQCRrRqPR
                UA-avrVvRrQqRUA-buqR
                rrRrRRwPhrRrQHRqRdRr
                qrqRHrUA---N-burR|hR
                """;
        super.calculateOffsetsFromWorldString();
        roadCondition = RoadCondition.DRY;
        colorPalette = ColorPalette.DEFAULT;
    }
}
