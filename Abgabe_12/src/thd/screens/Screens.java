package thd.screens;

import thd.game.utilities.FileAccess;
import thd.game.utilities.GameView;
import thd.game.utilities.PlayerScore;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse stellt Methoden zur Verfügung, um einfache Start- und Endbildschirme anzuzeigen. Die Benutzer können
 * zwischen verschiedenen Optionen wählen. Die Auswahl des Benutzers wird zurückgegeben.
 */
public class Screens {
    /**
     * Es wird ein Startbildschirm mit einem einfachen Auswahlmenü angezeigt: "Einfach", "Standard" und "Beenden". Die
     * Auswahl des Benutzers wird zurückgegeben. Falls "Beenden" gewählt wird, wird das Programm sofort beendet.
     *
     * @param gameView    Das aktuell genutzte GameView.
     * @param title       Titel des Programms. Der Titel wird automatisch zentriert und in roter Farbe dargestellt.
     *                    Bitte nur eine Zeile verwenden.
     * @param description Beschreibung des Programms. Die Beschreibung wird automatisch zentriert dargestellt. Sie
     *                    können bis zu 20 Zeilen mit je 60 Zeichen verwenden. Nennen Sie das Ziel des Spiels und
     *                    Beschreiben Sie die Steuerung.
     *                    <li>Welche Tasten müssen gedrückt werden, um das Spiel zu
     *                    steuern?
     *                    <li>Was ist das Ziel des Spiels?
     * @param preset      Die Vorauswahl der Schwierigkeitsstufe "Einfach" oder "Standard".
     * @return String des Buttons, den der User gewählt hat, also "Einfach" oder "Standard".
     */
    public static String showStartScreen(GameView gameView, String title, String description, String preset) {
        StartScreen startScreen = new StartScreen(gameView, title, description, preset);
        gameView.clearKeyEvents();
        startScreen.startScreenLoop();
        if (startScreen.getSelection().equals(GameInfo.EXIT_BUTTON)) {
            System.exit(0);
        }
        return startScreen.getSelection();
    }

    /**
     * Es wird ein Endbildschirm mit einem einfachen Auswahlmenü angezeigt: "Neu starten" und "Beenden". Falls "Beenden"
     * gewählt wird, wird das Programm sofort beendet. Falls "Neu starten" gewählt wird, läuft das Programm weiter.
     *
     * @param gameView Das aktuell genutzte GameView.
     * @param message  Nachricht, die der Benutzer angezeigt bekommt. Die Nachricht wird automatisch zentriert
     *                 dargestellt.
     */
    public static void showEndScreen(GameView gameView, String message) {
        EndScreen endScreen = new EndScreen(gameView, message);
        gameView.clearKeyEvents();
        endScreen.printEndScreen();
        if (endScreen.getSelection().equals(GameInfo.EXIT_BUTTON)) {
            System.exit(0);
        }
    }

    /**
     * Shows a name input screen for the player to enter their name.
     *
     * @param gameView Das aktuell genutzte GameView.
     * @param message  Nachricht, die der Benutzer angezeigt bekommt.
     * @return The entered player name, or empty string if cancelled.
     */
    public static String showNameInputScreen(GameView gameView, String message) {
        NameInputScreen nameInputScreen = new NameInputScreen(gameView, message);
        gameView.clearKeyEvents();
        nameInputScreen.startInputLoop();
        return nameInputScreen.getPlayerName();
    }

    /**
     * Shows the best list screen displaying all player scores.
     *
     * @param gameView Das aktuell genutzte GameView.
     */
    public static void showBestListScreen(GameView gameView) {
        BestListScreen bestListScreen = new BestListScreen(gameView);
        gameView.clearKeyEvents();
        bestListScreen.startViewLoop();
    }

    private static class StartScreen extends Screen {
        private final int bottomHeight;
        private final String title;
        private final Color titleColor;
        private final String description;
        private final int titleFontSize;

