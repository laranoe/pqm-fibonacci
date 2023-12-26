import Exceptions.NegativeNumberException;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciRecTest {

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
        Exception exception = assertThrows(NumberFormatException.class, () -> FibonacciRec.main(new String[] {"test"}));
        assertEquals("For input string: \"test\"", exception.getMessage());
    }

    @Test
    // negative numbers will cause a StackOverflow
    void negativeNumber() {
        assertThrows(StackOverflowError.class, () -> FibonacciRec.main(new String[] {"-1"}));
    }

    @Test
    void validInput(){
        FibonacciRec fib = new FibonacciRec(35);
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }

    @Test
    // an Integer Overflow will create negative return values
    void outOfRangeInput() {
        FibonacciRec fib = new FibonacciRec(50);
        String output = outContent.toString();
        String [] values = output.split("=");
        assertTrue(Integer.parseInt(values[1]) < 0);
    }


}