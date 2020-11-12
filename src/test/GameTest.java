package test;

import main.Game;
import main.Player;

public class GameTest {
    public static void main(String[] args) {

        //Test 1: Test if PlayerHealth gets to 1hp
        var PlayerHealth = Game.reducePlayerHealth(100, 99);
        assert (PlayerHealth < 1);
        if (PlayerHealth < 1) {
            throw new RuntimeException(
            "Game.checkIfGameOverIsTrue - expected gameover to be true" +
                    "and got: " + PlayerHealth);
        }

        //Test 2: Test if PlayerHealth gets to 1hp
        PlayerHealth = Game.reducePlayerHealth(100, 200);
        if (PlayerHealth < 1) {
            throw new RuntimeException(
                "Game.checkIfGameOverIsTrue - expected gameover to be true" +
                    "and got: " + PlayerHealth);
        }
    }
}
