import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIter_ErrorChecksTest {

    private final int x = 4; //for these checks we only allow Integer inputs, so x is always 4
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
        Exception exception = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.iterativeFunction("test", x));
        assertEquals("Inputs must be valid numbers.", exception.getMessage());
    }

    @Test
    void iterativeFunction_negativeValue() {
        Exception stringValue = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.main(new String[] {"-1"}));
        assertEquals("Inputs must be non-negative numbers.", stringValue.getMessage());
    }

    @Test
    void iterativeFunction_validValue() {
        assertEquals(9227465, FibonacciIter_ErrorChecks.iterativeFunction("35", x));
    }

    @Test
    void iterativeFunction_outOfRangeValue() {
        assertThrows(FibonacciIter_ErrorChecks.FibonacciUpperBoundError.class, () -> FibonacciIter_ErrorChecks.iterativeFunction("50", x));
    }

    @Test
    void iterativeFunction_nonIntegerValue() {
        Exception stringValue = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.iterativeFunction("3000000000", x));
        assertEquals("Inputs must be integers.", stringValue.getMessage());
    }

    @Test
    void main_StringValue() {
        Exception stringValue = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.main(new String[] {"test"}));
        assertEquals("Inputs must be valid numbers.", stringValue.getMessage());
    }

    @Test
    void main_NegativeValue() {
        Exception stringValue = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.main(new String[] {"-1"}));
        assertEquals("Inputs must be non-negative numbers.", stringValue.getMessage());
    }

    @Test
    void main_ValidValue() {
        FibonacciIter_ErrorChecks.main(new String[]{"35"});
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }
    @Test
    void main_outOfRangeValue() {
        assertThrows(FibonacciIter_ErrorChecks.FibonacciUpperBoundError.class, () -> FibonacciIter_ErrorChecks.main(new String[] {"50"}));
    }

    @Test
    void main_nonIntegerValue() {
        Exception stringValue = assertThrows(FibonacciIter_ErrorChecks.InvalidInputError.class, () -> FibonacciIter_ErrorChecks.main(new String[] {"3000000000"}));
        assertEquals("Inputs must be integers.", stringValue.getMessage());
    }
}
