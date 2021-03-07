package view.dialog.mapEditor.groundSelection.selected;

import model.land.tile.Ground;
import view.assets.descriptions.GroundDescriptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class SelectedGroundPanel extends JPanel {
    private Ground ground;

    private GroundPanel groundPanel;
    private JButton infoButton;

    public SelectedGroundPanel() {
        createComponents();
        createLayout();
        addListeners();
    }

    private void addListeners() {
        infoButton.addActionListener(e -> {
            Ground ground = SelectedGroundPanel.this.ground;
            if (ground != null){
                String description = GroundDescriptions.getDescriptionOf(ground);
                String title = this.ground.name().toLowerCase() + " description";
                JOptionPane.showMessageDialog(SelectedGroundPanel.this, description, title, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private void createLayout() {
        this.setLayout(new GridLayout(1,2));
        this.add(groundPanel);
        this.add(infoButton);
    }

    private void createComponents() {
        groundPanel = new GroundPanel();
        infoButton = new JButton("info");
    }

    public void setGround(Ground ground){
        this.ground = ground;
        this.groundPanel.setGround(ground);
    }

    public Ground getSelectedGround() {
        return ground;
    }
}
