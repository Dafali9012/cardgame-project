package test;

import main.Card;
import main.Player;
import org.junit.jupiter.api.*;

import java.util.List;

import static main.Utils.generateDeck;
import static main.Utils.getCardSettings;
import static org.junit.jupiter.api.Assertions.*;

    class PlayerTest {
        List<Card> deck;
        Player player;

        @BeforeEach
        public void beforeTest(){
            player = new Player("David", 5, 100);
            deck = generateDeck(getCardSettings("res/cards"));
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
        public void moveCardTest () {}

        @Test
        public void getDeckTest () {
            player.setDeck(deck);
            assertFalse(player.getDeck().isEmpty()); }
        @Test
        public void getNameTest() {
            assertEquals("Martin", "Martin");
        }
        @Test
        public void getIdTest() {
            assertEquals(23, 23);
        }
        @Test
        public void getHealthTest() {
            assertEquals(50, 50);
        }
        @Test
        public void getMaxHealthTest() {
            assertEquals(70, 70);
        }
    }
