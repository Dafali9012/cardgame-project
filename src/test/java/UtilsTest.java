import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    @Test
    public void getCardSettings() {
        CardSettings cardSettings = Utils.getCardSettings("res/cards");
        assertNotNull(cardSettings);
        assertNotEquals(0,cardSettings.creatures.size());
        assertNotEquals(0,cardSettings.spells.size());
    }

    @Test
    public void generateDeck() {
        CardSettings cardSettings = Utils.getCardSettings("res/cards");
        List<Card> newDeck = Utils.generateDeck(cardSettings);
        assertNotNull(newDeck);
        assertTrue(newDeck.size() >= cardSettings.creatures.size()+cardSettings.spells.size());
        newDeck = Utils.generateDeck(null);
        assertNull(newDeck);
    }
}
