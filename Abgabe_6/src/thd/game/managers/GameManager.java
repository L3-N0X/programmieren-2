package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

class GameManager extends GamePlayManager {

    GameManager(GameView gameView) {
        super(gameView);

        houseBig = new HouseBig(gameView, this);
        rocksVeryMany = new RocksVeryMany(gameView, this);
        trackHorizontal = new TrackHorizontal(gameView, this);
        trackBendLE = new TrackBendLE(gameView, this);
        trackCurveN = new TrackCurveN(gameView, this);
        houseCorner = new HouseCorner(gameView, this);
        car = new Car(gameView, this);
        lapTimeDisplay = new LapTimeDisplay(gameView, this);
        lastTimeDisplay = new LastTimeDisplay(gameView, this);
        bestTimeDisplay = new BestTimeDisplay(gameView, this);

        spawnGameObject(houseBig);
        spawnGameObject(rocksVeryMany);
        spawnGameObject(trackHorizontal);
        spawnGameObject(trackBendLE);
        spawnGameObject(trackCurveN);
        spawnGameObject(houseCorner);
        spawnGameObject(car);
        spawnGameObject(lapTimeDisplay);
        spawnGameObject(lastTimeDisplay);
        spawnGameObject(bestTimeDisplay);
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameManagement();
    }

    private void gameManagement() {

    }
}