        private StartScreen(GameView gameView, String title, String description, String preset) {
            super(gameView, 20, 16);
            this.title = title;
            this.bottomHeight = GameView.HEIGHT / 5;
            this.titleColor = Color.RED.brighter();
            this.description = description;
            this.titleFontSize = 75;
            int boxHeight = 40;
            int boxWidth = 200;
            int x = (GameView.WIDTH - 5 * boxWidth - 8 * gap) / 2;
            int y = GameView.HEIGHT - boxHeight - gap;
            ArrayList<SimpleBox> simpleBoxes = new ArrayList<>(5);
            simpleBoxes.add(new SimpleBox(GameInfo.EASY_BUTTON, x, y, boxWidth, boxHeight));
            simpleBoxes.add(new SimpleBox(GameInfo.STANDARD_BUTTON, x + boxWidth + gap, y, boxWidth, boxHeight));
            simpleBoxes.add(new SimpleBox(GameInfo.HARD_BUTTON, x + 2 * boxWidth + 2 * gap, y, boxWidth, boxHeight));
            simpleBoxes.add(
                    new SimpleBox(GameInfo.BEST_LIST_BUTTON, x + 3 * boxWidth + 5 * gap, y, boxWidth, boxHeight));
            simpleBoxes.add(new SimpleBox(GameInfo.EXIT_BUTTON, x + 4 * boxWidth + 8 * gap, y, boxWidth, boxHeight));
            switch (preset) {
                case GameInfo.EASY_BUTTON -> setSimpleBoxes(simpleBoxes, 0);
                case GameInfo.HARD_BUTTON -> setSimpleBoxes(simpleBoxes, 2);
                default -> setSimpleBoxes(simpleBoxes, 1); // Standard is default
            }
        }

        private void startScreenLoop() {
            while (!screenClosed) {
                checkUserInput();
                addTitle();
                addDescription();
                addSimpleBoxes();
                gameView.plotCanvas();
            }
            gameView.useMouse(useMouseBackup);
        }

        private void addTitle() {
            Dimension textBounds = calculateTextBounds(title);
            double x = (GameView.WIDTH - (textBounds.width * titleFontSize * 0.605)) / 2d;
            gameView.addTextToCanvas(title, x, gap, titleFontSize, true, titleColor, 0, "droidsansmono.ttf");
        }

        private void addDescription() {
            Dimension textBounds = calculateTextBounds(description);
            double x = gap + (GameView.WIDTH - (textBounds.width * fontSize * 0.65)) / 2d;
            double y = gap + (GameView.HEIGHT - bottomHeight - (textBounds.height * fontSize)) / 2d;
            gameView.addTextToCanvas(description, x, y, fontSize, false, Color.WHITE, 0, "droidsansmono.ttf");
        }

        private void addSimpleBoxes() {
            simpleBoxes.forEach(s -> s.addToCanvas(gameView));
        }
    }

    private static class EndScreen extends Screen {
        private final String message;

        private EndScreen(GameView gameView, String message) {
            super(gameView, 20, 28);
            this.message = message;
            int boxHeight = 40;
            int boxWidth = 250;
            int x = (GameView.WIDTH - 2 * boxWidth - gap) / 2;
            int y = GameView.HEIGHT - boxHeight - gap;
            ArrayList<SimpleBox> simpleBoxes = new ArrayList<>(3);
            simpleBoxes.add(new SimpleBox(GameInfo.NEW_GAME_BUTTON, x, y, boxWidth, boxHeight));
            simpleBoxes.add(new SimpleBox(GameInfo.EXIT_BUTTON, x + boxWidth + gap, y, boxWidth, boxHeight));
            setSimpleBoxes(simpleBoxes, 0);
        }

        private void printEndScreen() {
            while (!screenClosed) {
                checkUserInput();
                addMessage();
                addSimpleBoxes();
                gameView.plotCanvas();
            }
            gameView.useMouse(useMouseBackup);
        }

