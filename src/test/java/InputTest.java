import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    //simulate user input of value 1 with string prompt, min value and max value as parameter.
    @Test
    void numberTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);
        assertEquals(1, Input.number("Test with prompt string", 1,5));
    }

    //simulate user input of value "test" with a String prompt and regex-check of valid answers.
    @Test
    void textTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
        System.setIn(in);
        assertEquals("test", Input.text("Test prompt text()", new String[]{".*"}));
    }
}
