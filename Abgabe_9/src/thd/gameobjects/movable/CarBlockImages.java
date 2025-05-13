package thd.gameobjects.movable;

public class CarBlockImages {
    static final int TILE_HEIGHT = 20;
    static final int TILE_WIDTH = 32;

    public enum CarRotation {
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """),
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
                       """);
        private final String tile;

        CarRotation(String tile) {
            this.tile = tile;
        }

        String blockImage() {
            return tile;
        }
    }

    public enum Fire {
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
