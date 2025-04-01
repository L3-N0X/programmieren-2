package thd.gameobjects.unmoveable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

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
        gameView.addTextToCanvas("Objekt 1", position.getX(), position.getY(), size, true, Color.YELLOW, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
