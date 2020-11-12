package test;

import main.Player;
import main.UserInterface;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class TestUserInterface {
    UserInterface userInterface = new UserInterface();
    Player player = new Player("Player1",100);

    @Test
   public void testFormatPlayerNameAndHp() {
        System.out.println("======TEST ONE formatPlayerNameAndHp");
        Assertions.assertNotNull(userInterface.formatPlayerNameAndHp(player));
        Assertions.assertTrue(  userInterface.formatPlayerNameAndHp(player) instanceof java.lang.String );
    }
}
