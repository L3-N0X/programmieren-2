package thd.gameobjects.movable;

import thd.gameobjects.base.Position;

import java.util.ArrayList;
import java.util.List;

class CarBlockImages {
    static final int TILE_HEIGHT = 20;
    static final int TILE_WIDTH = 32;

    enum CarRotation {
        ROT_00("""
                                 LL      LL          \s
                                 LLIIIIIILL          \s
                                 LLIIIIIILL          \s
                                 LLIIIIIILL          \s
                                   IIIIII            \s
                                   IIIIII            \s
                                   IIIIII            \s
                                   IIIIII            \s
                                 IIIILLIIII          \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIIIILLIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLL  IIIIII  LLLL      \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(10, 0),
                                    new Position(19, 0),
                                    new Position(6, 9),
                                    new Position(23, 9))),
        ROT_01("""
                                   LL                \s
                                   LLII    LL        \s
                                   LLIIIIIILL        \s
                                   LLIIIIIILL        \s
                                     IIIIIILL        \s
                                     IIIIII          \s
                                   IIIIII            \s
                                   IIIIII            \s
                                 IIIIIIIIII          \s
                             LLLLIILLLLIIII          \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIIIILLLLIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLL  IIIIII  LLLL      \s
                                           LLLL      \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(12, 0),
                                    new Position(21, 1),
                                    new Position(6, 9),
                                    new Position(23, 10))),
        ROT_02("""
                                      LL             \s
                                      LL             \s
                                    LLLLIIII  LL     \s
                                    LLIIIIIIIILL     \s
                                      IIIIIILL       \s
                                      IIIIIILL       \s
                              LL    IIIIIIII         \s
                              LLLLIIIIIIII           \s
                              LLLLIILLIIII           \s
                            LLLLLLIILLLLIIII         \s
                            LLLLIIIILLLLIIII         \s
                            LLLLIIIIIILLIIIILL       \s
                              LL  IIIIIIIILLLLLL     \s
                                  IIIIIIIILLLLLL     \s
                                    IIIILLLLLL       \s
                                        LLLL         \s
                                          LL         \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(16, 0),
                                    new Position(24, 2),
                                    new Position(8, 6),
                                    new Position(24, 12))),
        ROT_03("""
                                                     \s
                                        LL           \s
                                      LLLL           \s
                                      LLIIII         \s
                                        IIIIIIIILL   \s
                              LL        IIIIIILLLL   \s
                              LLLL  IIIIIIIIIILL     \s
                              LLLLIIIIIIIIII         \s
                            LLLLLLIILLIIIIII         \s
                            LLLLLLIILLLLIIII         \s
                            LLLLIIIILLLLLLII         \s
                              LL  IIIILLIIII         \s
                                  IIIIIIIILL         \s
                                  IIIIIILLLLLL       \s
                                    IIIILLLLLL       \s
                                      LLLLLL         \s
                                      LLLLLL         \s
                                        LL           \s
                                                     \s
                                                     \s
                       """, List.of(new Position(18, 1),
                                    new Position(26, 4),
                                    new Position(9, 5),
                                    new Position(22, 13))),
        ROT_04("""
                                                     \s
                                          LL         \s
                                        LLLL         \s
                                        LLIIII       \s
                                LL        IIII       \s
                                LLLL    IIIIIIII     \s
                              LLLLLLIIIIIIIIIIIILL   \s
                            LLLLLLIIIIIIIIIIIILLLL   \s
                            LLLLLLIILLIIIIIIIILL     \s
                            LLLLIIIILLLLIIII         \s
                              LLIIIILLLLLLII         \s
                                IIIIIILLIIII         \s
                                IIIIIIIIII           \s
                                  IIIIIILL           \s
                                    IILLLLLL         \s
                                    LLLLLLLL         \s
                                    LLLLLL           \s
                                      LL             \s
                                                     \s
                                                     \s
                       """, List.of(new Position(20, 1),
                                    new Position(26, 6),
                                    new Position(10, 5),
                                    new Position(20, 14))),
        ROT_05("""
                                                     \s
                                                     \s
                                            LL       \s
                                          LLLL       \s
                                LL        LLIIII     \s
                              LLLLLL    IIIIIIII     \s
                              LLLLLLIIIIIIIIIIII     \s
                            LLLLLLIIIIIIIIIIIIIILL   \s
                            LLLLLLIILLIIIIIIIILLLL   \s
                              LLIIIILLLLIIII  LL     \s
                                IIIILLLLLLII         \s
                                IIIIIILLIIII         \s
                                  IIIIIIII           \s
                                  IIIIIILL           \s
                                      LLLLLL         \s
                                    LLLLLLLL         \s
                                    LLLLLL           \s
                                      LL             \s
                                                     \s
                                                     \s
                       """, List.of(new Position(22, 2),
                                    new Position(26, 7),
                                    new Position(10, 5),
                                    new Position(20, 14))),
        ROT_06("""
                                                     \s
                                                     \s
                                                     \s
                                           LLLL      \s
                                 LLLL    LLLLLL      \s
                             LLLLLLLL    LLIIII      \s
                             LLLLLLLLIIIIIIIIIIII    \s
                             LLLLIIIIIIIIIIIIIIII    \s
                                 IIIILLIIIIIIIIIILL  \s
                               IIIIIILLLLIIIIIILLLL  \s
                               IIIIIILLLLIIII  LL    \s
                               IIIIIILLIIII          \s
                               IIIIIIIIIIII          \s
                                 IIIIIIII            \s
                                     IILLLL          \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                   LLLL              \s
                                                     \s
                                                     \s
                       """, List.of(new Position(23, 3),
                                    new Position(27, 8),
                                    new Position(13, 4),
                                    new Position(19, 15))),
        ROT_07("""
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                               LLLLLLLL              \s
                               LLLLLLLL      LLLLLL  \s
                               LLLLLLLL      LLLLLL  \s
                                 IIIIIIIIIIIIIIII    \s
                                 IIIILLIIIIIIIIIIII  \s
                               IIIIIILLLLIIIIIIIIII  \s
                               IIIIIILLLLIIIIIIIIII  \s
                               IIIIIILLIIIIIIIILLLLLL\s
                                 IIIIIIIIII    LLLLLL\s
                                 IIIIIIII            \s
                                   IIIIII            \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                                     \s
                                                     \s
                       """, List.of(new Position(27, 5),
                                    new Position(29, 12),
                                    new Position(17, 17),
                                    new Position(15, 4))),
        ROT_08("""
                                                     \s
                                                     \s
                                                     \s
                               LLLLLLLL              \s
                               LLLLLLLL              \s
                               LLLLLLLL      LLLLLL  \s
                                 IIIIII      LLLLLL  \s
                                 IIIIIIIIII  IIII    \s
                               IIIIIILLIIIIIIIIIIII  \s
                               IIIIIILLLLIIIIIIIIII  \s
                               IIIIIILLLLIIIIIIIIII  \s
                               IIIIIILLIIIIIIIIIIII  \s
                                 IIIIIIIIII  IIII    \s
                                 IIIIII      LLLLLL  \s
                               LLLLLLLL      LLLLLL  \s
                               LLLLLLLL              \s
                               LLLLLLLL              \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(15, 3),
                                    new Position(15, 16),
                                    new Position(27, 5),
                                    new Position(27, 14))),
        ROT_09("""
                                                     \s
                                                     \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                   IIIIII            \s
                                 IIIIIIII            \s
                                 IIIIIIIIII    LLLLLL\s
                               IIIIIILLIIIIIIIILLLLLL\s
                               IIIIIILLLLIIIIIIIIII  \s
                               IIIIIILLLLIIIIIIIIII  \s
                                 IIIILLIIIIIIIIIIII  \s
                                 IIIIIIIIIIIIIIII    \s
                               LLLLLLLL      LLLLLL  \s
                               LLLLLLLL      LLLLLL  \s
                               LLLLLLLL              \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(17, 2),
                                    new Position(15, 15),
                                    new Position(29, 7),
                                    new Position(27, 14))),
        ROT_10("""
                                                     \s
                                                     \s
                                   LLLL              \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                     IILLLL          \s
                                 IIIIIIII            \s
                               IIIIIIIIIIII          \s
                               IIIIIILLIIII          \s
                               IIIIIILLLLIIII  LL    \s
                               IIIIIILLLLIIIIIILLLL  \s
                                 IIIILLIIIIIIIIIILL  \s
                             LLLLIIIIIIIIIIIIIIII    \s
                             LLLLLLLLIIIIIIIIIIII    \s
                             LLLLLLLL    LLIIII      \s
                                 LLLL    LLLLLL      \s
                                           LLLL      \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(19, 4),
                                    new Position(27, 11),
                                    new Position(23, 16),
                                    new Position(13, 15))),
        ROT_11("""
                                                     \s
                                                     \s
                                      LL             \s
                                    LLLLLL           \s
                                    LLLLLLLL         \s
                                      LLLLLL         \s
                                  IIIIIILL           \s
                                  IIIIIIII           \s
                                IIIIIILLIIII         \s
                                IIIILLLLLLII         \s
                              LLIIIILLLLIIII  LL     \s
                            LLLLLLIILLIIIIIIIILLLL   \s
                            LLLLLLIIIIIIIIIIIIIILL   \s
                              LLLLLLIIIIIIIIIIII     \s
                              LLLLLL    IIIIIIII     \s
                                LL        LLIIII     \s
                                          LLLL       \s
                                            LL       \s
                                                     \s
                                                     \s
                       """, List.of(new Position(26, 12),
                                    new Position(22, 17),
                                    new Position(10, 15),
                                    new Position(20, 5))),
        ROT_12("""
                                                     \s
                                                     \s
                                      LL             \s
                                    LLLLLL           \s
                                    LLLLLLLL         \s
                                    IILLLLLL         \s
                                  IIIIIILL           \s
                                IIIIIIIIII           \s
                                IIIIIILLIIII         \s
                              LLIIIILLLLLLII         \s
                            LLLLIIIILLLLIIII         \s
                            LLLLLLIILLIIIIIIIILL     \s
                            LLLLLLIIIIIIIIIIIILLLL   \s
                              LLLLLLIIIIIIIIIIIILL   \s
                                LLLL    IIIIIIII     \s
                                LL        IIII       \s
                                        LLIIII       \s
                                        LLLL         \s
                                          LL         \s
                                                     \s
                       """, List.of(new Position(26, 13),
                                    new Position(20, 18),
                                    new Position(20, 5),
                                    new Position(10, 15))),
        ROT_13("""
                                                     \s
                                                     \s
                                        LL           \s
                                      LLLLLL         \s
                                      LLLLLL         \s
                                    IIIILLLLLL       \s
                                  IIIIIILLLLLL       \s
                                  IIIIIIIILL         \s
                              LL  IIIILLIIII         \s
                            LLLLIIIILLLLLLII         \s
                            LLLLLLIILLLLIIII         \s
                            LLLLLLIILLIIIIII         \s
                              LLLLIIIIIIIIII         \s
                              LLLL  IIIIIIIIIILL     \s
                              LL        IIIIIILLLL   \s
                                        IIIIIIIILL   \s
                                      LLIIII         \s
                                      LLLL           \s
                                        LL           \s
                                                     \s
                       """, List.of(new Position(26, 15),
                                    new Position(17, 18),
                                    new Position(22, 6),
                                    new Position(8, 14))),
        ROT_14("""
                                                     \s
                                                     \s
                                                     \s
                                          LL         \s
                                        LLLL         \s
                                    IIIILLLLLL       \s
                                  IIIIIIIILLLLLL     \s
                              LL  IIIIIIIILLLLLL     \s
                            LLLLIIIIIILLIIIILL       \s
                            LLLLIIIILLLLIIII         \s
                            LLLLLLIILLLLIIII         \s
                              LLLLIILLIIII           \s
                              LLLLIIIIIIII           \s
                              LL    IIIIIIII         \s
                                      IIIIIILL       \s
                                      IIIIIILL       \s
                                    LLIIIIIIIILL     \s
                                    LLLLIIII  LL     \s
                                      LL             \s
                                      LL             \s
                       """, List.of(new Position(16, 19),
                                    new Position(24, 17),
                                    new Position(24, 7),
                                    new Position(8, 13))),
        ROT_15("""
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                                           LLLL      \s
                             LLLL  IIIIII  LLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIILLLLIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIILLLLIIII          \s
                                 IIIIIIIIII          \s
                                   IIIIII            \s
                                   IIIIII            \s
                                     IIIIII          \s
                                     IIIIIILL        \s
                                   LLIIIIIILL        \s
                                   LLIIIIIILL        \s
                                   LLII    LL        \s
                                   LL                \s
                       """, List.of(new Position(21, 18),
                                    new Position(12, 19),
                                    new Position(6, 10),
                                    new Position(23, 9))),
        ROT_16("""
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                             LLLL  IIIIII  LLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIILLIIIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                                 IIIILLIIII          \s
                                   IIIIII            \s
                                   IIIIII            \s
                                   IIIIII            \s
                                   IIIIII            \s
                                 LLIIIIIILL          \s
                                 LLIIIIIILL          \s
                                 LLIIIIIILL          \s
                                 LL      LL          \s
                       """, List.of(new Position(19, 19),
                                    new Position(10, 19),
                                    new Position(6, 10),
                                    new Position(23, 10))),
        ROT_17("""
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                             LLLL                    \s
                             LLLL  IIIIII  LLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIILLLLIIIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                                 IIIILLLLIILLLL      \s
                                 IIIIIIIIII          \s
                                   IIIIII            \s
                                   IIIIII            \s
                                 IIIIII              \s
                               LLIIIIII              \s
                               LLIIIIIILL            \s
                               LLIIIIIILL            \s
                               LL    IILL            \s
                                       LL            \s
                       """, List.of(new Position(17, 19),
                                    new Position(8, 18),
                                    new Position(6, 9),
                                    new Position(23, 10))),
        ROT_18("""
                                                     \s
                                                     \s
                                                     \s
                                 LL                  \s
                                 LLLL                \s
                               LLLLLLIIII            \s
                             LLLLLLIIIIIIII          \s
                             LLLLLLIIIIIIII  LL      \s
                               LLIIIILLIIIIIILLLL    \s
                                 IIIILLLLIIIILLLL    \s
                                 IIIILLLLIILLLLLL    \s
                                   IIIILLIILLLL      \s
                                   IIIIIIIILLLL      \s
                                 IIIIIIII    LL      \s
                               LLIIIIII              \s
                               LLIIIIII              \s
                             LLIIIIIIIILL            \s
                             LL  IIIILLLL            \s
                                     LL              \s
                                     LL              \s
                       """, List.of(new Position(15, 19),
                                    new Position(6, 17),
                                    new Position(22, 13),
                                    new Position(6, 7))),
        ROT_19("""
                                                     \s
                                                     \s
                                   LL                \s
                                 LLLLLL              \s
                                 LLLLLL              \s
                               LLLLLLIIII            \s
                               LLLLLLIIIIII          \s
                                 LLIIIIIIII          \s
                                 IIIILLIIII  LL      \s
                                 IILLLLLLIIIILLLL    \s
                                 IIIILLLLIILLLLLL    \s
                                 IIIIIILLIILLLLLL    \s
                                 IIIIIIIIIILLLL      \s
                             LLIIIIIIIIII  LLLL      \s
                           LLLLIIIIII        LL      \s
                           LLIIIIIIII                \s
                                 IIIILL              \s
                                   LLLL              \s
                                   LL                \s
                                                     \s
                       """, List.of(new Position(4, 15),
                                    new Position(12, 17),
                                    new Position(8, 6),
                                    new Position(22, 13))),
        ROT_20("""
                                                     \s
                                                     \s
                                     LL              \s
                                   LLLLLL            \s
                                 LLLLLLLL            \s
                                 LLLLLLII            \s
                                   LLIIIIII          \s
                                   IIIIIIIIII        \s
                                 IIIILLIIIIII        \s
                                 IILLLLLLIIIILL      \s
                                 IIIILLLLIIIILLLL    \s
                             LLIIIIIIIILLIILLLLLL    \s
                           LLLLIIIIIIIIIIIILLLLLL    \s
                           LLIIIIIIIIIIIILLLLLL      \s
                             IIIIIIII    LLLL        \s
                               IIII        LL        \s
                               IIIILL                \s
                                 LLLL                \s
                                 LL                  \s
                                                     \s
                       """, List.of(new Position(4, 13),
                                    new Position(10, 18),
                                    new Position(10, 5),
                                    new Position(20, 14))),
        ROT_21("""
                                                     \s
                                                     \s
                                     LL              \s
                                   LLLLLL            \s
                                 LLLLLLLL            \s
                                 LLLLLL              \s
                                   LLIIIIII          \s
                                   IIIIIIII          \s
                                 IIIILLIIIIII        \s
                                 IILLLLLLIIII        \s
                             LL  IIIILLLLIIIILL      \s
                           LLLLIIIIIIIILLIILLLLLL    \s
                           LLIIIIIIIIIIIIIILLLLLL    \s
                             IIIIIIIIIIIILLLLLL      \s
                             IIIIIIII    LLLLLL      \s
                             IIIILL        LL        \s
                               LLLL                  \s
                               LL                    \s
                                                     \s
                                                     \s
                       """, List.of(new Position(8, 17),
                                    new Position(4, 12),
                                    new Position(10, 5),
                                    new Position(19, 15))),
        ROT_22("""
                                                     \s
                                                     \s
                                     LLLL            \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                 LLLLII              \s
                                   IIIIIIII          \s
                                 IIIIIIIIIIII        \s
                                 IIIILLIIIIII        \s
                           LL  IIIILLLLIIIIII        \s
                         LLLLIIIIIILLLLIIIIII        \s
                         LLIIIIIIIIIILLIIII          \s
                           IIIIIIIIIIIIIIIILLLL      \s
                           IIIIIIIIIIIILLLLLLLL      \s
                             IIIILL    LLLLLLLL      \s
                             LLLLLL    LLLL          \s
                             LLLL                    \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(6, 16),
                                    new Position(2, 11),
                                    new Position(10, 4),
                                    new Position(16, 15))),
        ROT_23("""
                                                     \s
                                                     \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                   IIIIII            \s
                                   IIIIIIII          \s
                       LLLLLL    IIIIIIIIII          \s
                       LLLLLLIIIIIIIILLIIIIII        \s
                         IIIIIIIIIILLLLIIIIII        \s
                         IIIIIIIIIILLLLIIIIII        \s
                         IIIIIIIIIIIILLIIII          \s
                           IIIIIIIIIIIIIIII          \s
                         LLLLLL      LLLLLLLL        \s
                         LLLLLL      LLLLLLLL        \s
                                     LLLLLLLL        \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(2, 14),
                                    new Position(0, 7),
                                    new Position(12, 2),
                                    new Position(14, 15))),
        ROT_24("""
                                                     \s
                                                     \s
                                                     \s
                                     LLLLLLLL        \s
                                     LLLLLLLL        \s
                         LLLLLL      LLLLLLLL        \s
                         LLLLLL      IIIIII          \s
                           IIII  IIIIIIIIII          \s
                         IIIIIIIIIIIILLIIIIII        \s
                         IIIIIIIIIILLLLIIIIII        \s
                         IIIIIIIIIILLLLIIIIII        \s
                         IIIIIIIIIIIILLIIIIII        \s
                           IIII  IIIIIIIIII          \s
                         LLLLLL      IIIIII          \s
                         LLLLLL      LLLLLLLL        \s
                                     LLLLLLLL        \s
                                     LLLLLLLL        \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(2, 5),
                                    new Position(2, 14),
                                    new Position(14, 3),
                                    new Position(14, 16))),
        ROT_25("""
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                                     LLLLLLLL        \s
                         LLLLLL      LLLLLLLL        \s
                         LLLLLL      LLLLLLLL        \s
                           IIIIIIIIIIIIIIII          \s
                         IIIIIIIIIIIILLIIII          \s
                         IIIIIIIIIILLLLIIIIII        \s
                         IIIIIIIIIILLLLIIIIII        \s
                       LLLLLLIIIIIIIILLIIIIII        \s
                       LLLLLL    IIIIIIIIII          \s
                                   IIIIIIII          \s
                                   IIIIII            \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                   LLLLLLLL          \s
                                                     \s
                                                     \s
                       """, List.of(new Position(2, 5),
                                    new Position(0, 12),
                                    new Position(14, 4),
                                    new Position(12, 17))),
        ROT_26("""
                                                     \s
                                                     \s
                                                     \s
                             LLLL                    \s
                             LLLLLL    LLLL          \s
                             IIIILL    LLLLLLLL      \s
                           IIIIIIIIIIIILLLLLLLL      \s
                           IIIIIIIIIIIIIIIILLLL      \s
                         LLIIIIIIIIIILLIIII          \s
                         LLLLIIIIIILLLLIIIIII        \s
                           LL  IIIILLLLIIIIII        \s
                                 IIIILLIIIIII        \s
                                 IIIIIIIIIIII        \s
                                   IIIIIIII          \s
                                 LLLLII              \s
                                 LLLLLLLL            \s
                                 LLLLLLLL            \s
                                     LLLL            \s
                                                     \s
                                                     \s
                       """, List.of(new Position(6, 3),
                                    new Position(2, 8),
                                    new Position(17, 4),
                                    new Position(10, 15))),
        ROT_27("""
                                                     \s
                                                     \s
                              LL                     \s
                              LLLL                   \s
                            IIIILL        LL         \s
                            IIIIIIII    LLLLLL       \s
                            IIIIIIIIIIIILLLLLL       \s
                          LLIIIIIIIIIIIIIILLLLLL     \s
                          LLLLIIIIIIIILLIILLLLLL     \s
                            LL  IIIILLLLIIIILL       \s
                                IILLLLLLIIII         \s
                                IIIILLIIIIII         \s
                                  IIIIIIII           \s
                                  LLIIIIII           \s
                                LLLLLL               \s
                                LLLLLLLL             \s
                                  LLLLLL             \s
                                    LL               \s
                                                     \s
                                                     \s
                       """, List.of(new Position(7, 2),
                                    new Position(3, 7),
                                    new Position(19, 4),
                                    new Position(9, 14))),
        ROT_28("""
                                                     \s
                                LL                   \s
                                LLLL                 \s
                              IIIILL                 \s
                              IIII        LL         \s
                            IIIIIIII    LLLL         \s
                          LLIIIIIIIIIIIILLLLLL       \s
                          LLLLIIIIIIIIIIIILLLLLL     \s
                            LLIIIIIIIILLIILLLLLL     \s
                                IIIILLLLIIIILLLL     \s
                                IILLLLLLIIIILL       \s
                                IIIILLIIIIII         \s
                                  IIIIIIIIII         \s
                                  LLIIIIII           \s
                                LLLLLLII             \s
                                LLLLLLLL             \s
                                  LLLLLL             \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(9, 1),
                                    new Position(3, 6),
                                    new Position(19, 4),
                                    new Position(9, 14))),
        ROT_29("""
                                                     \s
                                  LL                 \s
                                  LLLL               \s
                                IIIILL               \s
                          LLIIIIIIII                 \s
                          LLLLIIIIII        LL       \s
                            LLIIIIIIIIII  LLLL       \s
                                IIIIIIIIIILLLL       \s
                                IIIIIILLIILLLLLL     \s
                                IIIILLLLIILLLLLL     \s
                                IILLLLLLIIIILLLL     \s
                                IIIILLIIII  LL       \s
                                LLIIIIIIII           \s
                              LLLLLLIIIIII           \s
                              LLLLLLIIII             \s
                                LLLLLL               \s
                                LLLLLL               \s
                                  LL                 \s
                                                     \s
                                                     \s
                       """, List.of(new Position(11, 1),
                                    new Position(3, 4),
                                    new Position(7, 13),
                                    new Position(21, 5))),
        ROT_30("""
                                    LL               \s
                                    LL               \s
                            LL  IIIILLLL             \s
                            LLIIIIIIIILL             \s
                              LLIIIIII               \s
                              LLIIIIII               \s
                                IIIIIIII    LL       \s
                                  IIIIIIIILLLL       \s
                                  IIIILLIILLLL       \s
                                IIIILLLLIILLLLLL     \s
                                IIIILLLLIIIILLLL     \s
                              LLIIIILLIIIIIILLLL     \s
                            LLLLLLIIIIIIII  LL       \s
                            LLLLLLIIIIIIII           \s
                              LLLLLLIIII             \s
                                LLLL                 \s
                                LL                   \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(14, 0),
                                    new Position(5, 2),
                                    new Position(5, 12),
                                    new Position(21, 6))),
        ROT_31("""
                                       LL            \s
                               LL    IILL            \s
                               LLIIIIIILL            \s
                               LLIIIIIILL            \s
                               LLIIIIII              \s
                                 IIIIII              \s
                                   IIIIII            \s
                                   IIIIII            \s
                                 IIIIIIIIII          \s
                                 IIIILLLLIILLLL      \s
                             LLLLIILLLLLLIILLLL      \s
                             LLLLIILLLLIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLLIIIIIIIIIILLLL      \s
                             LLLL  IIIIII  LLLL      \s
                             LLLL                    \s
                                                     \s
                                                     \s
                                                     \s
                                                     \s
                       """, List.of(new Position(8, 1),
                                    new Position(17, 0),
                                    new Position(6, 10),
                                    new Position(23, 9)));
        private final String tile;
        private final ArrayList<Position> collisionPointsInBlocks;

        CarRotation(String tile, List<Position> collisionPointsInBlocks) {
            this.tile = tile;
            this.collisionPointsInBlocks = new ArrayList<>(collisionPointsInBlocks);
        }

        String blockImage() {
            return tile;
        }

        ArrayList<Position> getCollisionPositionsInBlocks() {
            return collisionPointsInBlocks;
        }
    }

    enum Fire {
        FIRE_00("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                          HHHHHHHHHHHHHH                \s
                          HHHHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_01("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHHHHHHHHH        \s
                          HHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_02("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                        HH      HHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_03("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                        HHHH    HHHHHHHHHHHHHHHH        \s
                        HH      HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HH  HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_04("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HH  HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_05("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_06("""
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                        HHHHHHHH        \s
                                        HHHHHHHH        \s
                                    HHHHHHHHHHHHHHHH    \s
                                    HHHHHHHHHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_07("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_08("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_09("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_10("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_11("""
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                        HHHHHHHH        \s
                                        HHHHHHHH        \s
                                    HHHHHHHHHHHHHHHH    \s
                                    HHHHHHHHHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_12("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_13("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_14("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_15("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_16("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_17("""
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                        HHHHHHHH        \s
                                        HHHHHHHH        \s
                                    HHHHHHHHHHHHHHHH    \s
                                    HHHHHHHHHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_18("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_19("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_20("""
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                        HHHHHHHH        \s
                                        HHHHHHHH        \s
                                    HHHHHHHHHHHHHHHH    \s
                                    HHHHHHHHHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                                HHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                            HHHHHHHHIIIIHHHHIIIIIIIIHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIIIIIHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIIIIIHHHHHHHHHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """),
        FIRE_21("""
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHH            \s
                                HHHHHHHHHHHH            \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                            HHHHHHHHHHHH                \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHHHHHHHHHHHHHHHHH        \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHIIIIHHHHHHHHHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                            HHHHHHHHIIIIIIIIIIIIHHHH    \s
                        """),
        FIRE_22("""
                                    HHHHHHHH            \s
                                    HHHHHHHH            \s
                                        HHHH            \s
                                        HHHH            \s
                                    HHHHHHHHHHHH        \s
                                    HHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                                HHHHHHHHHHHHHHHH        \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                            HHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHHHHHIIIIHHHHHHHH    \s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHHHHHIIIIHHHHHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHIIIIHHHHIIIIHHHHHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                        HHHHHHHHHHHHHHHHHHHHIIIIHHHHHHHH\s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                            HHHHHHHHIIIIIIIIHHHHHHHH    \s
                        """);
        private final String tile;

        Fire(String tile) {
            this.tile = tile;
        }

        String blockImage() {
            return tile;
        }
    }
}
