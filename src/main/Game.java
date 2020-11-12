package main;

public class Game {
    /**
     * Creates a new game with two players, "Players 1" and "Players 2"
     */
    public Game() {

    }

    int turnCounter;
    boolean gameOver = false;


    /**
     * Increments the turn counter.
     * @return returns the new value.
     */
    private int incrementTurnCounter(){
        return -1;
    }

    /**
     * Get player that has the current turn.
     * @return player1 or player2.
     */
    private Player getCurrentPlayersTurn(){
        return null;
    }

    /**
     * Check if game is over.
     * @return returns true if either player has 0 health.
     */
    public boolean isGameOver(){
        return true;
    }

    /**
     * Plays next turn.
     * @return played turn count
     */
    public int runNextTurn() {
        return incrementTurnCounter();
    }


}
