package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

class ShakeMovementPattern extends MovementPattern {

    ShakeMovementPattern() {
        super();
    }

    @Override
    protected Position startPosition() {
        return new Position(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
    }

    Position nextPosition(Position shakeOrigin, int strength) {
        return new Position(
                (random.nextInt(strength * 2) - strength) + shakeOrigin.getX(),
                (random.nextInt(strength * 2) - strength) + shakeOrigin.getY());
    }
}