        private void addMessage() {
            Dimension textBounds = calculateTextBounds(message);
            double x = gap + (GameView.WIDTH - (textBounds.width * fontSize * 0.65)) / 2d;
            double y = gap + (GameView.HEIGHT - GameView.HEIGHT / 5d - (textBounds.height * fontSize)) / 2d;
            gameView.addTextToCanvas(message, x, y, fontSize, false, Color.WHITE, 0, "droidsansmono.ttf");
        }

        private void addSimpleBoxes() {
            simpleBoxes.forEach(s -> s.addToCanvas(gameView));
        }
    }

    private static class NameInputScreen extends Screen {
        private final String message;
        private final StringBuilder playerName;
        private static final int MAX_NAME_LENGTH = 15;

        private NameInputScreen(GameView gameView, String message) {
            super(gameView, 20, 28);
            this.message = message;
            this.playerName = new StringBuilder();

            int boxHeight = 40;
            int boxWidth = 150;
            int x = (GameView.WIDTH - 2 * boxWidth - gap) / 2;
            int y = GameView.HEIGHT - boxHeight - gap;
            ArrayList<SimpleBox> simpleBoxes = new ArrayList<>();
            simpleBoxes.add(new SimpleBox("Ok", x, y, boxWidth, boxHeight));
            simpleBoxes.add(new SimpleBox("Abbrechen", x + boxWidth + gap, y, boxWidth, boxHeight));
            setSimpleBoxes(simpleBoxes, 0);
        }

        private void startInputLoop() {
            while (!screenClosed) {
                checkUserInput();
                addMessage();
                addNameInput();
                addSimpleBoxes();
                gameView.plotCanvas();
            }
            gameView.useMouse(useMouseBackup);
        }

        @Override
        protected void checkUserInput() {
            for (KeyEvent keyEvent : gameView.typedKeys()) {
                char keyChar = keyEvent.getKeyChar();

                if (Character.isLetter(keyChar) && playerName.length() < MAX_NAME_LENGTH) {
                    playerName.append(Character.toUpperCase(keyChar));
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && !playerName.isEmpty()) {
                    playerName.deleteCharAt(playerName.length() - 1);
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER && !playerName.isEmpty()) {
                    screenClosed = true;
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    playerName.setLength(0);
                    screenClosed = true;
                }
            }

            for (MouseEvent mouseEvent : gameView.mouseEvents()) {
                if (mouseEvent.getID() == MouseEvent.MOUSE_PRESSED) {
                    if (selectionManager.processMouseEvent(mouseEvent.getX(), mouseEvent.getY())) {
                        if (getSelection().equals("Abbrechen")) {
                            playerName.setLength(0);
                        }
                        screenClosed = true;
                    }
                }
            }
        }

        private void addMessage() {
            Dimension textBounds = calculateTextBounds(message);
            double x = gap + (GameView.WIDTH - (textBounds.width * fontSize * 0.65)) / 2d;
            double y = gap + 50;
            gameView.addTextToCanvas(message, x, y, fontSize, false, Color.WHITE, 0, "droidsansmono.ttf");
        }

        private void addNameInput() {
            String displayName = playerName.toString() + "_";
            gameView.addTextToCanvas("Name: " + displayName,
                                     GameView.WIDTH / 2d - 100,
                                     GameView.HEIGHT / 2d - 50,
                                     32, true, Color.YELLOW, 0, "droidsansmono.ttf");
        }

        private void addSimpleBoxes() {
            if (!playerName.isEmpty()) {
                simpleBoxes.get(0).addToCanvas(gameView);
            }
            simpleBoxes.get(1).addToCanvas(gameView);
        }

        public String getPlayerName() {
            return playerName.toString().trim();
        }
    }

    private static class BestListScreen extends Screen {
        private final List<PlayerScore> scores;
        private int currentPage;
        private static final int SCORES_PER_PAGE = 10;

