import Exceptions.NegativeNumberException;
import Exceptions.NotANumberException;
import Exceptions.ValueOutOfRangeException;

public class FibonacciIter_Long {
    static long upperBound = 92;

    public static void main(String[] args) {
        if (args.length > 0){
            try {
                if(!args[0].matches("-?(0|[1-9]\\d*)"))
                    throw new NotANumberException("The input number has to be numerical");
                long input = Long.parseLong(args[0]);
                if (input < 0)
                    throw new NegativeNumberException("Input cannot be a negative number");
                if(input > upperBound)
                    throw new ValueOutOfRangeException("The input cannot be greater than 46.");
                FibonacciIter_Long f = new FibonacciIter_Long(input);
            } catch (NegativeNumberException e) {
                System.out.println("The input value cannot be a negative number!");
            } catch (ValueOutOfRangeException e) {
                System.out.println("The input value cannot be greater than " + upperBound +"!");
            } catch (NotANumberException e) {
                System.out.println("The input value has to be numerical!");
            } catch (NumberFormatException nfe){
                System.out.println("The input has to be an integer value.");
            }
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
    public FibonacciIter_Long(long n){
        System.out.println("F("+ n + ") = " + fibonacci(n));
    }
    private long fibonacci(long n){
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
