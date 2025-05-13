package thd.game.bin;

import thd.game.managers.GameViewManager;

class StartGame {

    /**
     * Startet das Spiel "Rally Speedway"
     *
     * @param args optionale Argumente
     */
    public static void main(String[] args) {
        new GameViewManager();
    }
}