        private BestListScreen(GameView gameView) {
            super(gameView, 20, 20);
            this.scores = FileAccess.readPlayerScores();
            this.currentPage = 0;

            Collections.sort(scores);

            int boxHeight = 40;
            int boxWidth = 150;
            int x = (GameView.WIDTH - boxWidth) / 2;
            int y = GameView.HEIGHT - boxHeight - gap;
            ArrayList<SimpleBox> simpleBoxes = new ArrayList<>();
            simpleBoxes.add(new SimpleBox(GameInfo.BACK_BUTTON, x, y, boxWidth, boxHeight));
            setSimpleBoxes(simpleBoxes, 0);
        }

        private void startViewLoop() {
            while (!screenClosed) {
                checkUserInput();
                addTitle();
                addScoresList();
                addPageInfo();
                addSimpleBoxes();
                gameView.plotCanvas();
            }
            gameView.useMouse(useMouseBackup);
        }

        @Override
        protected void checkUserInput() {
            for (KeyEvent keyEvent : gameView.typedKeys()) {
                if ((keyEvent.getKeyCode() == KeyEvent.VK_W || keyEvent.getKeyCode() == KeyEvent.VK_UP)
                    && currentPage > 0) {
                    currentPage--;
                } else if ((keyEvent.getKeyCode() == KeyEvent.VK_S || keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
                           && (currentPage + 1) * SCORES_PER_PAGE < scores.size()) {
                    currentPage++;
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE || keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    screenClosed = true;
                }
            }

            // Handle mouse clicks
            for (MouseEvent mouseEvent : gameView.mouseEvents()) {
                if (mouseEvent.getID() == MouseEvent.MOUSE_PRESSED) {
                    if (selectionManager.processMouseEvent(mouseEvent.getX(), mouseEvent.getY())) {
                        screenClosed = true;
                    }
                }
            }
        }

        private void addTitle() {
            gameView.addTextToCanvas(GameInfo.BEST_LIST_TITLE, GameView.WIDTH / 2d - 100, 50, 40, true, Color.YELLOW, 0,
                                     "droidsansmono.ttf");
        }

        private void addScoresList() {
            int startIndex = currentPage * SCORES_PER_PAGE;
            int endIndex = Math.min(startIndex + SCORES_PER_PAGE, scores.size());

            if (scores.isEmpty()) {
                gameView.addTextToCanvas(GameInfo.NO_BEST_LIST_ENTRY, GameView.WIDTH / 2d - 80, 200, 24, false,
                                         Color.WHITE, 0,
                                         "droidsansmono.ttf");
                return;
            }

            for (int i = startIndex; i < endIndex; i++) {
                String line = formatLine(i);
                gameView.addTextToCanvas(line, 50, 150 + (i - startIndex) * 30, 18, false, Color.WHITE, 0,
                                         "droidsansmono.ttf");
            }
        }

        private String formatLine(int i) {
            PlayerScore score = scores.get(i);
            int rank = i + 1;
            return String.format("%2d. %-15s %-11s (%-20s)    [%-8s]   %s",
                                 rank,
                                 score.playerName,
                                 score.formatBestRoundTime(),
                                 score.levelName,
                                 score.difficulty,
                                 score.formatAchievedDate());
        }

        private void addPageInfo() {
            if (scores.size() > SCORES_PER_PAGE) {
                int totalPages = (scores.size() + SCORES_PER_PAGE - 1) / SCORES_PER_PAGE;
                String pageInfo = String.format(GameInfo.CHANGE_PAGE_INFO,
                                                currentPage + 1,
                                                totalPages);
                gameView.addTextToCanvas(pageInfo, GameView.WIDTH / 2d - 150, GameView.HEIGHT - 100, 16, false,
                                         Color.GRAY, 0, "droidsansmono.ttf");
            }
        }

        private void addSimpleBoxes() {
            simpleBoxes.forEach(s -> s.addToCanvas(gameView));
        }
    }

