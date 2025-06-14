package thd.game.level;

import java.awt.*;

public enum ColorPalette {
    DEFAULT(new Color(44, 61, 236),
            new Color(98, 213, 50),
            new Color(175, 60, 88),
            new Color(205, 205, 205),
            new Color(238, 123, 149),
            new Color(255, 255, 70)),

    WET(new Color(44, 61, 236),
        new Color(0, 153, 51),
        new Color(175, 60, 88),
        new Color(128, 149, 154),
        new Color(238, 123, 149),
        new Color(255, 255, 70)),

    ICY(new Color(142, 208, 255),
        new Color(136, 220, 170),
        new Color(234, 130, 148),
        new Color(190, 224, 220),
        new Color(238, 123, 149),
        new Color(255, 255, 70)),

    DESERT(
            new Color(204, 153, 51),
            new Color(255, 204, 102),
            new Color(255, 90, 60),
            new Color(218, 210, 179),
            new Color(238, 123, 149),
            new Color(255, 255, 70));

    private final Color[] colors;

    ColorPalette(Color... colors) {
        this.colors = colors;
    }

    public Color getColor(int index) {
        if (index < 0 || index >= colors.length) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (colors.length - 1));
        }
        return colors[index];
    }
}
