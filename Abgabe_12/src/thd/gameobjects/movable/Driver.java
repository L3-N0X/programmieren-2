package thd.gameobjects.movable;

import thd.game.managers.GameManager;
import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * The Driver of the car, only used for crash visualization.
 */
class Driver extends GameObject {

    private enum DriverRollLeftState {
        LEFT_ROLL_01(DriverBlockImages.DriverTiles.ROLL_LEFT_00.blockImage()),
        LEFT_ROLL_02(DriverBlockImages.DriverTiles.ROLL_LEFT_01.blockImage()),
        LEFT_ROLL_03(DriverBlockImages.DriverTiles.ROLL_LEFT_02.blockImage()),
        LEFT_ROLL_04(DriverBlockImages.DriverTiles.ROLL_LEFT_03.blockImage()),
        LEFT_ROLL_05(DriverBlockImages.DriverTiles.ROLL_LEFT_04.blockImage()),
        LEFT_ROLL_06(DriverBlockImages.DriverTiles.ROLL_LEFT_05.blockImage()),
        LEFT_ROLL_07(DriverBlockImages.DriverTiles.ROLL_LEFT_06.blockImage()),
        LEFT_ROLL_08(DriverBlockImages.DriverTiles.ROLL_LEFT_07.blockImage()),
        LEFT_ROLL_09(DriverBlockImages.DriverTiles.ROLL_LEFT_08.blockImage()),
        LEFT_ROLL_10(DriverBlockImages.DriverTiles.ROLL_LEFT_09.blockImage()),
        LEFT_ROLL_11(DriverBlockImages.DriverTiles.ROLL_LEFT_10.blockImage()),
        LEFT_ROLL_12(DriverBlockImages.DriverTiles.ROLL_LEFT_11.blockImage()),
        LEFT_ROLL_13(DriverBlockImages.DriverTiles.ROLL_LEFT_12.blockImage()),
        LEFT_ROLL_14(DriverBlockImages.DriverTiles.ROLL_LEFT_13.blockImage()),
        LEFT_ROLL_15(DriverBlockImages.DriverTiles.ROLL_LEFT_14.blockImage()),
        LEFT_ROLL_16(DriverBlockImages.DriverTiles.ROLL_LEFT_15.blockImage()),
        LEFT_ROLL_17(DriverBlockImages.DriverTiles.ROLL_LEFT_16.blockImage()),
        LEFT_ROLL_18(DriverBlockImages.DriverTiles.ROLL_LEFT_17.blockImage()),
        LEFT_ROLL_19(DriverBlockImages.DriverTiles.ROLL_LEFT_18.blockImage()),
        LEFT_ROLL_20(DriverBlockImages.DriverTiles.ROLL_LEFT_19.blockImage()),
        LEFT_ROLL_21(DriverBlockImages.DriverTiles.ROLL_LEFT_20.blockImage()),
        LEFT_ROLL_22(DriverBlockImages.DriverTiles.ROLL_LEFT_21.blockImage()),
        LEFT_ROLL_23(DriverBlockImages.DriverTiles.ROLL_LEFT_22.blockImage()),
        LEFT_ROLL_24(DriverBlockImages.DriverTiles.ROLL_LEFT_23.blockImage()),
        LEFT_ROLL_25(DriverBlockImages.DriverTiles.ROLL_LEFT_24.blockImage()),
        LEFT_ROLL_26(DriverBlockImages.DriverTiles.ROLL_LEFT_25.blockImage()),
        LEFT_ROLL_27(DriverBlockImages.DriverTiles.ROLL_LEFT_26.blockImage()),
        LEFT_ROLL_28(DriverBlockImages.DriverTiles.ROLL_LEFT_27.blockImage()),
        LEFT_ROLL_29(DriverBlockImages.DriverTiles.ROLL_LEFT_28.blockImage(), 0),
        LEFT_ROLL_30(DriverBlockImages.DriverTiles.ROLL_LEFT_29.blockImage(), 0);

        private final String blockImage;
        private final int xOffset;

        DriverRollLeftState(String blockImage, int xOffset) {
            this.blockImage = blockImage;
            this.xOffset = xOffset;
        }

        DriverRollLeftState(String blockImage) {
            this.blockImage = blockImage;
            this.xOffset = -12;
        }
    }

