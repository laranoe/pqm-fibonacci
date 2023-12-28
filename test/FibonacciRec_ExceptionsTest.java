import Exceptions.NegativeNumberException;
import Exceptions.NotANumberException;
import Exceptions.ValueOutOfRangeException;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciRec_ExceptionsTest {

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
    void main_stringValue() {
        Exception stringValue = assertThrows(NotANumberException.class, () -> FibonacciRec_Exceptions.main(new String[] {"test"}));
        assertEquals("The input number has to be numerical", stringValue.getMessage());
    }

    @Test
    void main_negativeNumber() {
        Exception stringValue = assertThrows(NegativeNumberException.class, () -> FibonacciRec_Exceptions.main(new String[] {"-1"}));
        assertEquals("Input cannot be a negative number", stringValue.getMessage());
    }

    @Test
    void main_validInput() throws NegativeNumberException, NotANumberException, ValueOutOfRangeException {
        FibonacciRec_Exceptions.main(new String[]{"35"});
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }

    @Test
    void main_outOfRangeInput() {
        Exception stringValue = assertThrows(ValueOutOfRangeException.class, () -> FibonacciRec_Exceptions.main(new String[] {"50"}));
        assertEquals("The input cannot be greater than 46.", stringValue.getMessage());
    }
}