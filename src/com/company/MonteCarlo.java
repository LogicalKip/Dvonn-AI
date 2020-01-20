package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MonteCarlo {
    private static final int MAX_NB_TRIES = 1000;
    private MonteCarloGame game;

    private Random rand = new Random();

    // Negative values mean lots of losses, positive means lots of wins
    private Map<Integer, Integer> gameResultsPerMove = new HashMap<>();

    public MonteCarlo(MonteCarloGame game) {
        this.game = game;
        this.game.setupBoard();
    }

    public int getBestMove() {
        this.game.setupBoard();
        int nbStartingMoves = game.getCurrentNbMoves();
        for (int moveBeingAnalyzed = 0; moveBeingAnalyzed < nbStartingMoves; moveBeingAnalyzed++) {
            if (moveBeingAnalyzed == 4) {
                System.out.println();
            }
            System.out.println("Analyzing move " + moveBeingAnalyzed);
            for (int nbTries = 0; nbTries < MAX_NB_TRIES; nbTries++) {
                this.game.setupBoard();
                this.game.playMove(moveBeingAnalyzed);
                this.game.nextPlayer();
                while (!game.gameOver()) {
                    int randomMove = rand.nextInt(game.getCurrentNbMoves());
                    this.game.playMove(randomMove);
                    this.game.nextPlayer();
                }
                if (!gameResultsPerMove.containsKey(moveBeingAnalyzed)) {
                    gameResultsPerMove.put(moveBeingAnalyzed, 0);
                }

                Integer currentScoreForMoveAnalyzed = gameResultsPerMove.get(moveBeingAnalyzed);
                if (game.playerWinning().equals(Player.MAIN_PLAYER)) {
                    gameResultsPerMove.put(moveBeingAnalyzed, currentScoreForMoveAnalyzed + 1);
                } else if (game.playerWinning().equals(Player.OTHER_PLAYER)) {
                    gameResultsPerMove.put(moveBeingAnalyzed, currentScoreForMoveAnalyzed - 1);
                }
            }
            System.out.println("Finished computing move " + moveBeingAnalyzed);
        }
        return 0;//FIXME
    }
}
