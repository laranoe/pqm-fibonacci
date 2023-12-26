
public class FibonacciRec {

    public static void main(String[] args) {
        if (args.length > 0){
                FibonacciRec f = new FibonacciRec(Integer.parseInt(args[0]));
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
    public FibonacciRec(int n){
        System.out.println("F("+ n + ") = " + fibonacci(n));
    }
    private long fibonacci(int n){
        //recursive algorithm
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }
}
