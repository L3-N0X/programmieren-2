package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.Rock;
import thd.gameobjects.movable.Tree;
import thd.gameobjects.unmovable.LapTimeDisplay;

public class GameManager {

    private final Tree tree;
    private final Rock rock;
    private final LapTimeDisplay lapTimeDisplay;
    private final GameView gameView;

    GameManager(GameView gameView) {
        tree = new Tree(gameView);
        rock = new Rock(gameView);
        lapTimeDisplay = new LapTimeDisplay(gameView);
        this.gameView = gameView;
    }

    void gameLoop() {
        tree.updatePosition();
        tree.addToCanvas();

        rock.updatePosition();
        rock.addToCanvas();

        lapTimeDisplay.addToCanvas();
    }
}
