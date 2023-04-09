package com.game.processor;

import com.game.component.GameBoard;

import java.util.*;

import static com.game.constants.GameConstants.*;

public class GameProcessor {

    public static Set<Integer> playerPositions = new HashSet<>();
    public static Set<Integer> cpuPositions = new HashSet<>();

    private final GameBoard gameBoard;

    public GameProcessor(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void startGame() {
        String[][] board = {
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "}
        };
        gameBoard.printGameBoard(board);

        while(true) {
            processPlayerMove(board);
            if(checkResult().length() > 0) {
                if(playerPositions.size() + cpuPositions.size() == 9) {
                    gameBoard.printGameBoard(board);
                    System.out.println();
                }
                gameBoard.printGameBoard(board);
                System.out.println(checkResult());
                break;
            }

            processCPUMove(board);
            if(checkResult().length() > 0) {
                gameBoard.printGameBoard(board);
                System.out.println(checkResult());
                break;
            }

            gameBoard.printGameBoard(board);
        }
    }

    private void processPlayerMove(String[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(USER_INPUT_MESSAGE);
        int playerPos = scanner.nextInt();
        System.out.println();
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
            System.out.println("Position taken! Enter a correct position: ");
            playerPos = scanner.nextInt();
        }
        gameBoard.placePiece(board, playerPos, PLAYER);
    }

    private void processCPUMove(String[][] board) {
        Random random = new Random();
        int cpuPos = random.nextInt(9) + 1;
        while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            cpuPos = random.nextInt(9) + 1;
        }
        gameBoard.placePiece(board, cpuPos, CPU);
    }

    private String checkResult() {
        for(List<Integer> winningList : WINNING_CONDITIONS_LIST) {
            if(playerPositions.containsAll(winningList)) {
                return WINNING_MESSAGE;
            } else if (cpuPositions.containsAll(winningList)) {
                return LOOSING_MESSAGE;
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return TIE_MESSAGE;
            }
        }
        return "";
    }
}
