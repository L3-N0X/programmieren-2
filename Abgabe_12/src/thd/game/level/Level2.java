package thd.game.level;

/**
 * The second level.
 */
public class Level2 extends Level {
    /**
     * Creates the second level and sets all variables.
     */
    public Level2() {
        name = "RECTANGLE MAP";
        number = 2;
        world = """
                RRRQRRrRRqRHrqhHQrRRGRGRRR
                RhVBS---------N-------buRR
                RqDPRhHrRRPRqQrRrRhqhRRdRR
                RQ|qQRRRRRRRRRRRRRqrRRh|RR
                Rh|rRQRRRRQRRRRRRRRRRRR|HR
                RHCRrPrRGGRPQRRqRrRrQRrcrR
                RrUA------N------N----avrR
                RQrRRrRqQhHrrRqQhHrHrRqQRR
                """;
        super.calculateOffsetsFromWorldString();
        roadCondition = RoadCondition.DRY;

        colorPalette = ColorPalette.DESERT;
    }
}
