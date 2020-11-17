
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
            spellCard = new SpellCard("Fireball", "Ball of flame that both damages and heals!",10,12);
        } catch (Exception e) {
            fail();
        }

        assertEquals("Fireball", spellCard.getTitle());
        assertEquals("Ball of flame that both damages and heals!", spellCard.getDescription());
        assertEquals(10, spellCard.getHeal());
        assertEquals(12, spellCard.getDamage());
    }
}
