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
    void stringValue() {
        Exception stringValue = assertThrows(NotANumberException.class, () -> FibonacciRec_Exceptions.main(new String[] {"test"}));
        assertEquals("The input number has to be numerical", stringValue.getMessage());
    }

    @Test
    void negativeNumber() {
        Exception stringValue = assertThrows(NegativeNumberException.class, () -> FibonacciRec_Exceptions.main(new String[] {"-1"}));
        assertEquals("Input cannot be a negative number", stringValue.getMessage());
    }

    @Test
    void validInput(){
        FibonacciRec_Exceptions fib = new FibonacciRec_Exceptions(35);
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }

    @Test
    void outOfRangeInput() {
        Exception stringValue = assertThrows(ValueOutOfRangeException.class, () -> FibonacciRec_Exceptions.main(new String[] {"50"}));
        assertEquals("The input cannot be greater than 46.", stringValue.getMessage());
    }
}