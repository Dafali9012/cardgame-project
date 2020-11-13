package test;

import main.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Game g;
    @Before
    public void setupGame() {
        g = new Game();
    }

    @Test
    public void testTurnCounterInitialState() {
        Assert.assertEquals("Expected turn count to be 1",1, g.runNextTurn());
    }

    @Test
    public void testTurnCounterNotOverRealValue(){
        Assert.assertEquals("Turn is expected to be incremented", g.runNextTurn(), g.runNextTurn() + 1);
    }

    @Test
    public void testTurnCounterNotUnderRealValue(){
        Assert.assertEquals("Turn isn't expected to be less than the last turn",
                g.runNextTurn(), g.runNextTurn() - 1);
    }

    @Test
    public void testIfGameOverIsTrue(){
        Assert.assertFalse("GameOver is true", true);
     }
}
