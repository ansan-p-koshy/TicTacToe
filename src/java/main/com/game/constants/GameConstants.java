package src.java.main.com.game.constants;

import java.util.List;

public class GameConstants {

    public static final String WELCOME_MESSAGE = "Welcome to my TicTacToe!!";
    public static final String USER_INPUT_MESSAGE = "Enter your placement (1-9): ";
    public static final String PLAYER = "player";
    public static final String CPU = "cpu";
    public static final String X = " X ";
    public static final String O = " 0 ";
    public static final String WINNING_MESSAGE = "Congratulations!! You WON!";
    public static final String LOOSING_MESSAGE = "CPU Wins!! Sorry, Try Again! :(";
    public static final String TIE_MESSAGE = "It's a TIE!!";

    public static final List<Integer> TOP_ROW = List.of(1, 2, 3);
    public static final List<Integer> MID_ROW = List.of(4, 5, 6);
    public static final List<Integer> BOTTOM_ROW = List.of(7, 8, 9);
    public static final List<Integer> LEFT_COL = List.of(1, 4, 7);
    public static final List<Integer> MID_COL = List.of(2, 5, 8);
    public static final List<Integer> RIGHT_COL = List.of(3, 6, 9);
    public static final List<Integer> LEFT_DIAGONAL = List.of(1, 5, 9);
    public static final List<Integer> RIGHT_DIAGONAL = List.of(3, 5, 7);

    public static final List<List<Integer>> WINNING_CONDITIONS_LIST = List.of(TOP_ROW, MID_ROW, BOTTOM_ROW,
            LEFT_COL, MID_COL, RIGHT_COL, LEFT_DIAGONAL, RIGHT_DIAGONAL);
}
