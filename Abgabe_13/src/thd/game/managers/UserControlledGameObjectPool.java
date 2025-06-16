package thd.game.managers;

import thd.game.level.Level;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.Car;
import thd.gameobjects.unmovable.*;

import java.awt.event.KeyEvent;

class UserControlledGameObjectPool {
    protected final GameView gameView;
    protected Car car;
    protected LapTimeDisplay lapTimeDisplay;
    protected LastTimeDisplay lastTimeDisplay;
    protected BestTimeDisplay bestTimeDisplay;
    protected LapCounterDisplay lapCounterDisplay;
    protected Level level;
    protected Overlay overlay;

    private boolean currentlyBreaking;

    protected UserControlledGameObjectPool(GameView gameView) {
        this.gameView = gameView;
        currentlyBreaking = false;
    }

    protected void gameLoop() {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        currentlyBreaking = false;
        for (int keyCode : pressedKeys) {
            processKeyCode(keyCode);
        }

        // Handle key press/release events for level changes and debug toggle
        handleKeyEvents();

        if (car.isDriving() && !currentlyBreaking) {
            car.up();
            car.updateAccelerationTimer();
        }
    }

    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            car.left();
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            car.right();
        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            if (!car.isDriving()) {
                car.startDriving();
            }
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_SPACE) {
            currentlyBreaking = true;
            if (car.isDriving()) {
                car.down();
            }
        }
        // E, Q, and F3 keys are now handled in handleKeyEvents() method
    }

    /**
     * Handles key press/release events for single-press actions like level changes. Uses GameView's typedKeys() method
     * to get proper key press/release events instead of continuous key polling, ensuring single-press behavior.
     */
    private void handleKeyEvents() {
        KeyEvent[] keyEvents = gameView.typedKeys();
        for (KeyEvent keyEvent : keyEvents) {
            if (keyEvent.getID() == KeyEvent.KEY_RELEASED) { // Only trigger on key release
                if (keyEvent.getKeyCode() == KeyEvent.VK_E) {
                    cycleToNextLevel();
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_Q) {
                    cycleToPreviousLevel();
                } else if (keyEvent.getKeyCode() == KeyEvent.VK_R) {
                    resetCurrentLevel();
                }
            }
        }
    }

    protected void cycleToNextLevel() {

    }

    protected void cycleToPreviousLevel() {

    }

    protected void resetCurrentLevel() {

    }
}
