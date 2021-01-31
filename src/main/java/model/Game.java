package model;

import logging.Logger;

public class Game {
    private GameState state;
    private User user;

    public void createNewGame(String username){
        this.user = new User(username);
        this.state = GameState.BUSY;
        Logger.log("Created new game for: " + username);
    }
}
