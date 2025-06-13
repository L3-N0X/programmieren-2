package thd.game.bin;

import thd.game.managers.GameViewManager;

import javax.sound.sampled.LineUnavailableException;

class StartGame {

    /**
     * Starts the game "Rally Speedway"
     *
     * @param args optional arguments
     */
    public static void main(String[] args) throws LineUnavailableException {
        new GameViewManager();
    }
}
