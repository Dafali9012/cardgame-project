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
}
