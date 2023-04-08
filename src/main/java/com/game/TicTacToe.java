package src.java.main.com.game;

import src.java.main.com.game.constants.GameConstants;
import src.java.main.com.game.processor.GameProcessor;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println(GameConstants.WELCOME_MESSAGE);
        GameProcessor.startGame();
    }
}
