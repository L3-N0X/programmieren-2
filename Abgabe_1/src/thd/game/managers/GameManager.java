package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.unmovable.LapTime;
import thd.gameobjects.unmovable.Rock;
import thd.gameobjects.unmovable.Tree;

public class GameManager {

    private Tree tree;
    private Rock rock;
    private LapTime lapTime;
    private GameView gameView;

    GameManager(GameView gameView) {
        tree = new Tree(gameView);
        rock = new Rock(gameView);
        lapTime = new LapTime(gameView);
        this.gameView = gameView;
        startGameLoop();
    }

    void startGameLoop() {
        while (gameView.isVisible()) {
            tree.updatePosition();
            tree.addToCanvas();

            rock.updatePosition();
            rock.addToCanvas();

            lapTime.addToCanvas();

            gameView.plotCanvas();
        }
    }
}
