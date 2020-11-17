

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

        assertEquals("Zombie", creatureCard.getTitle());
        assertEquals("Yo it's a Zombie", creatureCard.getDescription());
        assertEquals(6, creatureCard.getMaxHealth());
        assertEquals(6, creatureCard.getHealth());
        assertEquals(2, creatureCard.getDefaultDamage());
        assertEquals(2, creatureCard.getDamage());
    }

    @Test
    public void modifyHealth() {
        CreatureCard creatureCard = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);

        creatureCard.modifyHealth(6);
        assertEquals(6, creatureCard.getHealth());
        creatureCard.modifyHealth(-4);
        assertEquals(2, creatureCard.getHealth());
        creatureCard.modifyHealth(2);
        assertEquals(4, creatureCard.getHealth());
        creatureCard.modifyHealth(-100);
        assertEquals(0, creatureCard.getHealth());
    }

    @Test
    public void modifyDamage() {
        CreatureCard creature = new CreatureCard("Zombie", "Yo it's a Zombie", 6, 2);

        creature.modifyDamage(6);
        assertEquals(8, creature.getDamage());
        creature.modifyDamage(-4);
        assertEquals(4, creature.getDamage());
        creature.modifyDamage(2);
        assertEquals(6, creature.getDamage());
        creature.modifyDamage(-100);
        assertEquals(0, creature.getDamage());
    }
}
