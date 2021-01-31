package model.land.tile;

/**
 * The ground at a {@link Tile}. Can be identified via one character.
 */
public enum Ground {
    DIRT('d', true),
    GRASS('g', true),
    MOUNTAIN('m', false)
    ;

    private char id;
    private boolean canBeMovedOver;

    Ground(char id, boolean canBeMovedOver) {
        this.id = id;
        this.canBeMovedOver = canBeMovedOver;
    }
}
