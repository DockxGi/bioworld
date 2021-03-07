package model.land.tile;

/**
 * A Tile of the map.
 */
public class Tile {
    private Ground ground;

    public Tile(Ground ground) {
        this.ground = ground;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }
}
