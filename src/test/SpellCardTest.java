package test;

import main.SpellCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpellCardTest {

    @Test
    public void emptyConstructor() {
        SpellCard spellCard = null;

        try {
            spellCard = new SpellCard();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void parameterConstructor() {
        SpellCard spellCard = null;

        try {
            spellCard = new SpellCard("Fireball", "Ball of flame that both damages and heals!", 4, new String[]{"player-play-modifyhealth-one"});
        } catch (Exception e) {
            fail();
        }

        assertEquals("Fireball", spellCard.getTitle());
        assertEquals("Ball of flame that both damages and heals!", spellCard.getDescription());
        assertEquals(4, spellCard.getHealthModifier());
    }
}
