package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * A random green ball which targets another ball.
 */
public class FollowerBall extends GameObject {
    private final RandomBall followMe;

    /**
     * Creates a new moving FollowerBall tile in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     * @param followMe A RandomBall to follow
     */
    public FollowerBall(GameView gameView, RandomBall followMe) {
        super(gameView);
        this.followMe = followMe;
        position.updateCoordinates(new Position(0, 0));
        targetPosition.updateCoordinates(followMe.getPosition());
        speedInPixel = 3;
        size = 50;
    }

    @Override
    public void updatePosition() {
        position.moveToPosition(targetPosition, speedInPixel);

        targetPosition.updateCoordinates(followMe.getPosition());
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.getX(), position.getY(), size, size, 2, true, new Color(0x1C7229));
    }

    @Override
    public String toString() {
        return "FollowerBall: " + position;
    }
}
