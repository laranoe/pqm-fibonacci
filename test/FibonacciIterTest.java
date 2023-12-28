import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void iterativeFunction_StringValue() {
        Exception exception = assertThrows(NumberFormatException.class, () -> FibonacciRec.main(new String[] {"test"}));
        assertEquals("For input string: \"test\"", exception.getMessage());
    }

    @Test
    void iterativeFunction_validValue() {
        assertEquals(9227465, FibonacciIter.iterativeFunction("35"));
    }

    @Test
    void iterativeFunction_outOfRangeValue() {
        assertTrue(FibonacciIter.iterativeFunction("50") < 0);
    }

    @Test
    void iterativeFunction_negativeValue() {
        assertEquals(1, FibonacciIter.iterativeFunction("-1"));
    }
    @Test
    void main_StringValue() {
        Exception stringValue = assertThrows(NumberFormatException.class, () -> FibonacciIter.main(new String[] {"test"}));
        assertEquals("For input string: \"test\"", stringValue.getMessage());
    }
    @Test
    void main_NegativeValue() {
        FibonacciIter.main(new String[]{"-1"});
        assertEquals("F(-1) = 1\n", outContent.toString());
    }
    @Test
    void main_ValidValue() {
        FibonacciIter.main(new String[]{"35"});
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }
    @Test
    void main_outOfRangeValue() {
        FibonacciIter.main(new String[]{"50"});
        String output = outContent.toString();
        String [] values = output.split("=");
        assertTrue(Long.parseLong(values[1].trim()) < 0);
    }

    @Test
    void main_nonIntegerValue() {
        Exception stringValue = assertThrows(NumberFormatException.class, () -> FibonacciIter.main(new String[] {"3000000000"}));
        assertEquals("For input string: \"3000000000\"", stringValue.getMessage());
    }
}