package thd.gameobjects.movable;

/**
 * The surface of the map, surface is determined by color, color is from color palette.
 */
enum MapSurface {
    WATER('A'),
    GRASS('D'),
    BRICK('E'),
    TRACK('F'),
    UNDEFINED(' ');
    private final char color;

    MapSurface(char color) {
        this.color = color;
    }
}
