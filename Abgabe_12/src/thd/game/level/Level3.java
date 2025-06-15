package thd.game.level;

/**
 * The third level.
 */
public class Level3 extends Level {
    /**
     * Creates the third level and sets all variables.
     */
    public Level3() {
        name = "CURVES AND HILLS";
        number = 3;
        world = """
                RRRRRRRRRRRRRRRRRR
                RRRQRRRRRRRRRRRQRQ
                RqVmuHRQPHRRRRRRRR
                PVvhUA---buPRRRrRR
                QDRRRRHRRQUuQRRRRR
                R|qRRRPVmuhUuhRqRQ
                R|RRRhVvRUuRWrRRRR
                q|HRqVvPRqUMvHRRRH
                QCPRHwqRRHHPrRRqRR
                RUuRRUuhVmuPRRRrRh
                RHWQRRUMvPdRRRRRRR
                RVvRRqhHRh|rRRRQRQ
                PwRRQVmurR|qRRRRRR
                RUuRVvRWRq|HRRRrCH
                RqUMvRVvQR|rRRRHUM
                RRHrRVvrRR|qRRRRqQ
                RRRRVvRRRH|PRRRRRh
                RRPVvqRRRr|qRRRRPR
                RRrwRRRRRRCqRqRrRR
                RRqUuqRRRRUA--NbuR
                RRRQUuHRRRrhRRrRdR
                RRRrRUuQqRrPqRrr|Q
                RRRRPrUurRPqRQRhcr
                RRRRRRrUA-N--NSavR
                RRRRRRHQRRrRPqRrRH
                RRRRRRRRRRRRRRRHVm
                """;
        super.calculateOffsetsFromWorldString();
        roadCondition = RoadCondition.DRY;

        colorPalette = ColorPalette.DEFAULT;
    }
}
