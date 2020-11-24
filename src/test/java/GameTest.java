import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    List<Card> deck = Cards.generateDeck(Cards.getCardTemplates("card_templates/standard"));
    List<Card> to = new ArrayList<>();
    Player player = new Player("Daniel", 5, 100);
    CreatureCard creature = new CreatureCard("Dafali", "Your code sucks!", new String[0], 4, 2);
    Game game = new Game(true);

    @Test
    public void moveCardTest () {
        game.moveCard(0, deck, to);
        assertEquals(1, to.size());
        game.moveCard(-1, deck, to);
        assertEquals(1, to.size());
        game.moveCard(100, deck, to);
        assertEquals(1, to.size());
    }

    @Test
    public void drawCardTest () {
        player.setDeck(deck);

        game.drawCard(player);
        assertEquals(4, player.getHand().size());

        game.drawCard(player);
        assertEquals(5, player.getHand().size());
    }

    @Test
    public void modifyHealthTest () {
        game.modifyHealth(-2, creature);
        assertEquals(2, creature.health);

        game.modifyHealth(100, creature);
        assertEquals(creature.maxHealth, creature.health);

//        game.modifyHealth(-100, creature);
//        assertEquals(0, creature.health);
    }

    @Test
    public void checkHpTestWithPlayer(){
        game.checkHp(player);
        assertNotNull(player);
        assertEquals(100, player.getHealth());
        player.modifyHealth(-20);
        assertEquals(80, player.getHealth());
        game.checkHp(player);
        assertFalse(game.gameOver);
        player.modifyHealth(-80);
        assertEquals(0, player.getHealth());
        game.checkHp(player);
        assertTrue(game.gameOver);
    }

    @Test
    public void checkHpTestWithCreature(){
        game.checkHp(creature);
        assertNotNull(creature);
        creature.modifyHealth(-2);
        assertEquals(2, creature.health);
        game.checkHp(creature);
        assertFalse(game.gameOver);
        creature.modifyHealth(-2);
        assertEquals(0, creature.health);
        assertFalse(game.gameOver);
    }
}
