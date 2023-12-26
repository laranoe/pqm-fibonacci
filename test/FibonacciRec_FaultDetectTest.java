import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciRec_FaultDetectTest {

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
        //nothing should happen for string inputs
    void stringValue() {
        FibonacciRec_FaultDetect.main(new String[]{"test"});
        assertEquals("", outContent.toString());
    }

    @Test
    void negativeNumber() {
        FibonacciRec_FaultDetect.main(new String[]{"-1"});
        assertEquals("", outContent.toString());
    }

    @Test
    void validInput(){
        FibonacciRec_FaultDetect fib = new FibonacciRec_FaultDetect(35);
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }

    @Test
    void outOfRangeInput() {
        FibonacciRec_FaultDetect.main(new String[]{"50"});
        assertEquals("", outContent.toString());
    }
}