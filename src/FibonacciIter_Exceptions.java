import Exceptions.NegativeNumberException;
import Exceptions.NotANumberException;
import Exceptions.ValueOutOfRangeException;

public class FibonacciIter_Exceptions {

    public static void main(String[] args) throws ValueOutOfRangeException, NegativeNumberException, NotANumberException {
        if (args.length > 0) {
            if (!args[0].matches("-?(0|[1-9]\\d*)"))
                throw new NotANumberException("The input number has to be numerical");
            int input = Integer.parseInt(args[0]);
            if (input < 0)
                throw new NegativeNumberException("Input cannot be a negative number");
            if (input > 46)
                throw new ValueOutOfRangeException("The input cannot be greater than 46.");
            FibonacciIter_FaultDetect f = new FibonacciIter_FaultDetect(input);
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
    public FibonacciIter_Exceptions(int n){
        System.out.println("F("+ n + ") = " + fibonacci(n));
    }
    private int fibonacci(int n){
        //iterative algorithm
        if(n == 0) return 0;
        else if (n == 1) return 1;
        else {
            int fibEven = 0;
            int fibOdd = 1;
            int result = 1;
            for (int i = 1; i <= n; i++){
                result = fibEven + fibOdd;
                if (i % 2 == 1)
                    fibOdd = result;
                else
                    fibEven = result;
            }
            return result;
        }
    }
}
