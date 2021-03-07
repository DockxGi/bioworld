package view.graphics;

import model.land.tile.Ground;
import view.assets.images.GroundImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GroundPainter {
    public static void paint(Graphics g, Ground ground, JComponent c){
        if (ground != null){
            BufferedImage image = GroundImages.imageOf(ground);
            g.drawImage(image, 0,0, c.getWidth(), c.getHeight(), c);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
            g.setColor(Color.white);
            g.drawLine(0,0, c.getWidth(), c.getHeight());
        }
    }
}
