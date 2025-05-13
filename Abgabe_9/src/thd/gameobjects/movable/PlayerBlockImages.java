package thd.gameobjects.movable;

public class PlayerBlockImages {

    static final int TILE_HEIGHT = 11;
    static final int TILE_WIDTH = 14;

    enum DriverTiles {
        LEFT_00("""
                                      \s
                            WWWW      \s
                          WWWWWW      \s
                            WWWW      \s
                          WW  WW      \s
                          WWWWWWWWWW  \s
                              WWWWWW  \s
                            WWWWWW    \s
                            WWWWWW    \s
                            WW  WWWW  \s
                          WWWW    WW  \s
                        """),
        LEFT_01("""
                                      \s
                            WWWW      \s
                          WWWWWW      \s
                            WWWW      \s
                              WW      \s
                              WWWW    \s
                            WWWWWW    \s
                              WWWW    \s
                              WWWWWWWW\s
                              WW    WW\s
                            WWWW      \s
                        """),
        LEFT_02("""
                            WWWW      \s
                          WWWWWW      \s
                        WW  WWWW    WW\s
                        WWWW  WW  WWWW\s
                          WWWWWWWWWW  \s
                            WWWWWW    \s
                            WWWWWW    \s
                            WWWWWW    \s
                          WWWW  WWWW  \s
                          WW      WW  \s
                        WWWW      WWWW\s
                        """),
        LEFT_03("""
                            WWWW      \s
                          WWWWWW      \s
                            WWWW      \s
                              WW      \s
                          WWWWWWWWWW  \s
                        WWWWWWWWWWWWWW\s
                        WW  WWWWWW  WW\s
                            WWWWWW    \s
                          WWWW  WWWW  \s
                          WW      WW  \s
                        WWWW      WWWW\s
                        """),
        RIGHT_00("""
                                       \s
                               WWWW    \s
                               WWWWWW  \s
                               WWWW    \s
                               WW  WW  \s
                           WWWWWWWWWW  \s
                           WWWWWW      \s
                             WWWWWW    \s
                             WWWWWW    \s
                           WWWW  WW    \s
                           WW    WWWW  \s
                         """),
        RIGHT_01("""
                                       \s
                               WWWW    \s
                               WWWWWW  \s
                               WWWW    \s
                               WW      \s
                             WWWW      \s
                             WWWWWW    \s
                             WWWW      \s
                         WWWWWWWW      \s
                         WW    WW      \s
                               WWWW    \s
                         """),
        RIGHT_02("""
                               WWWW    \s
                               WWWWWW  \s
                         WW    WWWW  WW\s
                         WWWW  WW  WWWW\s
                           WWWWWWWWWW  \s
                             WWWWWW    \s
                             WWWWWW    \s
                             WWWWWW    \s
                           WWWW  WWWW  \s
                           WW      WW  \s
                         WWWW      WWWW\s
                         """),
        RIGHT_03("""
                               WWWW    \s
                               WWWWWW  \s
                               WWWW    \s
                               WW      \s
                           WWWWWWWWWW  \s
                         WWWWWWWWWWWWWW\s
                         WW  WWWWWW  WW\s
                             WWWWWW    \s
                           WWWW  WWWW  \s
                           WW      WW  \s
                         WWWW      WWWW\s
                         """),
        ROLL_LEFT_00("""
                               HHHH          \s
                               HHHHHHHH      \s
                                 HHHHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHHHHWWWWHHHHHH\s
                             HHHHHHHHWWHHHHHH\s
                               HHHHHHWWWWHHHH\s
                                   WWWWWWHH  \s
                                     WWWW    \s
                                     WWWWWWWW\s
                                     WW    WW\s
                                   WWWW      \s
                             """),
        ROLL_LEFT_01("""
                                         HHHH\s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHHH  WWWWHHHHHH\s
                             HHHHWWHHWWHHHHHH\s
                             HHHHWWWWWWWWHHHH\s
                               HHHHHHWWWWHH  \s
                                   WWWWWW    \s
                                   WWWWWW    \s
                                   WW  WWWW  \s
                                 WWWW    WW  \s
                             """),
        ROLL_LEFT_02("""
                               HHHH          \s
                               HHHHHHHH      \s
                                 HHHHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHHHHWWWWHHHHHH\s
                             HHHHHHHHWWHHHHHH\s
                               HHHHHHWWWWHHHH\s
                                   WWWWWWHH  \s
                                     WWWW    \s
                                     WWWWWWWW\s
                                     WW    WW\s
                                   WWWW      \s
                             """),
        ROLL_LEFT_03("""
                                         HHHH\s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHH  WWWWHHHHHH\s
                             HHHHWWHHWWHHHHHH\s
                             HHHHWWWWWWWWWW  \s
                               HHHHHHWWWWWW  \s
                                   WWWWWW    \s
                                   WWWWWW    \s
                                   WW  WWWW  \s
                                 WWWW    WW  \s
                             """),
        ROLL_LEFT_04("""
                               HHHH          \s
                               HHHHHHHH      \s
                                 HHHHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHHHHWWWWHHHHHH\s
                             HHHHHHHHWWHHHHHH\s
                               HHHHHHWWWWHHHH\s
                                   WWWWWWHH  \s
                                     WWWW    \s
                                     WWWWWWWW\s
                                     WW    WW\s
                                   WWWW      \s
                             """),
        ROLL_LEFT_05("""
                                         HHHH\s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHH  WWWWHHHHHH\s
                             HHHHWWHHWWHHHHHH\s
                             HHHHWWWWWWWWWW  \s
                               HHHHHHWWWWWW  \s
                                   WWWWWW    \s
                                   WWWWWW    \s
                                   WW  WWWW  \s
                                 WWWW    WW  \s
                             """),
        ROLL_LEFT_06("""
                               HHHH          \s
                               HHHHHHHH      \s
                                 HHHHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHHHHWWWWHHHHHH\s
                             HHHHHHHHWWHHHHHH\s
                               HHHHHHWWWWHHHH\s
                                   WWWWWWHH  \s
                                     WWWW    \s
                                     WWWWWWWW\s
                                     WW    WW\s
                                   WWWW      \s
                             """),
        ROLL_LEFT_07("""
                                         HHHH\s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHH  WWWWHHHHHH\s
                             HHHHWWHHWWHHHHHH\s
                             HHHHWWWWWWWWWW  \s
                               HHHHHHWWWWWW  \s
                                   WWWWWW    \s
                                   WWWWWW    \s
                                   WW  WWWW  \s
                                 WWWW    WW  \s
                             """),
        ROLL_LEFT_08("""
                               HHHH          \s
                               HHHHHHHH      \s
                                 HHHHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHWWWWHHHH  \s
                             HHHHWWWWWWHHHHHH\s
                             HHHHHHWWWWHHHHHH\s
                             HHHHHHHHWWHHHHHH\s
                               HHHHHHWWWWHHHH\s
                                   WWWWWWHH  \s
                                     WWWW    \s
                                     WWWWWWWW\s
                                     WW    WW\s
                                   WWWW      \s
                             """),
        ROLL_LEFT_09("""
                                         HHHH\s
                                     HHHHHHHH\s
                                   HHHHHHHH  \s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                               WWHHHHHHHHHHHH\s
                             WWWWWWHHHHHHHHHH\s
                             WWWWWWWWWWHHHHHH\s
                               WW  WWWWWWHHHH\s
                                 WWWWWWWWWW  \s
                                   WWWWWWWW  \s
                                 WW  WW  WWWW\s
                                     WW    WW\s
                                   WWWW  WWWW\s
                             """),
        ROLL_LEFT_10("""
                                             \s
                                             \s
                                             \s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHWWWWWWWWWWHHHH\s
                             HHWWHHHHWWWWWWHH\s
                             HHWWHHHHWWWWWWHH\s
                               HHHHHHHHHHWW  \s
                                     WWWWWW  \s
                             """),
        ROLL_LEFT_11("""
                                             \s
                                             \s
                                             \s
                                       HHHHHH\s
                                   HHHHHHHHHH\s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHWWWWHHHH  \s
                             HHHHWWWWWWWWHHHH\s
                             HHWWWWWWWWWWWWHH\s
                             HHWWHHWWWWHHWWHH\s
                             HHWWHHHHHHHHWWHH\s
                                 WW    WW    \s
                             """),
        ROLL_LEFT_12("""
                                             \s
                                             \s
                                             \s
                                 HHHH        \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHHHWWWWWWHHHH\s
                             HHHHWWWWWWWWWWHH\s
                             HHWWWWWWWW  WWHH\s
                             HHWWWWWWHHHHWWHH\s
                               WW            \s
                               WWWWWW        \s
                             """),
        ROLL_LEFT_13("""
                                             \s
                                             \s
                                             \s
                                             \s
                             HHHHHH          \s
                             HHHHHHHHHH      \s
                               HHHHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                               HHHHWWHHHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHWWWWHHWWHHHHHH\s
                             HHWWWWWWHHHHWWHH\s
                               WWWWWWWWWWWWHH\s
                                 WWWWWWWW    \s
                             """),
        ROLL_LEFT_14("""
                                             \s
                                             \s
                                             \s
                                             \s
                                       HHHHHH\s
                                   HHHHHHHH  \s
                                 HHHHHHHH    \s
                               HHHHHHHHHH    \s
                             HHHHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             WWWWHHHHHHHHHHHH\s
                             WWHHHHWWWWHHHHWW\s
                             WWWWWWWWWWWWWWWW\s
                               WWWWWWWWWWWW  \s
                             """),
        ROLL_LEFT_15("""
                                             \s
                                             \s
                                             \s
                                             \s
                                   HHHHHH    \s
                                 HHHHHH      \s
                               HHHHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHHHHHHHHHWWHH\s
                             HHHHHHHHHHHHWWWW\s
                             WWHHHHWWWWHHHHWW\s
                             WWWWWWWWWWWWWWWW\s
                               WWWWWWWWWWWW  \s
                             """),
        ROLL_LEFT_16("""
                                             \s
                                             \s
                                             \s
                                             \s
                                 HHHHHH      \s
                                   HHHHHH    \s
                                   HHHHHHHH  \s
                                 HHHHHHHHHHHH\s
                               HHHHHHWWHHHHHH\s
                             HHHHHHWWWWWWHHHH\s
                             HHHHHHWW  WWWWHH\s
                             HHWW    WWWWWWHH\s
                             HHWWWWWWWWWWWWHH\s
                                 WWWWWWWW    \s
                             """),
        ROLL_LEFT_17("""
                                             \s
                                             \s
                                             \s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHWWWWWWWWWWHHHH\s
                             HHWWHHHHWWWWWWHH\s
                             HHWWHHHHWWWWWWHH\s
                               HHHHHHHHHHWW  \s
                                     WWWWWW  \s
                             """),
        ROLL_LEFT_18("""
                                             \s
                                             \s
                                             \s
                                       HHHHHH\s
                                   HHHHHHHHHH\s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHWWWWHHHH  \s
                             HHHHWWWWWWWWHHHH\s
                             HHWWWWWWWWWWWWHH\s
                             HHWWHHWWWWHHWWHH\s
                             HHWWHHHHHHHHWWHH\s
                                 WW    WW    \s
                             """),
        ROLL_LEFT_19("""
                                             \s
                                             \s
                                             \s
                                 HHHH        \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHHHWWWWWWHHHH\s
                             HHHHWWWWWWWWWWHH\s
                             HHWWWWWWWW  WWHH\s
                             HHWWWWWWHHHHWWHH\s
                               WW            \s
                               WWWWWW        \s
                             """),
        ROLL_LEFT_20("""
                                             \s
                                             \s
                                             \s
                                             \s
                             HHHHHH          \s
                             HHHHHHHHHH      \s
                               HHHHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                               HHHHWWHHHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHWWWWHHWWHHHHHH\s
                             HHWWWWWWHHHHWWHH\s
                               WWWWWWWWWWWWHH\s
                                 WWWWWWWW    \s
                             """),
        ROLL_LEFT_21("""
                                             \s
                                             \s
                                             \s
                                             \s
                                       HHHHHH\s
                                   HHHHHHHH  \s
                                 HHHHHHHH    \s
                               HHHHHHHHHH    \s
                             HHHHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             WWWWHHHHHHHHHHHH\s
                             WWHHHHWWWWHHHHWW\s
                             WWWWWWWWWWWWWWWW\s
                               WWWWWWWWWWWW  \s
                             """),
        ROLL_LEFT_22("""
                                             \s
                                             \s
                                             \s
                                             \s
                                   HHHHHH    \s
                                 HHHHHH      \s
                               HHHHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHHHHHHHHHWWHH\s
                             HHHHHHHHHHHHWWWW\s
                             WWHHHHWWWWHHHHWW\s
                             WWWWWWWWWWWWWWWW\s
                               WWWWWWWWWWWW  \s
                             """),
        ROLL_LEFT_23("""
                                             \s
                                             \s
                                             \s
                                             \s
                                 HHHHHH      \s
                                   HHHHHH    \s
                                   HHHHHHHH  \s
                                 HHHHHHHHHHHH\s
                               HHHHHHWWHHHHHH\s
                             HHHHHHWWWWWWHHHH\s
                             HHHHHHWW  WWWWHH\s
                             HHWW    WWWWWWHH\s
                             HHWWWWWWWWWWWWHH\s
                                 WWWWWWWW    \s
                             """),
        ROLL_LEFT_24("""
                                             \s
                                             \s
                                             \s
                                     HHHHHH  \s
                                   HHHHHH    \s
                                 HHHHHHHH    \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHWWWWWWHHHHHH\s
                             HHWWWWWWWWWWHHHH\s
                             HHWWHHHHWWWWWWHH\s
                             HHWWHHHHWWWWWWHH\s
                               HHHHHHHHHHWW  \s
                                     WWWWWW  \s
                             """),
        ROLL_LEFT_25("""
                                             \s
                                             \s
                                             \s
                                       HHHHHH\s
                                   HHHHHHHHHH\s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHWWWWHHHH  \s
                             HHHHWWWWWWWWHHHH\s
                             HHWWWWWWWWWWWWHH\s
                             HHWWHHWWWWHHWWHH\s
                             HHWWHHHHHHHHWWHH\s
                                 WW    WW    \s
                             """),
        ROLL_LEFT_26("""
                                             \s
                                             \s
                                             \s
                                 HHHH        \s
                                   HHHHHH    \s
                                 HHHHHHHHHH  \s
                               HHHHHHHHHHHH  \s
                             HHHHHHHHHHHHHHHH\s
                             HHHHHHWWWWWWHHHH\s
                             HHHHWWWWWWWWWWHH\s
                             HHWWWWWWWW  WWHH\s
                             HHWWWWWWHHHHWWHH\s
                               WW            \s
                               WWWWWW        \s
                             """),
        ROLL_LEFT_27("""
                                             \s
                                             \s
                                             \s
                                             \s
                                             \s
                                         WW  \s
                                       WWWWWW\s
                                   WWWWWWWWWW\s
                                 WWWWWW  WW  \s
                               WWWWWWWWWW    \s
                               WWWWWWWW      \s
                             WWWW  WW  WW    \s
                             WW    WW        \s
                             WWWW  WWWW      \s
                             """),
        ROLL_LEFT_28("""
                                             \s
                                             \s
                                             \s
                                   WWWW      \s
                                   WWWWWW    \s
                                   WWWW      \s
                                   WW        \s
                               WWWWWWWWWW    \s
                             WWWWWWWWWWWWWW  \s
                             WW  WWWWWW  WW  \s
                                 WWWWWW      \s
                               WWWW  WWWW    \s
                               WW      WW    \s
                             WWWW      WWWW  \s
                             """),
        ROLL_LEFT_29("""
                                             \s
                                             \s
                                             \s
                                   WWWW      \s
                                   WWWWWW    \s
                             WW    WWWW  WW  \s
                             WWWW  WW  WWWW  \s
                               WWWWWWWWWW    \s
                                 WWWWWW      \s
                                 WWWWWW      \s
                                 WWWWWW      \s
                               WWWW  WWWW    \s
                               WW      WW    \s
                             WWWW      WWWW  \s
                             """),
        ROLL_RIGHT_00("""
                                        HHHH  \s
                                    HHHHHHHH  \s
                                  HHHHHHHH    \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWWHHHHHH\s
                              HHHHHHWWHHHHHHHH\s
                              HHHHWWWWHHHHHH  \s
                                HHWWWWWW      \s
                                  WWWW        \s
                              WWWWWWWW        \s
                              WW    WW        \s
                                    WWWW      \s
                              """),
        ROLL_RIGHT_01("""
                              HHHH            \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                              HHHHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWW  HHHH\s
                              HHHHHHWWHHWWHHHH\s
                              HHHHWWWWWWWWHHHH\s
                                HHWWWWHHHHHH  \s
                                  WWWWWW      \s
                                  WWWWWW      \s
                                WWWW  WW      \s
                                WW    WWWW    \s
                              """),
        ROLL_RIGHT_02("""
                                        HHHH  \s
                                    HHHHHHHH  \s
                                  HHHHHHHH    \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWWHHHHHH\s
                              HHHHHHWWHHHHHHHH\s
                              HHHHWWWWHHHHHH  \s
                                HHWWWWWW      \s
                                  WWWW        \s
                              WWWWWWWW        \s
                              WW    WW        \s
                                    WWWW      \s
                              """),
        ROLL_RIGHT_03("""
                              HHHH            \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWW  HHHH\s
                              HHHHHHWWHHWWHHHH\s
                                WWWWWWWWWWHHHH\s
                                WWWWWWHHHHHH  \s
                                  WWWWWW      \s
                                  WWWWWW      \s
                                WWWW  WW      \s
                                WW    WWWW    \s
                              """),
        ROLL_RIGHT_04("""
                                        HHHH  \s
                                    HHHHHHHH  \s
                                  HHHHHHHH    \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWWHHHHHH\s
                              HHHHHHWWHHHHHHHH\s
                              HHHHWWWWHHHHHH  \s
                                HHWWWWWW      \s
                                  WWWW        \s
                              WWWWWWWW        \s
                              WW    WW        \s
                                    WWWW      \s
                              """),
        ROLL_RIGHT_05("""
                              HHHH            \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWW  HHHH\s
                              HHHHHHWWHHWWHHHH\s
                                WWWWWWWWWWHHHH\s
                                WWWWWWHHHHHH  \s
                                  WWWWWW      \s
                                  WWWWWW      \s
                                WWWW  WW      \s
                                WW    WWWW    \s
                              """),
        ROLL_RIGHT_06("""
                                        HHHH  \s
                                    HHHHHHHH  \s
                                  HHHHHHHH    \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWWHHHHHH\s
                              HHHHHHWWHHHHHHHH\s
                              HHHHWWWWHHHHHH  \s
                                HHWWWWWW      \s
                                  WWWW        \s
                              WWWWWWWW        \s
                              WW    WW        \s
                                    WWWW      \s
                              """),
        ROLL_RIGHT_07("""
                              HHHH            \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWW  HHHH\s
                              HHHHHHWWHHWWHHHH\s
                                WWWWWWWWWWHHHH\s
                                WWWWWWHHHHHH  \s
                                  WWWWWW      \s
                                  WWWWWW      \s
                                WWWW  WW      \s
                                WW    WWWW    \s
                              """),
        ROLL_RIGHT_08("""
                                        HHHH  \s
                                    HHHHHHHH  \s
                                  HHHHHHHH    \s
                                HHHHHHHHHH    \s
                                HHHHWWWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWWWHHHHHH\s
                              HHHHHHWWHHHHHHHH\s
                              HHHHWWWWHHHHHH  \s
                                HHWWWWWW      \s
                                  WWWW        \s
                              WWWWWWWW        \s
                              WW    WW        \s
                                    WWWW      \s
                              """),
        ROLL_RIGHT_09("""
                              HHHH            \s
                              HHHHHHHH        \s
                                HHHHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHWW  \s
                              HHHHHHHHHHWWWWWW\s
                              HHHHHHWWWWWWWWWW\s
                              HHHHWWWWWW  WW  \s
                                WWWWWWWWWW    \s
                                WWWWWWWW      \s
                              WWWW  WW  WW    \s
                              WW    WW        \s
                              WWWW  WWWW      \s
                              """),
        ROLL_RIGHT_10("""
                                              \s
                                              \s
                                              \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                  HHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHHHWWWWWWHHHH\s
                              HHHHWWWWWWWWWWHH\s
                              HHWWWWWWHHHHWWHH\s
                              HHWWWWWWHHHHWWHH\s
                                WWHHHHHHHHHH  \s
                                WWWWWW        \s
                              """),
        ROLL_RIGHT_11("""
                                              \s
                                              \s
                                              \s
                              HHHHHH          \s
                              HHHHHHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                                HHHHWWWWHHHHHH\s
                              HHHHWWWWWWWWHHHH\s
                              HHWWWWWWWWWWWWHH\s
                              HHWWHHWWWWHHWWHH\s
                              HHWWHHHHHHHHWWHH\s
                                  WW    WW    \s
                              """),
        ROLL_RIGHT_12("""
                                              \s
                                              \s
                                              \s
                                      HHHH    \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHWWWWWWHHHHHH\s
                              HHWWWWWWWWWWHHHH\s
                              HHWW  WWWWWWWWHH\s
                              HHWWHHHHWWWWWWHH\s
                                          WW  \s
                                      WWWWWW  \s
                              """),
        ROLL_RIGHT_13("""
                                              \s
                                              \s
                                              \s
                                              \s
                                        HHHHHH\s
                                    HHHHHHHHHH\s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWHHWWWWHH\s
                              HHWWHHHHWWWWWWHH\s
                              HHWWWWWWWWWWWW  \s
                                  WWWWWWWW    \s
                              """),
        ROLL_RIGHT_14("""
                                              \s
                                              \s
                                              \s
                                              \s
                              HHHHHH          \s
                                HHHHHHHH      \s
                                  HHHHHHHH    \s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHHHH\s
                              HHHHHHHHHHHHHHHH\s
                              HHHHHHHHHHHHWWWW\s
                              WWHHHHWWWWHHHHWW\s
                              WWWWWWWWWWWWWWWW\s
                                WWWWWWWWWWWW  \s
                              """),
        ROLL_RIGHT_15("""
                                              \s
                                              \s
                                              \s
                                              \s
                                  HHHHHH      \s
                                    HHHHHH    \s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHWWHHHHHHHHHHHH\s
                              WWWWHHHHHHHHHHHH\s
                              WWHHHHWWWWHHHHWW\s
                              WWWWWWWWWWWWWWWW\s
                                WWWWWWWWWWWW  \s
                              """),
        ROLL_RIGHT_16("""
                                              \s
                                              \s
                                              \s
                                              \s
                                    HHHHHH    \s
                                  HHHHHH      \s
                                HHHHHHHH      \s
                              HHHHHHHHHHHH    \s
                              HHHHHHWWHHHHHH  \s
                              HHHHWWWWWWHHHHHH\s
                              HHWWWW  WWHHHHHH\s
                              HHWWWWWW    WWHH\s
                              HHWWWWWWWWWWWWHH\s
                                  WWWWWWWW    \s
                              """),
        ROLL_RIGHT_17("""
                                              \s
                                              \s
                                              \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                  HHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHHHWWWWWWHHHH\s
                              HHHHWWWWWWWWWWHH\s
                              HHWWWWWWHHHHWWHH\s
                              HHWWWWWWHHHHWWHH\s
                                WWHHHHHHHHHH  \s
                                WWWWWW        \s
                              """),
        ROLL_RIGHT_18("""
                                              \s
                                              \s
                                              \s
                              HHHHHH          \s
                              HHHHHHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                                HHHHWWWWHHHHHH\s
                              HHHHWWWWWWWWHHHH\s
                              HHWWWWWWWWWWWWHH\s
                              HHWWHHWWWWHHWWHH\s
                              HHWWHHHHHHHHWWHH\s
                                  WW    WW    \s
                              """),
        ROLL_RIGHT_19("""
                                              \s
                                              \s
                                              \s
                                      HHHH    \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHWWWWWWHHHHHH\s
                              HHWWWWWWWWWWHHHH\s
                              HHWW  WWWWWWWWHH\s
                              HHWWHHHHWWWWWWHH\s
                                          WW  \s
                                      WWWWWW  \s
                              """),
        ROLL_RIGHT_20("""
                                              \s
                                              \s
                                              \s
                                              \s
                                        HHHHHH\s
                                    HHHHHHHHHH\s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHWWHHHH  \s
                              HHHHHHWWWWWWHHHH\s
                              HHHHHHWWHHWWWWHH\s
                              HHWWHHHHWWWWWWHH\s
                              HHWWWWWWWWWWWW  \s
                                  WWWWWWWW    \s
                              """),
        ROLL_RIGHT_21("""
                                              \s
                                              \s
                                              \s
                                              \s
                              HHHHHH          \s
                                HHHHHHHH      \s
                                  HHHHHHHH    \s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHHHH\s
                              HHHHHHHHHHHHHHHH\s
                              HHHHHHHHHHHHWWWW\s
                              WWHHHHWWWWHHHHWW\s
                              WWWWWWWWWWWWWWWW\s
                                WWWWWWWWWWWW  \s
                              """),
        ROLL_RIGHT_22("""
                                              \s
                                              \s
                                              \s
                                              \s
                                  HHHHHH      \s
                                    HHHHHH    \s
                                  HHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHWWHHHHHHHHHHHH\s
                              WWWWHHHHHHHHHHHH\s
                              WWHHHHWWWWHHHHWW\s
                              WWWWWWWWWWWWWWWW\s
                                WWWWWWWWWWWW  \s
                              """),
        ROLL_RIGHT_23("""
                                              \s
                                              \s
                                              \s
                                              \s
                                    HHHHHH    \s
                                  HHHHHH      \s
                                HHHHHHHH      \s
                              HHHHHHHHHHHH    \s
                              HHHHHHWWHHHHHH  \s
                              HHHHWWWWWWHHHHHH\s
                              HHWWWW  WWHHHHHH\s
                              HHWWWWWW    WWHH\s
                              HHWWWWWWWWWWWWHH\s
                                  WWWWWWWW    \s
                              """),
        ROLL_RIGHT_24("""
                                              \s
                                              \s
                                              \s
                                HHHHHH        \s
                                  HHHHHH      \s
                                  HHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHHHWWWWWWHHHH\s
                              HHHHWWWWWWWWWWHH\s
                              HHWWWWWWHHHHWWHH\s
                              HHWWWWWWHHHHWWHH\s
                                WWHHHHHHHHHH  \s
                                WWWWWW        \s
                              """),
        ROLL_RIGHT_25("""
                                              \s
                                              \s
                                              \s
                              HHHHHH          \s
                              HHHHHHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                                HHHHHHHHHHHH  \s
                                HHHHWWWWHHHHHH\s
                              HHHHWWWWWWWWHHHH\s
                              HHWWWWWWWWWWWWHH\s
                              HHWWHHWWWWHHWWHH\s
                              HHWWHHHHHHHHWWHH\s
                                  WW    WW    \s
                              """),
        ROLL_RIGHT_26("""
                                              \s
                                              \s
                                              \s
                                      HHHH    \s
                                  HHHHHH      \s
                                HHHHHHHHHH    \s
                                HHHHHHHHHHHH  \s
                              HHHHHHHHHHHHHHHH\s
                              HHHHWWWWWWHHHHHH\s
                              HHWWWWWWWWWWHHHH\s
                              HHWW  WWWWWWWWHH\s
                              HHWWHHHHWWWWWWHH\s
                                          WW  \s
                                      WWWWWW  \s
                              """),
        ROLL_RIGHT_27("""
                                              \s
                                              \s
                                              \s
                                              \s
                                              \s
                                WW            \s
                              WWWWWW          \s
                              WWWWWWWWWW      \s
                                WW  WWWWWW    \s
                                  WWWWWWWWWW  \s
                                    WWWWWWWW  \s
                                  WW  WW  WWWW\s
                                      WW    WW\s
                                    WWWW  WWWW\s
                              """),
        ROLL_RIGHT_28("""
                                              \s
                                              \s
                                              \s
                                    WWWW      \s
                                  WWWWWW      \s
                                    WWWW      \s
                                      WW      \s
                                  WWWWWWWWWW  \s
                                WWWWWWWWWWWWWW\s
                                WW  WWWWWW  WW\s
                                    WWWWWW    \s
                                  WWWW  WWWW  \s
                                  WW      WW  \s
                                WWWW      WWWW\s
                              """),
        ROLL_RIGHT_29("""
                                              \s
                                              \s
                                              \s
                                    WWWW      \s
                                  WWWWWW      \s
                                WW  WWWW    WW\s
                                WWWW  WW  WWWW\s
                                  WWWWWWWWWW  \s
                                    WWWWWW    \s
                                    WWWWWW    \s
                                    WWWWWW    \s
                                  WWWW  WWWW  \s
                                  WW      WW  \s
                                WWWW      WWWW\s
                              """);
        private final String tile;

        DriverTiles(String tile) {
            this.tile = tile;
        }

        String blockImage() {
            return tile;
        }
    }
}
