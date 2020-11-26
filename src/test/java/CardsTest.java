import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardsTest {
    @Test
    public void getCardSettings() {
        CardTemplate[] cardTemplates = Cards.getCardTemplates("card_templates/standard");
        assertTrue(cardTemplates.length>0);
    }

    @Test
    public void generateDeck() {
        CardTemplate[] cardTemplates = Cards.getCardTemplates("card_templates/standard");
        assertTrue(cardTemplates.length>0);
        List<Card> newDeck = Cards.generateDeck(cardTemplates);
        assertTrue(newDeck.size()>0);
    }
}
