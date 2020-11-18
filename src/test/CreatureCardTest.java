package test;

import main.CreatureCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreatureCardTest {
    @Test
    public void emptyConstructor() {
        try {
            CreatureCard creatureCard = new CreatureCard();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void parameterConstructor() {
        CreatureCard creatureCard = null;
        try {
            creatureCard = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);
        } catch (Exception e) {
            fail();
        }

        assertEquals("Zombie", creatureCard.title);
        assertEquals("Yo it's a Zombie", creatureCard.description);
        assertEquals(6, creatureCard.maxHealth);
        assertEquals(6, creatureCard.health);
        assertEquals(2, creatureCard.defaultDamage);
        assertEquals(2, creatureCard.damage);
    }

    @Test
    public void modifyHealth() {
        CreatureCard creatureCard = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);

        creatureCard.modifyHealth(6);
        assertEquals(6, creatureCard.health);
        creatureCard.modifyHealth(-4);
        assertEquals(2, creatureCard.health);
        creatureCard.modifyHealth(2);
        assertEquals(4, creatureCard.health);
        creatureCard.modifyHealth(-100);
        assertEquals(0, creatureCard.health);
    }

    @Test
    public void modifyDamage() {
        CreatureCard creature = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);

        creature.modifyDamage(6);
        assertEquals(8, creature.damage);
        creature.modifyDamage(-4);
        assertEquals(4, creature.damage);
        creature.modifyDamage(2);
        assertEquals(6, creature.damage);
        creature.modifyDamage(-100);
        assertEquals(0, creature.damage);
    }
}
