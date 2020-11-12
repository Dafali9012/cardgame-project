package main;

import java.util.List;

public class Game {
    public Game() {
        List<Card> deck = Utils.generateDeck(Utils.getCardSettings("res/cards"));
        int cardCount = 1;
        for(Card c : deck) {
            System.out.println(cardCount+". "+c.getTitle());
            cardCount++;
        }
    }
}
