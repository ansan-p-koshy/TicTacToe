package com.game;

import com.game.constants.GameConstants;
import com.game.processor.GameProcessor;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println(GameConstants.WELCOME_MESSAGE);
        GameProcessor.startGame();
    }
}
