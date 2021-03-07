package view.dialog.game;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewGameDialog extends JDialog {
    private Game model;

    private JPanel topPanel;
    private JPanel bottomPanel;

    private JLabel nameLabel;
    private JTextField nameField;
    private JButton okButton;
    private JButton cancelButton;

    public NewGameDialog(Game model) {
        this.model = model;
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        createComponents();
        createLayout();

        this.setTitle("New Game");

        addListeners();

        locationToCenter();
        this.setVisible(true);
    }

    private void addListeners() {
        disableOkButtonWhenFormInvalid();
        cancelButton.addActionListener(e -> NewGameDialog.this.dispose());
        okButton.addActionListener(e -> {
            NewGameDialog.this.model.createNewGame(NewGameDialog.this.nameField.getText().trim());
            NewGameDialog.this.dispose();
        });
    }

    private void disableOkButtonWhenFormInvalid() {
        this.nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (NewGameDialog.this.nameField.getText().trim().length() > 1){
                    NewGameDialog.this.okButton.setEnabled(true);
                } else {
                    NewGameDialog.this.okButton.setEnabled(false);
                }
            }
        });
    }

    private void createLayout() {
        this.setLayout(new GridLayout(2,1));
        this.add(topPanel);
        this.add(bottomPanel);

        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(nameLabel);
        topPanel.add(nameField);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(cancelButton);
        bottomPanel.add(okButton);

        this.pack();
        this.setResizable(false);
    }

    private void createComponents() {
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        nameLabel = new JLabel("Name:");
        nameField = new JTextField(40);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        okButton.setEnabled(false);
    }

    private void locationToCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
