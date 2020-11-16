package main;

import java.lang.reflect.Array;
import java.util.List;

public class UserInterface {
    private void askForUsername(){
        System.out.println("Write username:");
    }
    private void displayTurnOptions(){
    }

    public void displayPlayersNameAndHp(){
    }

    public void displayCreatureCard(){
    }

    public void displayHand(){
    }

    public String dispenseHand(List<CreatureCard> cards ){
        return null;
    }

    public String dispensePlayerNameAndHp(Player player){
        return null;
    }

    public String dispenseCreatureCard(CreatureCard card){
        return null;
    }


}

class Test{
    public static void main(String[] args) {
        Player player1 = new Player("Jon",1,100);
        Player player2 = new Player("Tim",2,100);
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        System.out.println(players[0].getName());

    }
}