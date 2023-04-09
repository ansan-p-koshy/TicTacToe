package com.game;

import com.game.component.GameBoard;
import com.game.processor.GameProcessor;

import static com.game.constants.GameConstants.WELCOME_MESSAGE;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        GameProcessor gameProcessor = new GameProcessor(new GameBoard());
        gameProcessor.startGame();
    }
}
