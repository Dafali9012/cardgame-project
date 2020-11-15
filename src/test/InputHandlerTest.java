package test;

import main.InputHandler;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    InputHandlerTest(){
        constructorTest();
        getIntFromUserTest();
    }

    @Test
    void constructorTest() {
        InputHandler input = null;
        try {
            input = new InputHandler();
        } catch (Exception e) {
            fail();
        }
    }

    //simulate user input of value 1.
    @Test
    void getIntFromUserTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, input.getInt());
    }
}
