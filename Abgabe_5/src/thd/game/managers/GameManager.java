package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

class GameManager extends UserControlledGameObjectPool {

    private final GameObjectManager gameObjectManager;

    GameManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();

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

        gameObjectManager.add(houseBig);
        gameObjectManager.add(rocksVeryMany);
        gameObjectManager.add(trackHorizontal);
        gameObjectManager.add(trackBendLE);
        gameObjectManager.add(trackCurveN);
        gameObjectManager.add(houseCorner);
        gameObjectManager.add(car);
        gameObjectManager.add(lapTimeDisplay);
        gameObjectManager.add(lastTimeDisplay);
        gameObjectManager.add(bestTimeDisplay);
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        gameObjectManager.gameLoop();
    }
}
