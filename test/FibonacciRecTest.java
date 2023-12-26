import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }

    @Test
    void negativeNumber() {

    }

    @Test
    void validInput(){
        FibonacciRec fib = new FibonacciRec(35);
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }

    @Test
    void outOfRangeInput() {

    }


}