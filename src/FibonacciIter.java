
public class FibonacciIter {

    public static void main(String[] args) {
        if (args.length > 0) {
            FibonacciIter f = new FibonacciIter(Integer.parseInt(args[0]));
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
    public FibonacciIter(int n){
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
