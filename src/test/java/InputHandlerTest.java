package test.java;

import main.java.InputHandler;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private List<String> validAnswers = new ArrayList<>(List.of("yes","no"));

    //simulate user input of value 1 with string prompt and max value as parameter.
    @Test
    void getIntWithPromptAndMaxValueTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);
        assertEquals(1, InputHandler.getInt("Test with prompt string", 3));
    }

    //simulate user input of value 1 with string prompt, min value and max value as parameter.
    @Test
    void getIntWithPromptAndMinValueAndMaxValueTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);
        assertEquals(1, InputHandler.getInt("Test with prompt string",0,3));
    }

    //simulate user input of value "yes" with a String prompt and an Arraylsit of valid answers.
    @Test
    void getTextWithPromptAndValidAnswersTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("yes".getBytes());
        System.setIn(in);
        assertEquals("yes", InputHandler.getText("Test prompt getText()", validAnswers));
    }
}
