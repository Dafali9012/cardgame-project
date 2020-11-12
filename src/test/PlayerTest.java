package test;

import main.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    public PlayerTest() {
        constructorWithArgument();
    }

    @Test
    public void constructorWithArgument() {
        player = new Player("David", 5, 20);
        assertEquals("David", player.getName(), "Expected name 'David' got: " + player.getName());
        assertEquals(5, player.getId(), "Expected id '5' got: " + player.getId());
        assertEquals(20, player.getHealth(), "Expected health '20' got: " + player.getHealth());
    }
}
