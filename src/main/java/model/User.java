package model;

/**
 * A user that can play the game.
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
