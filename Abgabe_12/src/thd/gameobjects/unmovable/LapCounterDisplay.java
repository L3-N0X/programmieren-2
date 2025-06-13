package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

public class LapCounterDisplay extends GameObject {

    protected final Position defaultPosition;

    public LapCounterDisplay(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 35;
        width = size * 3.2;
        height = size * 1.5;
        distanceToBackground = 30;
        defaultPosition = new Position(GameView.WIDTH - width - 5, 0);
        position.updateCoordinates(defaultPosition);
    }

    @Override
    public void updatePosition() {
        Position shakeOffset = gamePlayManager.carShakeOffset();
        position.updateCoordinates(
                defaultPosition.getX() + shakeOffset.getX(),
                defaultPosition.getY() + shakeOffset.getY());
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(gamePlayManager.getCurrentLap() + "/" + gamePlayManager.getMaxLaps(), position.getX(),
                position.getY(), size,
                true,
                Color.WHITE, rotation,
                "kongtext.ttf");
    }
}
