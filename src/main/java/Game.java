package java;

import javax.smartcardio.Card;
import java.util.List;

public class Game {

    public Game() {
        cardUsage();
    }

    private void cardUsage() {
        CardTemplate[] templateDeck = Cards.getCardTemplates("res/card-templates");
        List<Card> newDeck = Cards.generateDeck(templateDeck);
        int cardCount = 1;
        for(Card card : newDeck) {
            System.out.println("- "+cardCount+" "+"-".repeat(20)+"\n");
            System.out.println(card.title);
            System.out.println(card.description);
            if(card instanceof CreatureCard) {
                CreatureCard c = (CreatureCard) card;
                System.out.print("HP "+c.health+"/"+c.maxHealth);
                System.out.println(" DMG "+c.damage+"\n");
            } else if(card instanceof SpellCard) {
                SpellCard c = (SpellCard) card;
                System.out.println("HEAL "+c.health+" DMG "+c.damage+"\n");
            }
            cardCount++;
        }
        System.out.println("-".repeat(25));
    }

    /**
     * Creates a new game with two players, "Players 1" and "Players 2"
     */
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
     * Check if game is over.
     * @return returns true if either player has 0 health.
     */
    public boolean isGameOver(){
        if(player1.getHealth() < 1) {
            System.out.println("Game is over");
            return true;
        } else {
            runNextTurn();
            return false;
        }
    }

    /**
     * Get current turn
     * @return what player is playing
     */
    private Player getCurrentPlayersTurn(){
        if(turnCounter%2 == 0){
            System.out.println("It's your turn");
            return player1;
        } else{
            System.out.println("It's The enemies turn");
            return player2;
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