    private enum DriverRollRightState {
        RIGHT_ROLL_01(DriverBlockImages.DriverTiles.ROLL_RIGHT_00.blockImage()),
        RIGHT_ROLL_02(DriverBlockImages.DriverTiles.ROLL_RIGHT_01.blockImage()),
        RIGHT_ROLL_03(DriverBlockImages.DriverTiles.ROLL_RIGHT_02.blockImage()),
        RIGHT_ROLL_04(DriverBlockImages.DriverTiles.ROLL_RIGHT_03.blockImage()),
        RIGHT_ROLL_05(DriverBlockImages.DriverTiles.ROLL_RIGHT_04.blockImage()),
        RIGHT_ROLL_06(DriverBlockImages.DriverTiles.ROLL_RIGHT_05.blockImage()),
        RIGHT_ROLL_07(DriverBlockImages.DriverTiles.ROLL_RIGHT_06.blockImage()),
        RIGHT_ROLL_08(DriverBlockImages.DriverTiles.ROLL_RIGHT_07.blockImage()),
        RIGHT_ROLL_09(DriverBlockImages.DriverTiles.ROLL_RIGHT_08.blockImage()),
        RIGHT_ROLL_10(DriverBlockImages.DriverTiles.ROLL_RIGHT_09.blockImage()),
        RIGHT_ROLL_11(DriverBlockImages.DriverTiles.ROLL_RIGHT_10.blockImage()),
        RIGHT_ROLL_12(DriverBlockImages.DriverTiles.ROLL_RIGHT_11.blockImage()),
        RIGHT_ROLL_13(DriverBlockImages.DriverTiles.ROLL_RIGHT_12.blockImage()),
        RIGHT_ROLL_14(DriverBlockImages.DriverTiles.ROLL_RIGHT_13.blockImage()),
        RIGHT_ROLL_15(DriverBlockImages.DriverTiles.ROLL_RIGHT_14.blockImage()),
        RIGHT_ROLL_16(DriverBlockImages.DriverTiles.ROLL_RIGHT_15.blockImage()),
        RIGHT_ROLL_17(DriverBlockImages.DriverTiles.ROLL_RIGHT_16.blockImage()),
        RIGHT_ROLL_18(DriverBlockImages.DriverTiles.ROLL_RIGHT_17.blockImage()),
        RIGHT_ROLL_19(DriverBlockImages.DriverTiles.ROLL_RIGHT_18.blockImage()),
        RIGHT_ROLL_20(DriverBlockImages.DriverTiles.ROLL_RIGHT_19.blockImage()),
        RIGHT_ROLL_21(DriverBlockImages.DriverTiles.ROLL_RIGHT_20.blockImage()),
        RIGHT_ROLL_22(DriverBlockImages.DriverTiles.ROLL_RIGHT_21.blockImage()),
        RIGHT_ROLL_23(DriverBlockImages.DriverTiles.ROLL_RIGHT_22.blockImage()),
        RIGHT_ROLL_24(DriverBlockImages.DriverTiles.ROLL_RIGHT_23.blockImage()),
        RIGHT_ROLL_25(DriverBlockImages.DriverTiles.ROLL_RIGHT_24.blockImage()),
        RIGHT_ROLL_26(DriverBlockImages.DriverTiles.ROLL_RIGHT_25.blockImage()),
        RIGHT_ROLL_27(DriverBlockImages.DriverTiles.ROLL_RIGHT_26.blockImage()),
        RIGHT_ROLL_28(DriverBlockImages.DriverTiles.ROLL_RIGHT_27.blockImage()),
        RIGHT_ROLL_29(DriverBlockImages.DriverTiles.ROLL_RIGHT_28.blockImage(), 0),
        RIGHT_ROLL_30(DriverBlockImages.DriverTiles.ROLL_RIGHT_29.blockImage(), 0);

        private final String blockImage;
        private final int xOffset;

        DriverRollRightState(String blockImage, int xOffset) {
            this.blockImage = blockImage;
            this.xOffset = xOffset;
        }

        DriverRollRightState(String blockImage) {
            this.blockImage = blockImage;
            this.xOffset = 12;
        }
    }

    private enum DriverLeftState {
        LEFT_01(DriverBlockImages.DriverTiles.LEFT_00.blockImage(), -10),
        LEFT_02(DriverBlockImages.DriverTiles.LEFT_01.blockImage(), -10),
        LEFT_03(DriverBlockImages.DriverTiles.LEFT_02.blockImage(), 0),
        LEFT_04(DriverBlockImages.DriverTiles.LEFT_03.blockImage(), 0);

        private final String blockImage;
        private final int xOffset;

        DriverLeftState(String blockImage, int xOffset) {
            this.blockImage = blockImage;
            this.xOffset = xOffset;
        }
    }

    private enum DriverRightState {
        RIGHT_01(DriverBlockImages.DriverTiles.RIGHT_00.blockImage(), 10),
        RIGHT_02(DriverBlockImages.DriverTiles.RIGHT_01.blockImage(), 10),
        RIGHT_03(DriverBlockImages.DriverTiles.RIGHT_02.blockImage(), 0),
        RIGHT_04(DriverBlockImages.DriverTiles.RIGHT_03.blockImage(), 0);

        private final String blockImage;
        private final int xOffset;

