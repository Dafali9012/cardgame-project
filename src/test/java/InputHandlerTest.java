

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private List<String> validAnswers = new ArrayList<>(List.of("yes","no"));

    InputHandlerTest(){
        constructorTest();
        getIntTest();
        getIntWithPromptTest();
        getIntWithPromptAndMaxValueTest();
        getIntWithPromptAndMinValueAndMaxValueTest();
        getTextTest();
        getTextWithPromptAndValidAnswersTest();
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
    void getIntTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, input.getInt());
    }

    //simulate user input of value 1 with string prompt as parameter.
    @Test
    void getIntWithPromptTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, input.getInt("Test with prompt string"));
    }

    //simulate user input of value 1 with string prompt and max value as parameter.
    @Test
    void getIntWithPromptAndMaxValueTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, input.getInt("Test with prompt string", 3));
    }

    //simulate user input of value 1 with string prompt, min value and max value as parameter.
    @Test
    void getIntWithPromptAndMinValueAndMaxValueTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, input.getInt("Test with prompt string",0,3));
    }

    //simulate user input of value "user written text".
    @Test
    void getTextTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("user written text".getBytes());
        System.setIn(in);
        assertEquals("user written text", input.getText());
    }

    //simulate user input of value "yes" with a String prompt and an Arraylsit of valid answers.
    @Test
    void getTextWithPromptAndValidAnswersTest() {
        InputHandler input = new InputHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("yes".getBytes());
        System.setIn(in);
        assertEquals("yes", input.getText("Test prompt getText()", validAnswers));
    }
}
