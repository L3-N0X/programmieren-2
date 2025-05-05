package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Car;
import thd.gameobjects.movable.GameBlockImages;
import thd.gameobjects.movable.TrackTile;
import thd.gameobjects.unmovable.BestTimeDisplay;
import thd.gameobjects.unmovable.LapTimeDisplay;
import thd.gameobjects.unmovable.LastTimeDisplay;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class GameWorldManager extends GamePlayManager {
    private final String world;
    private final List<GameObject> activatableGameObjects;

    private final int worldOffsetColumns;
    private final int worldOffsetLines;
    private final int tileOffsetColumnsInBlocks;
    private final int tileOffsetLinesInBlocks;

    protected GameWorldManager(GameView gameView) {
        super(gameView);
        world = """
                RRRRRRRRRRRRRRRRDRUuRRPUurVvRRRR
                RRRQRRRRRRRRRRRQ|QRUuqRrUMvrRRRR
                RqVmuHRQPHRRRRRR|RRRUuRRRRPRRRRR
                PVvhUA-S-buPRRRr|RRhrUurRRRRRRRR
                QDRRRRHRRQUuQRRR|RVmuRUuhRRRRRRR
                R|qRRRPVmuhUuhRq|QDRdRRUurPRQrPR
                R|RRRhVvRUuRWrRR|R|R|rRQUA-N-buR
                q|HRqVvPRqUMvHRR|H|h|RRRRrRqRRWr
                QCPRHwqRRHHPrRRq|R|R|HRRRRRRRVvR
                RUuRRUuhVmuPRRRr|h|h|RRRRRRrVvQR
                RHWQRRUMvPdRRRRR|R|H|QRRRRRRwPRR
                RVvRRqhHRh|rRRRQ|Q|R|RRRRRRPUurR
                PwRRQVmurR|qRRRR|R|H|HRRRRRRqUuR
                RUuRVvRWRq|HRRRrCHch|RRRRRRRRRdR
                RqUMvRVvQR|rRRRHUMvRcrRRRqRRRQ|r
                RRHrRVvrRR|qRRRRqQRVvRRhVmuHRR|R
                RRRRVvRRRH|PRRRRRhVvHRqVvRUuRP|R
                RRPVvqRRRr|qRRRRPVvrRrVvrRHWRQ|r
                RRrwRRRRRRCqRqRrVvPRHVvhRqVvHq|R
                RRqUuqRRRRUA--NavRRrVvRRRVvRRR|P
                RRRQUuHRRRrhRRrRRRqVvRRrVvHRRr|Q
                RRRRPUuPrRPqRQRRRrVvHRRVvhRRRRcR
                RRRRRrUA-N---N---avRRPVvRRRRRVvR
                RRRRRRHQRRrRPqRrRHPRRRwrRRRrVvQR
                RRRRRRRRRRRRRRRHVmuQRhUuhRRVvRRR
                """;
        car = new Car(gameView, this);
        lapTimeDisplay = new LapTimeDisplay(gameView, this);
        bestTimeDisplay = new BestTimeDisplay(gameView, this);
        lastTimeDisplay = new LastTimeDisplay(gameView, this);
        worldOffsetColumns = 6;
        worldOffsetLines = 2;
        tileOffsetColumnsInBlocks = 0;
        tileOffsetLinesInBlocks = 68;
        activatableGameObjects = new LinkedList<>();
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
    }

    private void spawnGameObjects() {
        spawnGameObject(car);
        spawnGameObject(lapTimeDisplay);
        spawnGameObject(bestTimeDisplay);
        spawnGameObject(lastTimeDisplay);
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    private void spawnGameObjectsFromWorldString() {
        String[] lines = world.split("\\R");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char character = lines[i].charAt(j);
                GameBlockImages.TrackTiles trackTile;
                if (character == 'G') {
                    trackTile = GameBlockImages.TrackTiles.GRASS;
                } else if (character == 'S') {
                    trackTile = GameBlockImages.TrackTiles.START_FINISH;
                } else if (character == '-') {
                    trackTile = GameBlockImages.TrackTiles.HORIZONTAL;
                } else if (character == 'N') {
                    trackTile = GameBlockImages.TrackTiles.NECK;
                } else if (character == '|') {
                    trackTile = GameBlockImages.TrackTiles.VERTICAL;
                } else if (character == 'X') {
                    trackTile = GameBlockImages.TrackTiles.CROSSROAD;
                } else if (character == 'R') {
                    trackTile = GameBlockImages.TrackTiles.ROCKS_VERY_MANY;
                } else if (character == 'r') {
                    trackTile = GameBlockImages.TrackTiles.ROCKS_MANY;
                } else if (character == 'Q') {
                    trackTile = GameBlockImages.TrackTiles.ROCKS_NOT_SO_MANY;
                } else if (character == 'q') {
                    trackTile = GameBlockImages.TrackTiles.ROCKS_FEW;
                } else if (character == 'H') {
                    trackTile = GameBlockImages.TrackTiles.HOUSE_BIG;
                } else if (character == 'h') {
                    trackTile = GameBlockImages.TrackTiles.HOUSE_CORNER;
                } else if (character == 'P') {
                    trackTile = GameBlockImages.TrackTiles.POND;
                } else if (character == 'D') {
                    trackTile = GameBlockImages.TrackTiles.BEND_RN;
                } else if (character == 'C') {
                    trackTile = GameBlockImages.TrackTiles.BEND_RS;
                } else if (character == 'd') {
                    trackTile = GameBlockImages.TrackTiles.BEND_LN;
                } else if (character == 'c') {
                    trackTile = GameBlockImages.TrackTiles.BEND_LS;
                } else if (character == 'B') {
                    trackTile = GameBlockImages.TrackTiles.BEND_LW;
                } else if (character == 'A') {
                    trackTile = GameBlockImages.TrackTiles.BEND_RW;
                } else if (character == 'b') {
                    trackTile = GameBlockImages.TrackTiles.BEND_RE;
                } else if (character == 'a') {
                    trackTile = GameBlockImages.TrackTiles.BEND_LE;
                } else if (character == 'V') {
                    trackTile = GameBlockImages.TrackTiles.DIAGONAL_SE;
                } else if (character == 'v') {
                    trackTile = GameBlockImages.TrackTiles.DIAGONAL_NW;
                } else if (character == 'u') {
                    trackTile = GameBlockImages.TrackTiles.DIAGONAL_SW;
                } else if (character == 'U') {
                    trackTile = GameBlockImages.TrackTiles.DIAGONAL_NE;
                } else if (character == 'M') {
                    trackTile = GameBlockImages.TrackTiles.CURVE_N;
                } else if (character == 'm') {
                    trackTile = GameBlockImages.TrackTiles.CURVE_S;
                } else if (character == 'w') {
                    trackTile = GameBlockImages.TrackTiles.CURVE_E;
                } else if (character == 'W') {
                    trackTile = GameBlockImages.TrackTiles.CURVE_W;
                } else {
                    throw new UnexpectedWorldTileException("The world contained an unknown tile!");
                }
                //GameBlockImages.TrackTiles trackTile = switch (character) {
                //    case 'G' -> GameBlockImages.TrackTiles.GRASS;
                //    case 'S' -> GameBlockImages.TrackTiles.START_FINISH;
                //    case '-' -> GameBlockImages.TrackTiles.HORIZONTAL;
                //    case 'N' -> GameBlockImages.TrackTiles.NECK;
                //    case '|' -> GameBlockImages.TrackTiles.VERTICAL;
                //    case 'X' -> GameBlockImages.TrackTiles.CROSSROAD;
                //    case 'R' -> GameBlockImages.TrackTiles.ROCKS_VERY_MANY;
                //    case 'r' -> GameBlockImages.TrackTiles.ROCKS_MANY;
                //    case 'Q' -> GameBlockImages.TrackTiles.ROCKS_NOT_SO_MANY;
                //    case 'q' -> GameBlockImages.TrackTiles.ROCKS_FEW;
                //    case 'H' -> GameBlockImages.TrackTiles.HOUSE_BIG;
                //    case 'h' -> GameBlockImages.TrackTiles.HOUSE_CORNER;
                //    case 'P' -> GameBlockImages.TrackTiles.POND;
                //    case 'A' -> GameBlockImages.TrackTiles.BEND_RN;
                //    case 'a' -> GameBlockImages.TrackTiles.BEND_RS;
                //    case 'B' -> GameBlockImages.TrackTiles.BEND_LN;
                //    case 'b' -> GameBlockImages.TrackTiles.BEND_LS;
                //    case 'C' -> GameBlockImages.TrackTiles.BEND_LW;
                //    case 'c' -> GameBlockImages.TrackTiles.BEND_RW;
                //    case 'D' -> GameBlockImages.TrackTiles.BEND_RE;
                //    case 'd' -> GameBlockImages.TrackTiles.BEND_LE;
                //    case 'U' -> GameBlockImages.TrackTiles.DIAGONAL_SE;
                //    case 'u' -> GameBlockImages.TrackTiles.DIAGONAL_NW;
                //    case 'V' -> GameBlockImages.TrackTiles.DIAGONAL_SW;
                //    case 'v' -> GameBlockImages.TrackTiles.DIAGONAL_NE;
                //    case 'W' -> GameBlockImages.TrackTiles.CURVE_N;
                //    case 'w' -> GameBlockImages.TrackTiles.CURVE_S;
                //    case 'M' -> GameBlockImages.TrackTiles.CURVE_E;
                //    case 'm' -> GameBlockImages.TrackTiles.CURVE_W;
                //    default -> throw new UnexpectedWorldTileException("The world contained an unknown tile!");
                //};
                TrackTile mapTrackTile = new TrackTile(gameView, this, trackTile);

                double tileWidthInPixels = GameBlockImages.BLOCK_SIZE * GameBlockImages.TrackTiles.TILE_WIDTH;
                double tileHeightInPixels = GameBlockImages.BLOCK_SIZE * GameBlockImages.TrackTiles.TILE_HEIGHT;

                double offsetXInPixels = tileOffsetColumnsInBlocks * GameBlockImages.BLOCK_SIZE;
                double offsetYInPixels = tileOffsetLinesInBlocks * GameBlockImages.BLOCK_SIZE;

                double x = (j - worldOffsetColumns) * tileWidthInPixels - offsetXInPixels;
                double y = (i - worldOffsetLines) * tileHeightInPixels - offsetYInPixels;

                mapTrackTile.getPosition().updateCoordinates(x, y);
                addActivatableGameObject(mapTrackTile);
                if (false) { // wichtel
                    spawnGameObject(mapTrackTile);
                }
            }
        }
    }

    @Override
    protected void gameLoop() {
        super.gameLoop();
        activateGameObjects();
    }

    private void activateGameObjects() {
        ListIterator<GameObject> iterator = activatableGameObjects.listIterator();
        while (iterator.hasNext()) {
            GameObject gameObject = iterator.next();
            if (gameObject instanceof TrackTile trackTile) {
                if (trackTile.tryToActivate(trackTile)) {
                    spawnGameObject(trackTile);
                    iterator.remove();
                }
            }
        }
    }
}
