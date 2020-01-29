package com.company;

import java.util.Scanner;

public class TicTacToeGame extends MonteCarloGame {

//    String realCurrentBoard;

    String currentBoard;

    public TicTacToeGame() {
        super();
    }

    @Override
    public MonteCarloGame deepCopy() {
        TicTacToeGame copy = new TicTacToeGame();

        copy.player = this.player;
        copy.currentBoard = this.currentBoard;

        return copy;
    }

    private static int ordinalIndexOf(String str, String substring, int n) {
        int pos = str.indexOf(substring);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substring, pos + 1);
        return pos;
    }

    @Override
    public void playMove(int moveNb) {
        StringBuilder builder = new StringBuilder(currentBoard);
        builder.setCharAt(ordinalIndexOf(currentBoard, "_", moveNb + 1), player.equals(Player.MAIN_PLAYER) ? 'X' : 'O');
        currentBoard = builder.toString();
    }

    @Override
    public int getCurrentNbMoves() {
        return ((int) currentBoard.chars().filter(c -> c == '_').count());
    }
//
//    @Override
//    public void resetBoardToCurrentState() {
//        this.currentBoard = realCurrentBoard;
//    }

    @Override
    public void initialSetup() {
        this.currentBoard = "_".repeat(9);
//        this.realCurrentBoard = this.currentBoard;
        this.player = Player.MAIN_PLAYER;
//        this.realCurrentPlayer = this.player;
    }

    @Override
    public void moveOtherPlayer() {
        System.out.println("What did the other move ?");
        int move = new Scanner(System.in).nextInt();
        this.playMove(move);
    }

    @Override
    public boolean gameOver() {
        return playerWinning() != Player.NO_ONE || !currentBoard.contains("_");
    }

    @Override
    public Player playerWinning() {
        if (wins("X")) {
            return Player.MAIN_PLAYER;
        } else if (wins("O")) {
            return Player.OTHER_PLAYER;
        }
        return Player.NO_ONE;
    }

    @Override
    public void tellWhichMoveIsBest(int move) {
        System.out.println("Choose move n°" + move);
    }

    private boolean wins(String c) {
        return currentBoard.matches("X..X..X..".replace("X", c)) ||
                currentBoard.matches(".X..X..X.".replace("X", c)) ||
                currentBoard.matches("..X..X..X".replace("X", c)) ||
                currentBoard.matches("XXX......".replace("X", c)) ||
                currentBoard.matches("...XXX...".replace("X", c)) ||
                currentBoard.matches("......XXX".replace("X", c)) ||
                currentBoard.matches("X...X...X".replace("X", c)) ||
                currentBoard.matches("..X.X.X..".replace("X", c));
    }

    public void displayBoard() {
        System.out.println(currentBoard.substring(0, 3) + "\n" + currentBoard.substring(3, 6) + "\n" + currentBoard.substring(6, 9));
    }
}
