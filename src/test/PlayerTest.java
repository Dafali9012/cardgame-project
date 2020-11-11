package test;

import main.Player;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    public PlayerTest(){
        addPlayerTest();
    }

    @Test
    public void addPlayerTest(){

        player = new Player("David", 5, 20);
        assertEquals("David", player.getName());
        assertEquals(5, player.getId());
        assertEquals(20, player.getHealth());

    }
}
