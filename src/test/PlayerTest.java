package test;

import main.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    public PlayerTest() {
    }

    @Test
    public void constructorWithArgument() {

        Player player = new Player("David", 5, 20);
        assertEquals("David", player.getName(), "Expected name 'David' got: " + player.getName());
        assertEquals(5, player.getId(), "Expected id '5' got: " + player.getId());
        assertEquals(20, player.getHealth(), "Expected health '20' got: " + player.getHealth());
    }

    @Test
    public void constructorWithoutArgument() {
        try {
            new Player();
        } catch (Exception ex) {
            fail();
        }

        Player player = new Player();
        assertEquals("NoName", player.getName());
        assertEquals(0, player.getId());
        assertEquals(0, player.getHealth());
        assertEquals(0, player.getMaxHealth());
    }

    @Test
    public void modifyHealthTest() {
        Player player = new Player("David", 5, 100);
        player.modifyHealth(10);
        assertEquals(100, player.getHealth());
        player.modifyHealth(-14);
        assertEquals(86, player.getHealth());
        player.modifyHealth(8);
        assertEquals(94, player.getHealth());
        player.modifyHealth(-100);
        assertEquals(0,player.getHealth());
    }

    @Test
    public void moveCard() {}

    @Test
    public void setDeck() {}
}
