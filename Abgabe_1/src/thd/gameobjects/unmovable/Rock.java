package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

public class Rock {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;
    double width;
    double height;

    public Rock(GameView gameView) {
        this.gameView = gameView;
        position = new Position(1100, 650);
        speedInPixel = 2;
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    /**
     * Changes the position of the GameObject with a predefined movement
     */
    public void updatePosition() {
        position.left(speedInPixel);
    }

    /**
     * Adds this object to the gameView, this should be called each frame to update the existing object
     */
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 0, true, Color.GREEN);
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 5, false, Color.WHITE);
        gameView.addTextToCanvas("Objekt 2", position.getX() + 4, position.getY() - 5, size, true, Color.BLUE, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
