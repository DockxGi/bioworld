package model.land;

import java.util.ArrayList;
import java.util.List;

/**
 * All {@link Area} of the game together form the Map.
 */
public class WorldMap {
    private List<Area> areas;

    public WorldMap() {
        areas = new ArrayList<>();
    }
}
