package test;

import main.Card;
import main.CardSettings;
import main.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    @Test
    public void getCardSettings() {
        CardSettings cardSettings = Utils.getCardSettings();
        assertNotNull(cardSettings);
        assertEquals(40,cardSettings.creatures.size());
        assertEquals(20,cardSettings.spells.size());
    }

    @Test
    public void buildDeck() {
        CardSettings cardSettings = Utils.getCardSettings();
        List<Card> newDeck = Utils.buildDeck(cardSettings);
        assertNotNull(newDeck);
        assertEquals(60, newDeck.size());
    }
}
