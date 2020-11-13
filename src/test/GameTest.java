package test;

import main.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
    public void testTurnCounterNotUnderRealValue(){
        Assert.assertEquals("Turn isn't expected to be equal or less than last turn",
                g.runNextTurn(), g.runNextTurn() - 1);
    }

    @Test
    public void testTurnCounterNotOverRealValue(){
        Assert.assertEquals("Turn isn't expected to be equal or less than last turn",
                g.runNextTurn(), g.runNextTurn() + 1);
    }
}
