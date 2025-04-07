package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.FollowerBall;
import thd.gameobjects.movable.RandomBall;
import thd.gameobjects.movable.Rock;
import thd.gameobjects.movable.Tree;
import thd.gameobjects.unmovable.LapTimeDisplay;

class GameManager {

    private final Tree tree;
    private final Rock rock;
    private final RandomBall randomBall;
    private final FollowerBall followerBall;
    private final LapTimeDisplay lapTimeDisplay;
    private final GameView gameView;

    GameManager(GameView gameView) {
        tree = new Tree(gameView);
        rock = new Rock(gameView);
        randomBall = new RandomBall(gameView);
        followerBall = new FollowerBall(gameView, randomBall);
        lapTimeDisplay = new LapTimeDisplay(gameView);
        this.gameView = gameView;
    }

    void gameLoop() {
        tree.updatePosition();
        tree.addToCanvas();

        rock.updatePosition();
        rock.addToCanvas();

        randomBall.updatePosition();
        randomBall.addToCanvas();

        followerBall.updatePosition();
        followerBall.addToCanvas();

        lapTimeDisplay.addToCanvas();
    }
}
