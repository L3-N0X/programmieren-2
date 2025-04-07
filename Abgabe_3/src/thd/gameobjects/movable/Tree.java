package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * A BlockImage of a tree as GameObject.
 */
public class Tree extends GameObject {
    private static final int TREE_BLOCK_SIZE = 16;
    private final ShakeMovementPattern shakeMovementPattern;
    private Position shakeOrigin;

    /**
     * Creates a new moving Tree BlockImage in the game at a default position.
     *
     * @param gameView the main {@link thd.game.utilities.GameView} where the text later gets added to
     * @see TreeBlockImages for the Image that gets rendered
     */
    public Tree(GameView gameView) {
        super(gameView);
        position.updateCoordinates(0, (double) GameView.HEIGHT / 2);
        speedInPixel = 5;
        size = 1;
        width = TREE_BLOCK_SIZE * 4;
        height = TREE_BLOCK_SIZE * 7;
        shakeMovementPattern = new ShakeMovementPattern();
        shakeOrigin = new Position(position);
    }

    @Override
    public void updatePosition() {
        if (gameView.timer(1000, 3000, this)) {
            position.updateCoordinates(shakeMovementPattern.nextPosition(shakeOrigin, 8));
        } else {
            position.right(speedInPixel);
            rotation++;
            shakeOrigin.updateCoordinates(position);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(TreeBlockImages.TREE, position.getX(), position.getY(), TREE_BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
