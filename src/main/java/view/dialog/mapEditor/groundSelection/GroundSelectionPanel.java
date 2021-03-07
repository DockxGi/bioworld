package view.dialog.mapEditor.groundSelection;

import model.land.tile.Ground;
import view.dialog.mapEditor.groundSelection.selected.SelectedGroundPanel;
import view.dialog.mapEditor.groundSelection.selected.SelectsGround;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroundSelectionPanel extends JPanel implements SelectsGround {
    private Ground selected;

    private List<GroundButton> groundButtons;
    private JPanel groundButtonsPanel;
    private SelectedGroundPanel selectedGroundPanel;

    public GroundSelectionPanel() {
        selected = null;

        createComponents();
        createLayout();
    }

    private void createLayout() {
        this.setLayout(new BorderLayout());
        groundButtonsPanel.setLayout(new GridLayout(10,5));
        for (GroundButton groundButton : groundButtons) {
            groundButtonsPanel.add(groundButton);
        }
        this.add(groundButtonsPanel, BorderLayout.CENTER);
        this.add(selectedGroundPanel, BorderLayout.NORTH);
    }

    private void createComponents() {
        createGroundButtons();
        groundButtonsPanel = new JPanel();
        selectedGroundPanel = new SelectedGroundPanel();
    }

    private void createGroundButtons() {
        groundButtons = new ArrayList<>();
        for (Ground ground : Ground.values()) {
            groundButtons.add(new GroundButton(ground, this));
        }
    }

    public void setSelected(Ground ground) {
        this.selected = ground;
        this.selectedGroundPanel.setGround(ground);
    }

    @Override
    public Ground getSelectedGround() {
        return selectedGroundPanel.getSelectedGround();
    }
}
