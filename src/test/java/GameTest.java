import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    CreatureCard creature;
    List<Card> deck;
    List<Card> to;
    Player player;
    Game game;

    @BeforeEach
    public void beforeTest(){
        deck = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
        to = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
        creature = new CreatureCard("Dafali", "Your code sucks!", new String[0], 4, 2);
        player = new Player("Daniel", 5, 100);
        game = new Game();
    }

    @Test
    public void moveCardTest () {
        assertTrue(game.moveCard(1, deck, to), "Moving card not successful");
        assertFalse(game.moveCard(-1, deck, to), "Index cannot be negative");
        assertFalse(game.moveCard(100, deck, to), "Index cannot be longer than the list itself");
    }

    @Test
    public void drawCardTest () {
        Card obj = to.get(0);
        to.clear();
        to.add(obj);
        player.setDeck(to);
        player.setHand(to);
        assertTrue(game.drawCard(player));

        player.setDeck(deck);
        player.setHand(deck);
        assertTrue(game.drawCard(player));
    }

    @Test
    public void attackCardTest () {
        game.attackCard(creature, creature);
        assertEquals(2, creature.health);

        creature.modifyDamage(4);
        game.attackCard(creature, creature);
        assertEquals(0, creature.health);
    }

    @Test
    public void attackOpponentTest () {
        game.attackOpponent(creature, player);
        assertEquals(98, player.getHealth());

        creature.modifyDamage(100);
        game.attackOpponent(creature, player);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testPlayerInitialHealth(){
        assertEquals(100, player.getHealth(), "Player health is not as expected");
    }

    @Test
    public void testPlayerDead(){
        player.modifyHealth(-100);
        assertTrue(player.getHealth() < 1, "Player health is expected to be less than 1 but was "
                + player.getHealth());
    }

    @Test
    public void testOpponentInitialHealth(){
        assertEquals(100, game.opponent.getHealth(), "Opponent health is not as expected");
    }

    @Test
    public void testOpponentDead(){
        game.opponent.modifyHealth(-100);
        assertTrue(game.opponent.getHealth() < 1, "Opponent health is expected to be less than 1 but was "
                + player.getHealth());
    }
}
