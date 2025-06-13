package thd.gameobjects.movable;

import java.util.Random;
import thd.gameobjects.base.Position;

public class ShakeMovementPattern {

    private final Random random;

    public ShakeMovementPattern() {
        random = new Random();
    }

    public Position nextPosition(double shakeDistance) {
        if (shakeDistance > 0) {
            return new Position(random.nextDouble(shakeDistance), random.nextDouble(shakeDistance));
        } else {
            return new Position();
        }
    }
}
