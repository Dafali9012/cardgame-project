import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    List<Card> deck;
    List<Card> to;
    Player player;
    Game game;

    @BeforeEach
    public void beforeTest(){
        deck = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
        to = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
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

}