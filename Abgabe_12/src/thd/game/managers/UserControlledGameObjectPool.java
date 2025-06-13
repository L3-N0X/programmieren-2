package thd.game.managers;

import java.awt.*;
import java.awt.event.KeyEvent;
import thd.game.level.Level;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.Car;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;
import thd.gameobjects.unmovable.Overlay;

class UserControlledGameObjectPool {
    protected final GameView gameView;
    protected Car car;
    protected LapTimeDisplay lapTimeDisplay;
    protected LastTimeDisplay lastTimeDisplay;
    protected BestTimeDisplay bestTimeDisplay;
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
            if (GameViewManager.debug) {
                gameView.addTextToCanvas("Taste " + ((char) keyCode) + " gedrückt", 0, 0, 18,
                        true, Color.WHITE, 0);
            }
            processKeyCode(keyCode);
        }
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
                lapTimeDisplay.getGuiTimer().start();
            }
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_SPACE) {
            currentlyBreaking = true;
            if (car.isDriving()) {
                car.down();
            }
        } else if (keyCode == KeyEvent.VK_E && gameView.timer(2000, 0, this)) {
            cycleToNextLevel();
        } else if (keyCode == KeyEvent.VK_Q && gameView.timer(2000, 0, this)) {
            cycleToPreviousLevel();
        } else if (keyCode == KeyEvent.VK_F3 && gameView.timer(100, 0, this)) {
            GameViewManager.debug = !GameViewManager.debug;
        }
    }

    protected void cycleToNextLevel() {

    }

    protected void cycleToPreviousLevel() {

    }
}
