import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    List<Card> deck;
    List<Card> to;
    Game game;

    @BeforeEach
    public void beforeTest(){
        deck = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
        to = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
    }

    @Test
    public void moveCardTest () {
        assertTrue(game.moveCard(1, deck, to), "Moving card not successful");
        assertFalse(game.moveCard(-1, deck, to), "Index cannot be negative");
        assertFalse(game.moveCard(100, deck, to), "Index cannot be longer than the list itself");
    }

}
