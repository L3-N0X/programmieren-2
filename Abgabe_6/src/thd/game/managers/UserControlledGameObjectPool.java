package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

import java.awt.*;
import java.awt.event.KeyEvent;

class UserControlledGameObjectPool {
    protected final GameView gameView;
    protected HouseBig houseBig;
    protected RocksVeryMany rocksVeryMany;
    protected HouseCorner houseCorner;
    protected TrackHorizontal trackHorizontal;
    protected TrackBendLE trackBendLE;
    protected TrackCurveN trackCurveN;
    protected Car car;
    protected LapTimeDisplay lapTimeDisplay;
    protected LastTimeDisplay lastTimeDisplay;
    protected BestTimeDisplay bestTimeDisplay;

    protected UserControlledGameObjectPool(GameView gameView) {
        this.gameView = gameView;
    }

    protected void gameLoop() {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        car.isBreaking = false;
        for (int keyCode : pressedKeys) {
            gameView.addTextToCanvas("Taste " + ((char) keyCode) + " gedrückt", 0, 0, 18,
                                     true, Color.WHITE, 0);
            processKeyCode(keyCode);
        }
        if (car.startedDriving && !car.isBreaking) {
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
            car.startedDriving = true;
        } else if (keyCode == KeyEvent.VK_SPACE) {
            car.shoot();
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            car.isBreaking = true;
            car.down();
        }
    }
}
