package test;

import main.Card;
import main.Player;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

    class PlayerTest {
        Card card = new Card("Hamster", "Harmless");
        Player player;
        ArrayList<Card> cards;

        @BeforeEach
        public void beforeTest(){
            player = new Player("David", 5, 100);
            cards = new ArrayList<>();
            cards.add(card);
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
            assertTrue(player.setDeck(cards), "Adding to deck failed");
            assertFalse(player.setDeck(null), "Should not be null");
        }

        @Test
        public void moveCardTest () {
            player = new Player();

        }

        @Test
        public void getDeckTest () {}

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
