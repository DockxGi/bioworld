package view.dialog.mapEditor.area;

import model.land.Area;
import model.land.tile.Ground;
import model.land.tile.Tile;
import view.dialog.mapEditor.groundSelection.selected.SelectsGround;

import javax.swing.*;
import java.awt.*;

public class AreaPanel extends JPanel {
    public static final Ground DEFAULT_GROUND = null;

    private Area area;
    private TileButton[][] tiles;

    public AreaPanel(SelectsGround groundSelector) {
        setupEmptyArea(groundSelector);

        createLayout();
    }

    private void createLayout() {
        this.setLayout(new GridLayout(Area.SIZE, Area.SIZE,1,1));
        for (int y = 0; y < Area.SIZE; y++) {
            for (int x = 0; x < Area.SIZE; x++) {
                this.add(tiles[x][y]);
            }
        }
    }

    private void setupEmptyArea(SelectsGround groundSelector) {
        area = new Area();
        area.fillWithEmptyTiles();

        tiles = new TileButton[Area.SIZE][Area.SIZE];
        for (int x = 0; x < Area.SIZE; x++) {
            for (int y = 0; y < Area.SIZE; y++) {
                tiles[x][y] = new TileButton(area.getTile(x, y), groundSelector);
            }
        }
    }
}
