package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.MapTile;

import java.util.HashSet;
import java.util.Set;

/**
 * Tracks which sectors of the world the car has visited to prevent backwards lap completion. Divides the map into 4
 * sectors and requires the car to visit all sectors before allowing lap completion.
 */
public class WorldSectorTracker {
    private static final double FINISH_LINE_THRESHOLD = 100.0; // Distance threshold for finish line detection

    private final Set<Integer> visitedSectors;
    private double worldMinX;
    private double worldMaxX;
    private double worldMinY;
    private double worldMaxY;
    private boolean worldBoundsCalculated;
    private double virtualCarX;
    private double virtualCarY;

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
     * Updates the virtual car position when the world moves. Since the car stays centered and world moves around it, we
     * track the inverse movement.
     *
     * @param worldDeltaX How much the world moved horizontally
     * @param worldDeltaY How much the world moved vertically
     */
    void updateVirtualCarPosition(double worldDeltaX, double worldDeltaY) {
        virtualCarX -= worldDeltaX;
        virtualCarY -= worldDeltaY;

        if (worldBoundsCalculated) {
            updateCurrentSector();
        }
    }

    /**
     * Sets the world bounds to calculate sectors correctly.
     *
     * @param minX Minimum X coordinate of the world
     * @param maxX Maximum X coordinate of the world
     * @param minY Minimum Y coordinate of the world
     * @param maxY Maximum Y coordinate of the world
     */
    private void updateWorldBounds(double minX, double maxX, double minY, double maxY) {
        this.worldMinX = minX;
        this.worldMaxX = maxX;
        this.worldMinY = minY;
        this.worldMaxY = maxY;
        this.worldBoundsCalculated = true;

        // Reset visited sectors when world bounds are updated
        visitedSectors.clear();
        updateCurrentSector();
    }

    /**
     * Initializes the sector tracker for a new level. This should be called when switching levels to reset the virtual
     * car position and clear visited sectors.
     *
     * @param minX   Minimum X coordinate of the world
     * @param maxX   Maximum X coordinate of the world
     * @param minY   Minimum Y coordinate of the world
     * @param maxY   Maximum Y coordinate of the world
     * @param startX Starting X position of the car in world coordinates
     * @param startY Starting Y position of the car in world coordinates
     */
    void initializeForNewLevel(double minX, double maxX, double minY, double maxY, double startX,
                               double startY) {
        // Reset virtual car position to starting position
        this.virtualCarX = startX;
        this.virtualCarY = startY;

        // Update world bounds
        updateWorldBounds(minX, maxX, minY, maxY);
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

        boolean inRightHalf = (virtualCarX - worldMinX) > sectorWidth;
        boolean inBottomHalf = (virtualCarY - worldMinY) > sectorHeight;

        int currentSector;
        if (!inRightHalf && !inBottomHalf) {
            currentSector = 1; // Top-Left
        } else if (inRightHalf && !inBottomHalf) {
            currentSector = 2; // Top-Right
        } else if (!inRightHalf && inBottomHalf) {
            currentSector = 4; // Bottom-Left
        } else {
            currentSector = 3; // Bottom-Right
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
     * Resets the sector tracking for a new lap. This clears the visited sectors and updates the current sector.
     */
    void resetForNewLap() {
        visitedSectors.clear();
        updateCurrentSector();
    }

    /**
     * Checks if the car is close enough to the finish line tile to count as crossing it.
     *
     * @param finishLineTile The finish line map tile
     * @return true if the car is close enough to the finish line
     */
    public boolean isCarAtFinishLine(MapTile finishLineTile) {
        double carCenterX = GameView.WIDTH / 2.0;
        double carCenterY = GameView.HEIGHT / 2.0;

        double tileCenterX = finishLineTile.getPosition().getX()
                             + (GamePlayManager.MAP_TILE_WIDTH * GamePlayManager.BLOCK_SIZE) / 2.0;
        double tileCenterY = finishLineTile.getPosition().getY()
                             + (GamePlayManager.MAP_TILE_HEIGHT * GamePlayManager.BLOCK_SIZE) / 2.0;

        // Calculate distance in both X and Y directions for more accurate detection
        double distanceX = Math.abs(carCenterX - tileCenterX);
        double distanceY = Math.abs(carCenterY - tileCenterY);

        // Use a smaller threshold and check both axes
        return distanceX < FINISH_LINE_THRESHOLD && distanceY < FINISH_LINE_THRESHOLD;
    }

    /**
     * Gets the visited sectors for debugging purposes.
     *
     * @return A defensive copy of the visited sectors set
     */
    public java.util.Set<Integer> getVisitedSectors() {
        return new java.util.HashSet<>(visitedSectors);
    }

    /**
     * Gets the current sector the car is in for debugging purposes.
     *
     * @return The current sector number (1-4), or 0 if not calculated yet
     */
    public int currentSector() {
        if (!worldBoundsCalculated) {
            return 0;
        }

        double worldWidth = worldMaxX - worldMinX;
        double worldHeight = worldMaxY - worldMinY;
        double sectorWidth = worldWidth / 2.0;
        double sectorHeight = worldHeight / 2.0;

        boolean inRightHalf = (virtualCarX - worldMinX) > sectorWidth;
        boolean inBottomHalf = (virtualCarY - worldMinY) > sectorHeight;

        if (!inRightHalf && !inBottomHalf) {
            return 1; // Top-Left
        } else if (inRightHalf && !inBottomHalf) {
            return 2; // Top-Right
        } else if (!inRightHalf && inBottomHalf) {
            return 4; // Bottom-Left
        } else {
            return 3; // Bottom-Right
        }
    }
}
