package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

class GameManager extends UserControlledGameObjectPool {

    GameManager(GameView gameView) {
        super(gameView);
        houseBig = new HouseBig(gameView);
        rocksVeryMany = new RocksVeryMany(gameView);
        trackHorizontal = new TrackHorizontal(gameView);
        trackBendLE = new TrackBendLE(gameView);
        trackCurveN = new TrackCurveN(gameView);
        houseCorner = new HouseCorner(gameView);
        car = new Car(gameView);
        lapTimeDisplay = new LapTimeDisplay(gameView);
        lastTimeDisplay = new LastTimeDisplay(gameView);
        bestTimeDisplay = new BestTimeDisplay(gameView);
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();

        rocksVeryMany.addToCanvas();
        houseBig.addToCanvas();
        trackBendLE.addToCanvas();
        trackHorizontal.addToCanvas();
        trackCurveN.addToCanvas();
        houseCorner.addToCanvas();

        car.updateStatus();
        car.updatePosition();
        car.addToCanvas();

        lapTimeDisplay.addToCanvas();
        lastTimeDisplay.addToCanvas();
        bestTimeDisplay.addToCanvas();
    }
}
