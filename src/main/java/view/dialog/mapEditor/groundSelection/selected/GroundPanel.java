package view.dialog.mapEditor.groundSelection.selected;

import model.land.tile.Ground;
import view.assets.images.GroundImages;
import view.graphics.GroundPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Panel to show image of ground.
 */
public class GroundPanel extends JPanel {
    private Ground ground;

    public GroundPanel() {
    }

    public void setGround(Ground ground){
        this.ground = ground;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GroundPainter.paint(g, ground, this);
    }
}
