import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIter_FaultDetectTest {

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
        assertEquals(-1, FibonacciIter_FaultDetect.iterativeFunction("test", x));
    }

    @Test
    void iterativeFunction_negativeValue() {
        assertEquals(-1, FibonacciIter_FaultDetect.iterativeFunction("-1", x));
    }

    @Test
    void iterativeFunction_validValue() {
        assertEquals(9227465, FibonacciIter_FaultDetect.iterativeFunction("35", x));
    }

    @Test
    void iterativeFunction_outOfRangeValue() {
        assertEquals(-1, FibonacciIter_FaultDetect.iterativeFunction("50", x));
    }

    @Test
    void iterativeFunction_nonIntegerValue() {
        assertEquals(-1, FibonacciIter_FaultDetect.iterativeFunction("3000000000", x));
    }

    @Test
    void main_StringValue() {
        FibonacciIter_FaultDetect.main(new String[]{"test"});
        assertEquals("", outContent.toString());
    }

    @Test
    void main_negativeNumber() {
        FibonacciIter_FaultDetect.main(new String[]{"-1"});
        assertEquals("", outContent.toString());
    }
    @Test
    void main_validValue(){
        FibonacciIter_FaultDetect.main(new String[]{"35"});
        assertEquals("F(35) = 9227465\n", outContent.toString());
    }
    @Test
    void main_outOfRangeValue() {
        FibonacciIter_FaultDetect.main(new String[]{"50"});
        assertEquals("", outContent.toString());
    }
    @Test
    void main_nonIntegerValue() {
        FibonacciIter_FaultDetect.main(new String[]{"3000000000"});
        assertEquals("", outContent.toString());
    }
}