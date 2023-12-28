import java.util.ArrayList;
import java.util.List;

public class FibonacciIter_FaultDetect {

    private static final double PHI = (1 + Math.sqrt(5)) / 2;

    // n is fibonacci number, x is number of bytes
    public static int iterativeFunction(String input, int x) {
        int n;
        if (isValidNumber(input)) {
            if (isInteger(input)) {
                n = Integer.parseInt(input);
                if(n >= 0 && x > 0){
                    final int UPPER_BOUND = (int) Math.floor((x * 8 - 1) * (Math.log(2) / Math.log(PHI)) +
                            0.5 * (Math.log(5) / Math.log(PHI)));
                    if (n <= UPPER_BOUND) {
                        List<Integer> sequenceList = new ArrayList<>();
                        sequenceList.add(0);
                        sequenceList.add(1);

                        for (int i = 2; i <= n; i++) {
                            sequenceList.add(sequenceList.get(i - 1) + sequenceList.get(i - 2));
                        }
                        return sequenceList.get(sequenceList.size()-1);
                    }
                }
            }
        }
        return -1; // return -1 if fibonacci cannot be calculated
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
        int x = 4;  // Define maximum number of bytes (Integer = 4)

        if (args.length > 0){
            int result = iterativeFunction(args[0], x);
            if(result >= 0)
                System.out.println("F("+args[0]+") = "+ result);
        }
        else {
            System.out.println("use syntax: java FibonacciIter_FaultDetect n");
        }
    }
}
