import java.util.List;

public class Main {
    public Main() {
        cardUsage();
        //UserInterface userInterface  = new UserInterface();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void cardUsage() {
        List<Card> deck = Utils.generateDeck(Utils.getCardSettings("res/cards"));

        int cardCount = 1;
        for(Card card : deck) {
            System.out.println(cardCount+". "+card.getTitle());
            System.out.println((cardCount<10?"   \"":"    \"")+card.getDescription()+"\"");
            switch (card.getClass().getSimpleName()) {
                case "CreatureCard" -> {
                    CreatureCard c = (CreatureCard) card;
                    System.out.println((cardCount<10?"   ":"    ")+"HP: "+c.getHealth()+" ATK: "+c.getDamage());
                }
                case "SpellCard" -> {
                    SpellCard c = (SpellCard) card;
                    System.out.println((cardCount<10?"   ":"    ")+"HEALTHMODIFIER: "+c.getHealthModifier());
                }
            }
            cardCount++;
        }
    }

    private void playSpell(SpellCard c) {
        for(String m : c.getMethods()) {
            String[] instr = m.split("-");

            Player targetPlayer = null;

            if(instr[0].equals("player")) {}// targetPlayer = player
            else if(instr[0].equals("opponent")) {} // targetPlayer = opponent

            if(instr[2].equals("modifyhealth")) {
                // targetPlayer.getDeck().get( input.number ).modifyHealth(c.getHealthModifier)
            }

            if(instr[2].equals("movecard")) {
                //
            }
        }
    }
}
