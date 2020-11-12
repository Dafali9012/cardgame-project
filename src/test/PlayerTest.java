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
        assertEquals(null, player.getName());
        assertEquals(0, player.getId());
        assertEquals(0, player.getId());
        assertEquals(0, player.getHealth());
    }
}
