package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * A random yellow ball which targets a position.
 */
public class RandomBall extends GameObject {
    private final RandomMovementPattern randomMovementPattern;
    private final QuadraticMovementPattern quadraticMovementPattern;

    /**
     * Creates a new moving RandomBall tile in the game at a default position.
     *
     * @param gameView the main {@link GameView} where the text later gets added to
     */
    public RandomBall(GameView gameView) {
        super(gameView);
        randomMovementPattern = new RandomMovementPattern();
        quadraticMovementPattern = new QuadraticMovementPattern();
        position.updateCoordinates(randomMovementPattern.startPosition());
        targetPosition.updateCoordinates(quadraticMovementPattern.nextPosition());
        speedInPixel = 4;
        size = 50;
    }

    @Override
    public void updatePosition() {
        if (gameView.timer(3000, 0, this)) {
            speedInPixel++;
        }

        if (gameView.timer(1000, 4000, this)) {
            position.moveToPosition(targetPosition, speedInPixel);
        }

        if (position.similarTo(targetPosition)) {
            targetPosition.updateCoordinates(quadraticMovementPattern.nextPosition());
        }
    }

    @Override
    public void addToCanvas() {
        if (gameView.gameTimeInMilliseconds() < 5000) {
            gameView.addOvalToCanvas(position.getX(), position.getY(), size, size, 2, true, Color.YELLOW);
        } else {
            gameView.addOvalToCanvas(position.getX(), position.getY(), size, size, 2, true, Color.RED);
        }
        gameView.addOvalToCanvas(targetPosition.getX(), targetPosition.getY(), size, size, 2, false, Color.WHITE);
    }

    @Override
    public String toString() {
        return "RandomBall: " + position;
    }
}
