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
            Sie fahren mit Ihrem Rennwagen über eine Rennstrecke und müssen dabei Hindernissen ausweichen.\s
            Versuchen Sie, die Runden-Bestzeit zu schlagen!\s
            \s
            Ein Rennen besteht aus 3 Runden, die Sie in der schnellstmöglichen Zeit absolvieren müssen.\s
            Die beste Rundenzeit wird gespeichert und kann in der Bestenliste eingesehen werden.\s
            \s
            Sie fahren mit WASD oder den Pfeiltasten. Dabei gilt:\s
            \s
              W             = Starten, Auto beschleunigt dann automatisch\s
              S / Leertaste = Bremsen\s
              A / D         = nach links/rechts lenken\s
              Q / E         = Wechselt die Map zu einem anderen Level\s
              R             = Level neu starten (Fortschritt wird nicht gespeichert)\s
            """;

    /**
     * The message displayed when the player.
     */
    public static final String ENTER_NAME_MESSAGE = "Bitte geben Sie Ihren Namen ein, um Ihre Zeit zu speichern:";

    /**
     * The Easy button text.
     */
    public static final String EASY_BUTTON = "Einfach";

    /**
     * The Standard button text.
     */
    public static final String STANDARD_BUTTON = "Standard";

    /**
     * The Hard button text.
     */
    public static final String HARD_BUTTON = "Schwer";

    /**
     * The button text for the best list.
     */
    public static final String BEST_LIST_BUTTON = "Bestenliste";

    /**
     * The button text for the settings.
     */
    public static final String EXIT_BUTTON = "Beenden";

    /**
     * The button text for starting a new game.
     */
    public static final String NEW_GAME_BUTTON = "Neues Spiel";

    /**
     * The button text for starting a new game with the current settings.
     */
    public static final String BACK_BUTTON = "Zurück";

    /**
     * The title of the best list, displayed in the best list screen.
     */
    public static final String BEST_LIST_TITLE = "BESTENLISTE";

    /**
     * The message displayed when there are no best list entries yet.
     */
    public static final String NO_BEST_LIST_ENTRY = "Noch keine gespeicherten Zeiten vorhanden.";

    /**
     * The scroll hint displayed on the best list screen.
     */
    public static final String PAGE_INFO = "<- Seite %d/%d ->";
    public static final String CHANGE_PAGE_INFO = "Blättern: WASD oder Pfeiltasten";

    /**
     * The message displayed on the end screen.
     */
    public static final String END_SCREEN_MESSAGE = """
            Sie haben das Rennen auf %s erfolgreich abgeschlossen!\s
            \s
            Ihre beste Zeit war:  %s\s
            \s
            Wählen Sie "Neues Spiel", um ein weiteres Rennen zu starten!""";
    public static final String FINISHED_TITLE = "Rennen Beendet!";
}
