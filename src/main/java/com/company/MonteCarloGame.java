package com.company;

enum Player {
    MAIN_PLAYER,
    OTHER_PLAYER,
    NO_ONE
}

public abstract class MonteCarloGame {

    protected Player player = Player.MAIN_PLAYER;

    public MonteCarloGame() {

    }
//
//    protected Player realCurrentPlayer;

    void nextPlayer() {
        if (player.equals(Player.MAIN_PLAYER)) {
            player = Player.OTHER_PLAYER;
        } else {
            player = Player.MAIN_PLAYER;
        }
    }

    public abstract MonteCarloGame deepCopy();

    public abstract void playMove(int moveNb);

    public abstract int getCurrentNbMoves();

//    public void resetGameToCurrentState() {
//        resetBoardToCurrentState();
//        this.player = this.realCurrentPlayer;
//    }

//    public abstract void resetBoardToCurrentState();


    public abstract void initialSetup();

    // Asks what move the non-AI player did and apply it. Does not change the current player
    public abstract void moveOtherPlayer();

    public abstract boolean gameOver();

    public abstract Player playerWinning();

    public abstract void tellWhichMoveIsBest(int move);


}
