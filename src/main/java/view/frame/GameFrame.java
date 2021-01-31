package view.frame;

import model.Game;

import javax.swing.*;
import java.awt.*;

/**
 * The main window of the game.
 */
public class GameFrame extends JFrame {

    private Game model;
    private GameMenuBar menuBar;

    public GameFrame(Game model) throws HeadlessException {
        this.model = model;

        this.menuBar = new GameMenuBar(model);
        this.add(menuBar, BorderLayout.NORTH);

        this.setTitle("Bio-World");
        this.setSize(700,500);
        locationToCenter();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void locationToCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
