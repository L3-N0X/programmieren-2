package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

public class LapTime {
    GameView gameView;
    Position position;
    double size;
    double rotation;
    double width;

    public LapTime(GameView gameView) {
        this.gameView = gameView;
        width = 145;
        position = new Position((int) (GameView.WIDTH - width), -10);
        size = 30;
        rotation = 0;
    }

    public void addToCanvas() {
        gameView.addTextToCanvas("Objekt 3", position.getX(), position.getY(), size, true, Color.YELLOW, rotation);
    }

    @Override
    public String toString() {
        return "LapTime: " + position;
    }
}
