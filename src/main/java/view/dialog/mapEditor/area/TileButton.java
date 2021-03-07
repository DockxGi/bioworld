package view.dialog.mapEditor.area;

import model.land.tile.Ground;
import model.land.tile.Tile;
import view.assets.images.GroundImages;
import view.dialog.mapEditor.groundSelection.selected.SelectsGround;
import view.graphics.GroundPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class TileButton extends JButton {
    private Tile tile;

    private SelectsGround groundSelector;

    public TileButton(Tile tile, SelectsGround groundSelector) {
        this.tile = tile;
        this.groundSelector = groundSelector;

        addListeners(groundSelector);
    }

    private void addListeners(SelectsGround groundSelector) {
        this.addActionListener(e -> {
            Ground selectedGround = groundSelector.getSelectedGround();

            this.tile.setGround(selectedGround);
            this.repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Ground ground = tile != null ? tile.getGround() : null;
        GroundPainter.paint(g, ground, this);
    }
}
