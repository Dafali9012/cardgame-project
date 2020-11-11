package test;

import main.SpellCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCardTest {

    @Test
    public void emptyConstructor() {
        SpellCard spellcard = new SpellCard();
        assertEquals("Undefined", spellcard.getTitle());
        assertEquals("Undefined", spellcard.getDescription());
        assertEquals(1, spellcard.getDamage());
        assertEquals(1, spellcard.getHeal());
    }

    @Test
    public void parameterConstructor() {
        SpellCard spellcard = new SpellCard("Fireball", "Ball of flame that both damages and heals!",10,12);
        assertEquals("Fireball", spellcard.getTitle());
        assertEquals("Ball of flame that both damages and heals!", spellcard.getDescription());
        assertEquals(10, spellcard.getDamage());
        assertEquals(12, spellcard.getHeal());
    }
}
