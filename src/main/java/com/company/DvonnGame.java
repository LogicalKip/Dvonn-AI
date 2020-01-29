package com.company;

public class DvonnGame extends MonteCarloGame {
    @Override
    public MonteCarloGame deepCopy() {
        return null;
    }

    @Override
    public void playMove(int moveNb) {

    }

    @Override
    public int getCurrentNbMoves() {
        return 0;
    }


    @Override
    public void initialSetup() {

    }

    @Override
    public void moveOtherPlayer() {

    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public Player playerWinning() {
        return null;
    }

    @Override
    public void tellWhichMoveIsBest(int move) {

    }
}
