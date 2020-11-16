package main;

import java.util.List;
import static main.Utils.*;

public class Main {
    public static void main(String[] args) {
        InputHandler ih = new InputHandler();
        ih.getInt("Choose a number");
//        List<Card> deck = generateDeck(getCardSettings("res/cards"));
//        int cardCount = 1;
//        for(Card card : deck) {
//            System.out.println(cardCount+". "+card.getTitle());
//            System.out.println((cardCount<10?"   \"":"    \"")+card.getDescription()+"\"");
//            switch (card.getClass().getSimpleName()) {
//                case "CreatureCard" -> {
//                    CreatureCard c = (CreatureCard) card;
//                    System.out.println((cardCount<10?"   ":"    ")+"HP: "+c.getHealth()+" ATK: "+c.getDamage());
//                }
//                case "SpellCard" -> {
//                    SpellCard c = (SpellCard) card;
//                    System.out.println((cardCount<10?"   ":"    ")+"HEAL: "+c.getHeal()+" DAMAGE: "+c.getDamage());
//                }
//            }
//            cardCount++;
//        }
    }
}
