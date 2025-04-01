package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

public class Rock {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;
    static final double IMAGE_SCALE_FACTOR = 5;

    public Rock(GameView gameView) {
        this.gameView = gameView;
        position = new Position(1100, 50);
        speedInPixel = 2;
        size = 30;
        rotation = 0;
    }

    public void updatePosition() {
        position.left(speedInPixel);
    }

    public void addToCanvas() {
        gameView.addImageToCanvas("rocks_very_many.png", position.getX(), position.getY(), IMAGE_SCALE_FACTOR, rotation);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
