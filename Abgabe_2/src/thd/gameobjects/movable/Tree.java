package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

public class Tree {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;

    public Tree(GameView gameView) {
        this.gameView = gameView;
        position = new Position(0, GameView.HEIGHT / 2);
        speedInPixel = 5;
        size = 30;
        rotation = 0;
    }

    public void updatePosition() {
        position.right(speedInPixel);
        rotation++;
    }

    public void addToCanvas() {
        gameView.addBlockImageToCanvas(TreeBlockImages.TREE, position.getX(), position.getY(), 16, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
