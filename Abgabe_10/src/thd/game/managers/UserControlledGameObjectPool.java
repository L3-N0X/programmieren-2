package thd.game.managers;

import thd.game.level.Level;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.Car;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;
import thd.gameobjects.unmovable.Overlay;

import java.awt.*;
import java.awt.event.KeyEvent;

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
            if (GameViewManager.DEBUG) {
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
                lapTimeDisplay.startLapTimer();
            }
        } else if (keyCode == KeyEvent.VK_SPACE) {
            car.shoot();
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            currentlyBreaking = true;
            if (car.isDriving()) {
                car.down();
            }
        }
    }
}
