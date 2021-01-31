import logging.Logger;
import model.Game;
import view.frame.GameFrame;

public class BioWorld {
    public static void main(String[] args) {
        Logger.log("Welcome to BioWorld!");
        Game model = new Game();
        new GameFrame(model);
    }
}
