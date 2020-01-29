package com.company;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialSetup();

        while (!game.gameOver()) {
            int bestMove = new MonteCarlo(game).getBestMove();
            game.displayBoard();
            game.tellWhichMoveIsBest(bestMove);
            game.playMove(bestMove);
            if (!game.gameOver()) {
                game.nextPlayer();
                game.displayBoard();
                game.moveOtherPlayer();
                game.nextPlayer();
            }
        }
    }
}
