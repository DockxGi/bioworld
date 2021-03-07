package view.dialog.mapEditor.groundSelection;

import model.land.tile.Ground;
import view.assets.images.GroundImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GroundButton extends JButton {
    private Ground ground;
    private GroundSelectionPanel selectionPanel;

    public GroundButton(Ground ground, GroundSelectionPanel selectionPanel) {
        this.ground = ground;
        this.selectionPanel = selectionPanel;
        addListener();
    }

    private void addListener() {
        this.addActionListener(e -> selectionPanel.setSelected(GroundButton.this.ground));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage image = GroundImages.imageOf(ground);
        if (image != null){
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            paintNoGround(g);
        }
    }

    private void paintNoGround(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.white);
        g.drawLine(0,0, this.getWidth(), this.getHeight());
    }
}
