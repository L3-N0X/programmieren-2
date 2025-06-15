package thd.screens;

/**
 * This class contains information about the game, such as the title and description.
 */
public class GameInfo {
    /**
     * The title of the game, displayed in the window title and start screen.
     */
    public static final String TITLE = "RALLY SPEEDWAY";
    /**
     * The description of the game, displayed in the start screen. It contains instructions on how to play the game.
     */
    public static final String DESCRIPTION = """
            Sie fahren mit Ihrem Rennwagen über eine Rennstrecke und müssen dabei Hindernissen ausweichen.
            Versuchen Sie, die Runden-Bestzeit zu schlagen!
            
            Ein Rennen besteht aus 3 Runden, die Sie in der schnellstmöglichen Zeit absolvieren müssen.
            Die beste Rundenzeit wird gespeichert und kann in der Bestenliste eingesehen werden.
            
            Sie fahren mit WASD oder den Pfeiltasten. Dabei gilt:
            
              W             = Starten, Auto beschleunigt dann automatisch
              S / Leertaste = Bremsen
              A / D         = nach links/rechts lenken
              Q / E         = Wechselt die Map zu einem anderen Level
              R             = Level neu starten (Fortschritt wird nicht gespeichert)
            """;

    public static final String ENTER_NAME_MESSAGE = "Rennen erfolgreich beendet!\n"
                                                    + "Bitte geben Sie Ihren Namen ein, um Ihre Zeit zu speichern:";

    public static final String EASY_BUTTON = "Einfach";
    public static final String STANDARD_BUTTON = "Standard";
    public static final String HARD_BUTTON = "Schwer";

    public static final String BEST_LIST_BUTTON = "Bestenliste";
    public static final String EXIT_BUTTON = "Beenden";

    public static final String NEW_GAME_BUTTON = "Neues Spiel";
    public static final String BACK_BUTTON = "Zurück";

    public static final String BEST_LIST_TITLE = "BESTENLISTE";
    public static final String NO_BEST_LIST_ENTRY = "Noch keine gespeicherten Zeiten vorhanden.";
    public static final String CHANGE_PAGE_INFO = "Seite %d/%d - Nutze W/S oder Pfeiltasten um zu blättern";
    public static final String END_SCREEN_MESSAGE = """
            Rennen auf %s erfolgreich beendet!
            Ihre beste Zeit: %s
            
            Wählen Sie "Neues Spiel", um ein weiteres Rennen zu starten!""";
}
