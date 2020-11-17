import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserInterface userInterface  = new UserInterface();
        List<Card> deck = Utils.generateDeck(Utils.getCardSettings("res/cards"));
        List<Card> cards = new ArrayList<>();

        int cardCount = 1;
        for(Card card : deck) {
            System.out.println(cardCount+". "+card.getTitle());
            System.out.println((cardCount<10?"   \"":"    \"")+card.getDescription()+"\"");
            switch (card.getClass().getSimpleName()) {
                case "CreatureCard" -> {
                    CreatureCard c = (CreatureCard) card;
                    cards.add(c);
                    System.out.println((cardCount<10?"   ":"    ")+"HP: "+c.getHealth()+" ATK: "+c.getDamage());
                }
                case "SpellCard" -> {
                    SpellCard c = (SpellCard) card;
                    cards.add(c);
                    System.out.println((cardCount<10?"   ":"    ")+"HEAL: "+c.getHeal()+" DAMAGE: "+c.getDamage());
                }
            }
            cardCount++;
        }

    }
}
