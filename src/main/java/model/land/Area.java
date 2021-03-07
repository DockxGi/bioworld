package model.land;

import model.land.tile.Tile;

/**
 * The square grid of all {@link Tile} objects that the user can see at a given moment.
 */
public class Area {
    public static final int SIZE = 9;
    private Tile[][] tiles;

    public Area() {
        tiles = new Tile[SIZE][SIZE];
    }

    public void setTile(Tile tile, int x, int y){
        tiles[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void fillWithEmptyTiles() {
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++){
                tiles [x][y] = new Tile(null);
            }
        }
    }
}
