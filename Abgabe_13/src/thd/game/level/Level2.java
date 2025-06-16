package thd.game.level;

/**
 * The second level.
 */
public class Level2 extends Level {
    /**
     * Creates the second level and sets all variables.
     */
    public Level2() {
        name = "DESERT DUNES";
        number = 2;
        world = """
                RRRQRRrRRqRHrqhHQrRRGRGRRR
                RhVBS----buRhRVB---N--buRR
                RqDPRhHrRRUuRVvQrRhqhRRdRR
                RQ|qQRRRRRRUMvRRRRqrRRh|RR
                Rh|rRQRRRRQRRRRRRRRRRRR|HR
                RHCRrPrVB-N-buGGRrRrQRrcrR
                RrUA--avhrRqQUuHrPVB--avrR
                RQrRRrRqQhHrrRUANavrHrRqRR
                """;
        super.calculateOffsetsFromWorldString();
        roadCondition = RoadCondition.DRY;

        colorPalette = ColorPalette.DESERT;
    }
}
