import java.util.ArrayList;
import java.util.List;

public class FibonacciIter_ErrorChecks {

    private static final double PHI = (1 + Math.sqrt(5)) / 2;

    public static class InvalidInputError extends RuntimeException {
        public InvalidInputError(String message) {
            super(message);
        }
    }

    public static class FibonacciUpperBoundError extends RuntimeException {
        public FibonacciUpperBoundError(String message) {
            super(message);
        }
    }

    // n is fibonacci number, x is number of bytes
    public static int iterativeFunction(String input, int x) {
        int n;
        if (!isValidNumber(input)) {
            throw new InvalidInputError("Inputs must be valid numbers.");
        }
        else {
            if (!isInteger(input)) {
                throw new InvalidInputError("Inputs must be integers.");
            }
            else {
                n = Integer.parseInt(input);
            }
        }

        if (n < 0 || x < 0) {
            throw new InvalidInputError("Inputs must be non-negative numbers.");
        }

        final int UPPER_BOUND = (int) Math.floor((x * 8 - 1) * (Math.log(2) / Math.log(PHI)) +
                0.5 * (Math.log(5) / Math.log(PHI)));

        if (n > UPPER_BOUND) {
            throw new FibonacciUpperBoundError("Input exceeds the upper bound for Fibonacci numbers. " +
                    "Maximum allowed value is " + UPPER_BOUND + ".");
        }

        List<Integer> sequenceList = new ArrayList<>();
        sequenceList.add(0);
        sequenceList.add(1);

        for (int i = 2; i <= n; i++) {
            sequenceList.add(sequenceList.get(i - 1) + sequenceList.get(i - 2));
        }

        return sequenceList.get(sequenceList.size()-1);
    }

    private static boolean isValidNumber(String value) {
        return value.matches("-?(0|[1-9]\\d*)");
    }

    private static boolean isInteger(String value) {
        try{
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static void main(String[] args) {
        int x = 4;  // Define maximum number of bytes (Integer = 4; Long = 8)

        if (args.length > 0){
            int result = iterativeFunction(args[0], x);
            System.out.println("F("+args[0]+") = "+ result);
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
}
