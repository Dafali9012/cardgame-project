package main;

public class Game {
    public Game() {

    }

    int turnCounter;
    boolean gameOver = false;

    static public int reducePlayerHealth(Player player, int damage){
        player.modifyHealth()
        return PlayerHealth - damage;
    }

    public boolean checkIfGameOverIsTrue (int PlayerHealth) {
        if(PlayerHealth < 1) {
            this.gameOver = true;
        }
        return gameOver;
    }

    public String printoutIfGameOver(boolean gameOver){
        String Over =  "Game Over";
        return Over;
    }


    /*
      if(PlayerHealth < 1 || CreatureHealth < 1){
            return gameOver = true;
        } else{
            System.out.println(turnCounter);
            turnCounter++;
            System.out.println(turnCounter);
        }
    */
}
