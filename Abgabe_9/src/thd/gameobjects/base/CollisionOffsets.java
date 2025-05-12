package thd.gameobjects.base;

/**
 * A simple class to store the offsets for hitboxes.
 */
public class CollisionOffsets {

    private final double hitBoxOffsetX;
    private final double hitBoxOffsetY;
    private final double hitBoxOffsetWidth;
    private final double hitBoxOffsetHeight;

    /**
     * Creates a new offset for the hitbox, relatively to the position and size of the game object.
     *
     * @param offsetX      x-coordinate, relative to the game objects' x-coordinate.
     * @param offsetY      y-coordinate, relative to the game objects' y-coordinate.
     * @param offsetWidth  Width, relative to the game objects' width.
     * @param offsetHeight Height, relative to the game objects' height.
     */
    CollisionOffsets(double offsetX, double offsetY, double offsetWidth, double offsetHeight) {
        this.hitBoxOffsetX = offsetX;
        this.hitBoxOffsetY = offsetY;
        this.hitBoxOffsetWidth = offsetWidth;
        this.hitBoxOffsetHeight = offsetHeight;
    }

    ///**
    // * Returns the x offset.
    // *
    // * @return the offset in x.
    // */
    //private double getHitBoxOffsetX() {
    //    return hitBoxOffsetX;
    //}
    //
    ///**
    // * Returns the y offset.
    // *
    // * @return the offset in y.
    // */
    //private double getHitBoxOffsetY() {
    //    return hitBoxOffsetY;
    //}
    //
    ///**
    // * Returns the width offset.
    // *
    // * @return the offset in width.
    // */
    //private double getHitBoxOffsetWidth() {
    //    return hitBoxOffsetWidth;
    //}
    //
    ///**
    // * Returns the height offset.
    // *
    // * @return the offset in height.
    // */
    //private double getHitBoxOffsetHeight() {
    //    return hitBoxOffsetHeight;
    //}
}
