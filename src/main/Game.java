package main;

public class Game {
    /**
     * Creates a new game with two players, "Players 1" and "Players 2"
     */
    public Game() {

    }

    int turnCounter = 1;
    boolean gameOver = false;
    Player player1, player2;

    /**
     * Increments the turn counter.
     * @return returns the new value.
     */
    private int incrementTurnCounter(){
        turnCounter++;
        return turnCounter;
    }

    /**
     * Get player that has the current turn.
     * @return player1 or player2.
     */
    private Player CurrentPlayerTurn(){
        if(turnCounter%2 == 0){
            System.out.println("It's your turn");
            return player1;
        } else{
            System.out.println("It's The enemies turn");
            return player2;
        }
    }

    /**
     * Check if game is over.
     * @return returns true if either player has 0 health.
     */
    public boolean isGameOver(){
        if(this.Player.getHealth() < 1) {
            System.out.println("Game is over");
            return true;
        } else {
            runNextTurn();
            return false;
        }
    }

    /**
     * Plays next turn.
     * @return played turn count
     */
    public int runNextTurn() {
        return incrementTurnCounter();
    }


}