        DriverRightState(String blockImage, int xOffset) {
            this.blockImage = blockImage;
            this.xOffset = xOffset;
        }
    }

    private enum State {
        ROLLING_LEFT, ROLLING_RIGHT, RIGHT, LEFT, NONE;
    }

    private DriverRollLeftState driverRollLeftState;
    private DriverRollRightState driverRollRightState;
    private DriverLeftState driverLeftState;
    private DriverRightState driverRightState;
    private State currentState;

    private int animationCounter;

    /**
     * Creates a new driver in the game at a default position.
     *
     * @param gameView        the main {@link GameView} where the text later gets
     *                        added to
     * @param gamePlayManager Manages the game with spawning, despawning and more.
     */
    Driver(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(100, 100);
        speedInPixel = 5;
        size = GamePlayManager.BLOCK_SIZE;
        width = DriverBlockImages.TILE_WIDTH * size;
        height = DriverBlockImages.TILE_HEIGHT * size;
        distanceToBackground = 8;
        driverRollLeftState = DriverRollLeftState.LEFT_ROLL_01;
        driverRollRightState = DriverRollRightState.RIGHT_ROLL_01;
        driverLeftState = DriverLeftState.LEFT_01;
        driverRightState = DriverRightState.RIGHT_01;
        currentState = State.NONE;
        animationCounter = 0;
    }

    Driver(GameView gameView, GamePlayManager gamePlayManager, double x, double y) {
        this(gameView, gamePlayManager);
        position.updateCoordinates(x, y);
    }

    private void switchToNextLeftRollState() {
        int nextState = (driverRollLeftState.ordinal() + 1);
        if (nextState == DriverRollLeftState.values().length) {
            nextState = DriverRollLeftState.values().length - 2;
        }
        driverRollLeftState = DriverRollLeftState.values()[nextState];
    }

    private void switchToNextRightRollState() {
        int nextState = (driverRollRightState.ordinal() + 1);
        if (nextState == DriverRollRightState.values().length) {
            nextState = DriverRollRightState.values().length - 2;
        }
        driverRollRightState = DriverRollRightState.values()[nextState];
    }

    private void switchToNextRightState() {
        int nextState;
        if (animationCounter < 30) {
            nextState = animationCounter % 2;
        } else {
            nextState = 2 + animationCounter % 2;
        }
        driverRightState = DriverRightState.values()[nextState];
        animationCounter++;
    }

    private void switchToNextLeftState() {
        int nextState;
        if (animationCounter < 30) {
            nextState = animationCounter % 2;
        } else {
            nextState = 2 + animationCounter % 2;
        }
        driverLeftState = DriverLeftState.values()[nextState];
        animationCounter++;
    }

    private void applyAnimationOffsets() {
        int xOffset = switch (currentState) {
            case ROLLING_LEFT -> driverRollLeftState.xOffset;
            case ROLLING_RIGHT -> driverRollRightState.xOffset;
            case RIGHT -> driverRightState.xOffset;
            case LEFT -> driverLeftState.xOffset;
            case NONE -> 0;
        };
        position.updateCoordinates(position.getX() + xOffset, position.getY());
    }

    /**
     * This starts a left fire roll crash animation for the driver.
     */
    void crashRollLeft() {
        currentState = State.ROLLING_LEFT;
    }

    /**
     * This starts a right fire roll crash animation for the driver.
     */
    void crashRollRight() {
        currentState = State.ROLLING_RIGHT;
    }

    /**
     * This starts a right crash animation for the driver.
     */
    void crashRight() {
        currentState = State.RIGHT;
    }

    /**
     * This starts a right crash animation for the driver.
     */
    void crashLeft() {
        currentState = State.LEFT;
    }

    @Override
    public void updateStatus() {
        boolean animationFrame = gameView.timer(80, 0, this);
        if (!animationFrame) {
            return;
        }
        switch (currentState) {
            case ROLLING_LEFT -> switchToNextLeftRollState();
            case ROLLING_RIGHT -> switchToNextRightRollState();
            case RIGHT -> switchToNextRightState();
            case LEFT -> switchToNextLeftState();
            default -> {
                return;
            }
        }
        applyAnimationOffsets();
    }

    @Override
    public void addToCanvas() {
        String blockImage = switch (currentState) {
            case ROLLING_LEFT -> driverRollLeftState.blockImage;
            case ROLLING_RIGHT -> driverRollRightState.blockImage;
            case RIGHT -> driverRightState.blockImage;
            case LEFT -> driverLeftState.blockImage;
            case NONE -> "";
        };
        String translatedBlockImage = GameManager.translateBlockImageForLevel(
                blockImage, gamePlayManager.getCurrentLevel());
        gameView.addBlockImageToCanvas(translatedBlockImage, position.getX(), position.getY(), size, 0);
    }

    @Override
    public String toString() {
        return "Driver: " + position;
    }
}