    private static class Screen {
        protected final GameView gameView;
        protected final int gap;
        protected final int fontSize;
        protected final boolean useMouseBackup;
        protected boolean screenClosed;
        protected ArrayList<SimpleBox> simpleBoxes;
        protected SelectionManager selectionManager;

        protected Screen(GameView gameView, int gap, int fontSize) {
            this.gameView = gameView;
            this.gap = gap;
            this.fontSize = fontSize;
            this.useMouseBackup = gameView.mouseIsEnabled();
            this.gameView.useMouse(true);
        }

        protected void setSimpleBoxes(ArrayList<SimpleBox> simpleBoxes, int highLighted) {
            this.simpleBoxes = simpleBoxes;
            this.selectionManager = new SelectionManager(simpleBoxes, highLighted);
        }

        protected void checkUserInput() {
            for (KeyEvent keyEvent : gameView.typedKeys()) {
                selectionManager.processKeyEvent(keyEvent);
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    screenClosed = true;
                }
            }
            for (MouseEvent mouseEvent : gameView.mouseEvents()) {
                if (mouseEvent.getID() == MouseEvent.MOUSE_PRESSED) {
                    if (selectionManager.processMouseEvent(mouseEvent.getX(), mouseEvent.getY())) {
                        screenClosed = true;
                    }
                }
            }
        }

        protected Dimension calculateTextBounds(String text) {
            String[] lines = text.split("\\R");
            int longestLine = Arrays.stream(lines).mapToInt(String::length).max().orElse(1);
            return new Dimension(longestLine, Math.max(1, lines.length));
        }

        protected String getSelection() {
            return simpleBoxes.get(selectionManager.highlightedBox).text;
        }

        private static class SelectionManager {
            private final ArrayList<SimpleBox> simpleBoxes;
            private int highlightedBox;

            private SelectionManager(ArrayList<SimpleBox> simpleBoxes, int highlightedBox) {
                this.simpleBoxes = simpleBoxes;
                this.highlightedBox = highlightedBox;
                this.simpleBoxes.get(highlightedBox).isHighlighted = true;
            }

            private void processKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                    highlight(highlightedBox + 1);
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                    highlight(highlightedBox - 1);
                }
            }

            private boolean processMouseEvent(int x, int y) {
                for (int i = 0; i < simpleBoxes.size(); i++) {
                    SimpleBox simpleBox = simpleBoxes.get(i);
                    if (simpleBox.contains(x, y)) {
                        highlight(i);
                        return true;
                    }
                }
                return false;
            }

            private void highlight(int boxToHighlight) {
                if (boxToHighlight >= 0 && boxToHighlight < simpleBoxes.size()) {
                    simpleBoxes.forEach(s -> s.isHighlighted = false);
                    simpleBoxes.get(boxToHighlight).isHighlighted = true;
                    highlightedBox = boxToHighlight;
                }
            }
        }
    }

    private static class SimpleBox extends Rectangle {
        private final String text;
        private final int fontSize;
        private boolean isHighlighted;

        private SimpleBox(String text, int x, int y, int width, int height) {
            super(x, y, width, height);
            this.text = text;
            this.fontSize = height * 2 / 3;
        }

        private void addToCanvas(GameView gameView) {
            if (isHighlighted) {
                gameView.addRectangleToCanvas(x, y, width, height, 3, true, Color.DARK_GRAY);
                gameView.addRectangleToCanvas(x, y, width, height, 3, false, Color.YELLOW);
            } else {
                gameView.addRectangleToCanvas(x, y, width, height, 3, false, Color.WHITE);
            }
            gameView.addTextToCanvas(text,
                                     x + (width - text.length() * fontSize * 0.65) / 2d,
                                     y + (height - fontSize * 3 / 2d) / 2d, fontSize, true, Color.WHITE, 0,
                                     "droidsansmono.ttf");
        }
    }
}
