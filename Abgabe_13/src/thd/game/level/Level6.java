package thd.game.level;

/**
 * The fifth level. Has icy roads.
 */
public class Level6 extends Level {
    /**
     * Creates the level and sets all variables.
     */
    public Level6() {
        name = "GRASSY ROAD - ICY";
        number = 6;
        world = """
                RRRRRRRRRRRRRRRRDRUuRRPUurVvRRRR
                RRRQRRRRRRRRRRRQ|QRUuqRrUMvrRRRR
                RqVmuHRQPHRRRRRR|RRRUuRRRRPRRRRR
                PVvhUA-S-buPRRRr|RRhrUurRRRRRRRR
                QDRRRRHRRQUuQRRR|RVmuRUuhRRRRRRR
                R|qRRRPVmuhUuhRq|QDRdRRUurPRQrPR
                R|RRRhVvRUuRWrRR|R|R|rRQUA-N-buR
                q|HRqVvPRqUMvHRR|H|h|RRRRrRqRRWr
                QCPRHwqRRHHPrRRq|R|R|HRRRRRRRVvR
                RUuRRUuhVmuPRRRr|h|h|RRRRRRrVvQR
                RHWQRRUMvPdRRRRR|R|H|QRRRRRRwPRR
                RVvRRqhHRh|rRRRQ|Q|R|RRRRRRPUurR
                PwRRQVmurR|qRRRR|R|H|HRRRRRRqUuR
                RUuRVvRWRq|HRRRrCHch|RRRRRRRRRdR
                RqUMvRVvQR|rRRRHUMvRcrRRRqRRRQ|r
                RRHrRVvrRR|qRRRRqQRVvRRhVmuHRR|R
                RRRRVvRRRH|PRRRRRhVvHRqVvRUuRP|R
                RRPVvqRRRr|qRRRRPVvrRrVvrRHWRQ|r
                RRrwRRRRRRCqRqRrVvPRHVvhRqVvHq|R
                RRqUuqRRRRUA--NavRRrVvRRRVvRRR|P
                RRRQUuHRRRrhRRrRRRqVvRRrVvHRRr|Q
                RRRRPUuPrRPqRQRRRrVvHRRVvhRRRRcR
                RRRRRrUA-N---N---avRRPVvRRRRRVvR
                RRRRRRHQRRrRPqRrRHPRRRwrRRRrVvQR
                RRRRRRRRRRRRRRRHVmuQRhUuhRRVvRRR
                """;
        super.calculateOffsetsFromWorldString();
        roadCondition = RoadCondition.ICY;
        colorPalette = ColorPalette.ICY;
    }
}
