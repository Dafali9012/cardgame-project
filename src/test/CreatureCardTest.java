package test;

import main.CreatureCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreatureCardTest {
    @Test
    public void emptyConstructor() {
        CreatureCard creature = new CreatureCard();
        assertEquals("Undefined", creature.getTitle());
        assertEquals("Undefined", creature.getDescription());
        assertEquals(1, creature.getMaxHealth());
        assertEquals(1, creature.getHealth());
        assertEquals(1, creature.getDefaultDamage());
        assertEquals(1, creature.getDamage());
    }

    @Test
    public void parameterConstructor() {
        CreatureCard creature = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);
        assertEquals("Zombie", creature.getTitle());
        assertEquals("Yo it's a Zombie", creature.getDescription());
        assertEquals(6, creature.getMaxHealth());
        assertEquals(6, creature.getHealth());
        assertEquals(2, creature.getDefaultDamage());
        assertEquals(2, creature.getDamage());
    }
}
