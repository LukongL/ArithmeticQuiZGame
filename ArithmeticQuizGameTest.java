import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ArithmeticQuizGameTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testAnsweringQuestions() {
        // Simulate user input for each question
        String simulatedInput = "B\nC\nC\nB\nB\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Run the ArithmeticQuizGame
        ArithmeticQuizGame.main(new String[0]);

        // Verify the output
        String expectedOutput = "Your final score: 100.0%\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
