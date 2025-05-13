package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingObject;
import thd.gameobjects.base.GameObject;

/**
 * A simple bullet {@link GameObject}.
 */
class Bullet extends CollidingGameObject {

    private enum ProjectileState {
        PROJECTILE_1("""
                              HHLLLLL\s
                             HIILLLLLL\s
                             H HLLLLL\s
                             """),
        PROJECTILE_2("""
                              HHLLLLL\s
                             HIHLLLLLL\s
                              HHLLLLL\s
                             """),
        PROJECTILE_3("""
                               HLLLLL\s
                             H HLLLLLL\s
                              HHLLLLL\s
                             """);
        private final String blockImage;

        ProjectileState(String blockImage) {
            this.blockImage = blockImage;
        }
    }

    private ProjectileState projectileState;

    /**
     * Creates a new bullet in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    Bullet(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(100, 100);
        speedInPixel = 9;
        size = 3;
        width = 6 * size;
        height = 3 * size;
        distanceToBackground = 20;
        hitBoxOffsets(width / 4, height / 4, -width / 2, -height / 2);
    }

    @Override
    public void reactToCollisionWith(CollidingObject other) {

    }

    Bullet(GameView gameView, GamePlayManager gamePlayManager, double x, double y, double rotation) {
        this(gameView, gamePlayManager);
        position.updateCoordinates(x, y);
        this.rotation = rotation;
    }

    private void switchToNextProjectileState() {
        int nextState = (currentCrashState.ordinal() + 1) % CarBlockImages.Fire.values().length;
        currentCrashState = CarBlockImages.Fire.values()[nextState];
    }

    @Override
    public void updatePosition() {
        double dx = Math.cos(rotation) * speedInPixel;
        double dy = Math.sin(rotation) * speedInPixel;
        position.updateCoordinates(position.getX() + dx, position.getY() + dy);
    }

    @Override
    public void updateStatus() {
        if (position.getX() > GameView.WIDTH
            || position.getY() > GameView.HEIGHT
            || position.getX() + height < 0
            || position.getY() + width < 0
        ) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas("LLLLL\nLLLLLL\nLLLLL", position.getX(), position.getY(), size,
                                       rotation / (2 * Math.PI) * 360);
    }

    @Override
    public String toString() {
        return "Rock: " + position;
    }
}
