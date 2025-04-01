package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

public class LapTimeDisplay {
    GameView gameView;
    Position position;
    double size;
    double rotation;
    double width;

    public LapTimeDisplay(GameView gameView) {
        this.gameView = gameView;
        width = 145;
        size = 20;
        rotation = 0;
        position = new Position(30, (int) (GameView.HEIGHT - size - 50));
    }

    public void addToCanvas() {
        gameView.addTextToCanvas("Time", position.getX(), position.getY(), size, true, Color.WHITE, rotation, "bold.ttf");
        gameView.addTextToCanvas("0:00:0", position.getX() - 8, position.getY() + size * 1.4, size, true, Color.WHITE, rotation, "bold.ttf");
    }

    @Override
    public String toString() {
        return "LapTime: " + position;
    }
}
