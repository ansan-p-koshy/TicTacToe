package src.java.main.com.game.processor;

import src.java.main.com.game.component.GameBoard;
import src.java.main.com.game.constants.GameConstants;

import java.util.*;

import static src.java.main.com.game.constants.GameConstants.*;

public class GameProcessor {

    public static Set<Integer> playerPositions = new HashSet<>();
    public static Set<Integer> cpuPositions = new HashSet<>();

    public static void startGame() {
        String[][] board = {
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "}
        };
        GameBoard.printGameBoard(board);

        while(true) {
            processPlayerMove(board);
            if(checkResult().length() > 0) {
                if(playerPositions.size() + cpuPositions.size() == 9) {
                    GameBoard.printGameBoard(board);
                    System.out.println();
                }
                GameBoard.printGameBoard(board);
                System.out.println(checkResult());
                break;
            }

            processCPUMove(board);
            if(checkResult().length() > 0) {
                GameBoard.printGameBoard(board);
                System.out.println(checkResult());
                break;
            }

            GameBoard.printGameBoard(board);
        }
    }

    private static void processPlayerMove(String[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GameConstants.USER_INPUT_MESSAGE);
        int playerPos = scanner.nextInt();
        System.out.println();
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
            System.out.println("Position taken! Enter a correct position: ");
            playerPos = scanner.nextInt();
        }
        GameBoard.placePiece(board, playerPos, GameConstants.PLAYER);
    }

    private static void processCPUMove(String[][] board) {
        Random random = new Random();
        int cpuPos = random.nextInt(9) + 1;
        while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            cpuPos = random.nextInt(9) + 1;
        }
        GameBoard.placePiece(board, cpuPos, GameConstants.CPU);
    }

    private static String checkResult() {
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
