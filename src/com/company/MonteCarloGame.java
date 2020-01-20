package com.company;

enum Player {
    MAIN_PLAYER,
    OTHER_PLAYER,
    NO_ONE
}

public abstract class MonteCarloGame {

    protected Player player = Player.MAIN_PLAYER;

    void nextPlayer() {
        if (player.equals(Player.MAIN_PLAYER)) {
            player = Player.OTHER_PLAYER;
        } else {
            player = Player.MAIN_PLAYER;
        }
    }

    abstract void playMove(int moveNb);

    abstract int getCurrentNbMoves();

    abstract void setupBoard();

    abstract boolean gameOver();

    abstract Player playerWinning();

    public void setPlayer(Player player) {
        this.player = player;
    }


}
