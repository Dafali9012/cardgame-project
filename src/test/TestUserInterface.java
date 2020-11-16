package test;

import main.CreatureCard;
import main.Player;
import main.UserInterface;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestUserInterface {
    UserInterface userInterface = new UserInterface();
    Player player = new Player("Player1",1,100);
    CreatureCard card = new CreatureCard();
    ArrayList<CreatureCard> cards = new ArrayList<CreatureCard>();

    @Test
   public void testDispensePlayerNameAndHp() {
        System.out.println("======TEST ONE testDispensePlayerNameAndHp");
        Assertions.assertNotNull(userInterface.dispensePlayerNameAndHp(player));
        Assertions.assertTrue(  userInterface.dispensePlayerNameAndHp(player) instanceof java.lang.String );
    }

    @Test
    public void dispenseCreatureCard() {
        System.out.println("======TEST ONE dispenseCreatureCard");
        Assertions.assertNotNull(userInterface.dispenseCreatureCard(card));
        Assertions.assertTrue(  userInterface.dispenseCreatureCard(card) instanceof java.lang.String );
    }

    @Test

    public  void dispenseHand(){
        System.out.println("======TEST ONE dispenseHand");
        Assertions.assertNotNull(userInterface.dispenseHand(cards));

    }

}
