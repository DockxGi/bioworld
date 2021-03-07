package view.dialog.mapEditor;

import model.land.WorldMap;
import view.assets.descriptions.GroundDescriptions;
import view.dialog.mapEditor.area.AreaPanel;
import view.dialog.mapEditor.groundSelection.GroundSelectionPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog for editing a {@link WorldMap}.
 */
public class MapEditorDialog extends JDialog {

    private WorldMap map;

    private AreaPanel areaPanel;
    private GroundSelectionPanel groundSelectionPanel;

    public MapEditorDialog() {
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        this.setLayout(new BorderLayout());
        groundSelectionPanel = new GroundSelectionPanel();
        areaPanel = new AreaPanel(groundSelectionPanel);

        this.setLayout(new BorderLayout());
        this.add(groundSelectionPanel, BorderLayout.EAST);
        this.add(areaPanel, BorderLayout.CENTER);

        this.setTitle("Map Editor");
        this.setSize(700,500);
        locationToCenter();
        this.setVisible(true);
    }

    private void locationToCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
