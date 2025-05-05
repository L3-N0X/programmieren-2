package thd.game.managers;

import thd.game.utilities.GameView;

class GameManager extends GameWorldManager {

    GameManager(GameView gameView) {
        super(gameView);
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameManagement();
    }

    private void gameManagement() {
    }
}
