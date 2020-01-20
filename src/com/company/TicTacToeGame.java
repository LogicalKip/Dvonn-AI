package com.company;

public class TicTacToeGame extends MonteCarloGame {

    String currentBoard;

    private static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
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

    @Override
    public void setupBoard() {
        currentBoard = "_".repeat(9);
        this.player = Player.MAIN_PLAYER;
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

    public String displayBoard() {
        return currentBoard.substring(0, 3) + "\n" + currentBoard.substring(3, 6) + "\n" + currentBoard.substring(6, 9);
    }
}
