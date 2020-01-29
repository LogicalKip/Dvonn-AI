package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeGameTest {

    @Test
    public void testTicTacToeBestFirstMove() {
        TicTacToeGame game = new TicTacToeGame();
        game.initialSetup();
        MonteCarlo monteCarlo = new MonteCarlo(game);
        int bestMove = monteCarlo.getBestMove();
        assertEquals(4, bestMove);
    }
}