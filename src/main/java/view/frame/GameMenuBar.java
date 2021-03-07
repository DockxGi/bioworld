package view.frame;

import model.Game;
import view.dialog.game.NewGameDialog;
import view.dialog.mapEditor.MapEditorDialog;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {
    private Game model;

    private JMenu gameMenu;
    private JMenuItem newGameMenuItem;
    private JMenuItem loadGameMenuItem;
    private JMenuItem saveGameMenuItem;

    private JMenu devToolsMenu;
    private JMenuItem mapEditorMenu;

    public GameMenuBar(Game model) {
        this.model = model;

        createGameMenu();
        createLayout();
        addListeners();
    }

    private void addListeners() {
        this.newGameMenuItem.addActionListener(e -> {
            new NewGameDialog(GameMenuBar.this.model);
        });

        this.mapEditorMenu.addActionListener(e -> {
            new MapEditorDialog();
        });
    }

    private void createGameMenu() {
        gameMenu = new JMenu("Game");
        newGameMenuItem = new JMenuItem("New...");
        loadGameMenuItem = new JMenuItem("Load...");
        saveGameMenuItem = new JMenuItem("Save...");

        devToolsMenu = new JMenu("DevTools");
        mapEditorMenu = new JMenuItem("Map Editor...");
    }

    private void createLayout() {
        gameMenu.add(newGameMenuItem);
        gameMenu.add(loadGameMenuItem);
        gameMenu.add(saveGameMenuItem);

        devToolsMenu.add(mapEditorMenu);

        this.add(gameMenu);
        this.add(devToolsMenu);
    }
}
