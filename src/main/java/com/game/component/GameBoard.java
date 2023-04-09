package com.game.component;

import com.game.constants.GameConstants;
import com.game.processor.GameProcessor;

public class GameBoard {

    public void printGameBoard(String[][] gameBoard) {
        for(String[] row : gameBoard) {
            for(String ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public void placePiece(String[][] gameBoard, Integer position, String user) {
        String symbol = "   ";

        if(user.equals(GameConstants.PLAYER)) {
            symbol = GameConstants.X;
            GameProcessor.playerPositions.add(position);
        } else if (user.equals(GameConstants.CPU)) {
            symbol = GameConstants.O;
            GameProcessor.cpuPositions.add(position);
        }

        switch (position) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }
    }
}
