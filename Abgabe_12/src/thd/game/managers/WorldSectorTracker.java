package thd.game.managers;

import java.util.HashSet;
import java.util.Set;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.MapTile;

/**
 * Tracks which sectors of the world the car has visited to prevent backwards
 * lap completion.
 * Divides the map into 4 sectors and requires the car to visit all sectors
 * before allowing lap completion.
 */
public class WorldSectorTracker {
    private static final double FINISH_LINE_THRESHOLD = 50.0; // Distance threshold for finish line detection

    private final Set<Integer> visitedSectors;
    private double worldMinX, worldMaxX, worldMinY, worldMaxY;
    private boolean worldBoundsCalculated;
    private double virtualCarX, virtualCarY; // Track car's virtual position in world coordinates

    /**
     * Creates a new WorldSectorTracker.
     */
    public WorldSectorTracker() {
        this.visitedSectors = new HashSet<>();
        this.worldBoundsCalculated = false;
        this.virtualCarX = 0;
        this.virtualCarY = 0;
    }

    /**
     * Updates the virtual car position when the world moves.
     * Since the car stays centered and world moves around it, we track the inverse
     * movement.
     * 
     * @param worldDeltaX How much the world moved horizontally
     * @param worldDeltaY How much the world moved vertically
     */
    public void updateVirtualCarPosition(double worldDeltaX, double worldDeltaY) {
        // Invert the world movement to get virtual car movement
        virtualCarX -= worldDeltaX;
        virtualCarY -= worldDeltaY;

        if (worldBoundsCalculated) {
            updateCurrentSector();
        }
    }

    /**
     * Calculates world bounds from the given map tile and updates if needed.
     * 
     * @param mapTile The map tile to consider for world bounds
     */
    public void updateWorldBounds(MapTile mapTile) {
        double tileX = mapTile.getPosition().getX();
        double tileY = mapTile.getPosition().getY();
        double tileWidth = GamePlayManager.MAP_TILE_WIDTH * GamePlayManager.BLOCK_SIZE;
        double tileHeight = GamePlayManager.MAP_TILE_HEIGHT * GamePlayManager.BLOCK_SIZE;

        if (!worldBoundsCalculated) {
            worldMinX = tileX;
            worldMaxX = tileX + tileWidth;
            worldMinY = tileY;
            worldMaxY = tileY + tileHeight;
            worldBoundsCalculated = true;
        } else {
            worldMinX = Math.min(worldMinX, tileX);
            worldMaxX = Math.max(worldMaxX, tileX + tileWidth);
            worldMinY = Math.min(worldMinY, tileY);
            worldMaxY = Math.max(worldMaxY, tileY + tileHeight);
        }

        updateCurrentSector();
    }

    /**
     * Updates the current sector based on virtual car position.
     */
    private void updateCurrentSector() {
        if (!worldBoundsCalculated) {
            return;
        }

        double worldWidth = worldMaxX - worldMinX;
        double worldHeight = worldMaxY - worldMinY;
        double sectorWidth = worldWidth / 2.0;
        double sectorHeight = worldHeight / 2.0;

        // Determine which sector the virtual car is currently in
        boolean inRightHalf = (virtualCarX - worldMinX) > sectorWidth;
        boolean inBottomHalf = (virtualCarY - worldMinY) > sectorHeight;

        int currentSector;
        if (!inRightHalf && !inBottomHalf) {
            currentSector = 1; // Top-Left
        } else if (inRightHalf && !inBottomHalf) {
            currentSector = 2; // Top-Right (where start/finish typically is)
        } else if (!inRightHalf && inBottomHalf) {
            currentSector = 3; // Bottom-Left
        } else {
            currentSector = 4; // Bottom-Right
        }

        visitedSectors.add(currentSector);
    }

    /**
     * Checks if all 4 sectors have been visited.
     * 
     * @return true if all sectors have been visited, false otherwise
     */
    public boolean allSectorsVisited() {
        return visitedSectors.size() >= 4;
    }

    /**
     * Resets the sector tracking for a new lap.
     */
    public void resetForNewLap() {
        visitedSectors.clear();
        // Keep the current sector as visited for the new lap
        updateCurrentSector();
    }

    /**
     * Checks if the car is close enough to the finish line tile to count as
     * crossing it.
     * 
     * @param finishLineTile The finish line map tile
     * @return true if the car is close enough to the finish line
     */
    public boolean isCarAtFinishLine(MapTile finishLineTile) {
        double carCenterX = GameView.WIDTH / 2.0;
        double carCenterY = GameView.HEIGHT / 2.0;

        double tileCenterX = finishLineTile.getPosition().getX() +
                (GamePlayManager.MAP_TILE_WIDTH * GamePlayManager.BLOCK_SIZE) / 2.0;
        double tileCenterY = finishLineTile.getPosition().getY() +
                (GamePlayManager.MAP_TILE_HEIGHT * GamePlayManager.BLOCK_SIZE) / 2.0;

        double distance = Math.sqrt(Math.pow(carCenterX - tileCenterX, 2) +
                Math.pow(carCenterY - tileCenterY, 2));

        System.out.println("[DEBUG WorldSectorTracker] Car center: (" + carCenterX + ", " + carCenterY + ")");
        System.out.println("[DEBUG WorldSectorTracker] Tile center: (" + tileCenterX + ", " + tileCenterY + ")");
        System.out
                .println("[DEBUG WorldSectorTracker] Distance: " + distance + ", Threshold: " + FINISH_LINE_THRESHOLD);

        boolean atFinishLine = distance < FINISH_LINE_THRESHOLD;
        System.out.println("[DEBUG WorldSectorTracker] Is at finish line: " + atFinishLine);

        return atFinishLine;
    }

    /**
     * Gets the number of sectors visited so far.
     * 
     * @return Number of sectors visited
     */
    public int getSectorsVisitedCount() {
        return visitedSectors.size();
    }

    /**
     * Gets a copy of the visited sectors set for debugging.
     * 
     * @return Set of visited sector numbers
     */
    public Set<Integer> getVisitedSectors() {
        return new HashSet<>(visitedSectors);
    }

    /**
     * Sets the initial virtual car position (usually at start/finish line).
     * 
     * @param startX Initial X coordinate in world space
     * @param startY Initial Y coordinate in world space
     */
    public void setInitialPosition(double startX, double startY) {
        this.virtualCarX = startX;
        this.virtualCarY = startY;
        updateCurrentSector();
    }
}
