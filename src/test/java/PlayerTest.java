import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
        List<Card> deck;
        List<Card> to;
        Player player;

        @BeforeEach
        public void beforeTest(){
            player = new Player("David", 5, 100);
            deck = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
            to = Cards.generateDeck(Cards.getCardTemplates("res/card-templates"));
        }

        @Test
        public void constructorWithArgument () {

            assertEquals("David", player.getName(), "Expected name 'David' got: " + player.getName());
            assertEquals(5, player.getId(), "Expected id '5' got: " + player.getId());
            assertEquals(100, player.getMaxHealth(), "Expected health '20' got: " + player.getMaxHealth());
        }

        @Test
        public void constructorWithoutArgument () {
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
        public void modifyHealthTest () {
            player.modifyHealth(10);
            assertEquals(100, player.getHealth());
            player.modifyHealth(-14);
            assertEquals(86, player.getHealth());
            player.modifyHealth(8);
            assertEquals(94, player.getHealth());
            player.modifyHealth(-100);
            assertEquals(0, player.getHealth());
        }

        @Test
        public void setDeckTest () {
            assertEquals(player.setDeck(deck), player.getDeck(), "Adding to deck failed");
            assertFalse(player.getDeck().isEmpty(), "Should not be null");
        }

        @Test
        public void setHandTest () {
            assertEquals(player.setHand(deck), player.getHand(), "Adding to deck failed");
            assertFalse(player.getHand().isEmpty(), "Should not be null");
        }

        @Test
        public void setPlayTest () {
            assertEquals(player.setPlay(deck), player.getPlay(), "Adding to deck failed");
            assertFalse(player.getPlay().isEmpty(), "Should not be null");
        }

        @Test
        public void setGraveyardTest () {
            assertEquals(player.setGrave(deck), player.getGrave(), "Adding to deck failed");
            assertFalse(player.getGrave().isEmpty(), "Should not be null");
        }

        @Test
        public void getDeckTest () {
            player.setDeck(deck);
            assertFalse(player.getDeck().isEmpty());
            assertEquals(player.getDeck(), deck);
        }

        @Test
        public void getHandTest() {
            player.setHand(deck);
            assertFalse(player.getHand().isEmpty());
            assertEquals(player.getHand(), deck);
        }

        @Test
        public void getPlayTest() {
            player.setPlay(deck);
            assertFalse(player.getPlay().isEmpty());
            assertEquals(player.getPlay(), deck);
        }

        @Test
        public void getGraveyardTest() {
            player.setGrave(deck);
            assertEquals(player.getGrave(), deck);
        }
    }
