package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

/**
 * A BlockImage of a tree as GameObject.
 */
public class Tree {
    private final GameView gameView;
    private final Position position;
    private final double speedInPixel;
    private double rotation;
    private static final int TREE_BLOCK_SIZE = 16;
    private final int size;
    private final int width;
    private final int height;

    /**
     * Creates a new moving Tree BlockImage in the game at a default position.
     *
     * @param gameView the main {@link thd.game.utilities.GameView} where the text later gets added to
     * @see TreeBlockImages for the Image that gets rendered
     */
    public Tree(GameView gameView) {
        this.gameView = gameView;
        position = new Position(0, (double) GameView.HEIGHT / 2);
        speedInPixel = 5;
        rotation = 0;
        size = 1;
        width = TREE_BLOCK_SIZE * 4;
        height = TREE_BLOCK_SIZE * 7;
    }

    /**
     * Changes the position of the GameObject with a predefined movement.
     */
    public void updatePosition() {
        position.right(speedInPixel);
        rotation++;
    }

    /**
     * Adds this object to the {@link thd.game.utilities.GameView}, this should be called each frame to update the existing object.
     */
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(TreeBlockImages.TREE, position.getX(), position.getY(), TREE_BLOCK_SIZE, rotation);
    }

    @Override
    public String toString() {
        return "Tree: " + position;
    }
}
