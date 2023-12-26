public class FibonacciRec_FaultDetect {
    public static void main(String[] args) {
        if (args.length > 0){
            if(args[0].matches("-?(0|[1-9]\\d*)")) { //check if input is numerical
                int input = Integer.parseInt(args[0]);
                if (input >= 0 && input <= 46) {
                    FibonacciRec_FaultDetect f = new FibonacciRec_FaultDetect(input);
                }
            }
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
    public FibonacciRec_FaultDetect(int n){
        System.out.println("F("+ n + ") = " + fibonacci(n));
    }
    private int fibonacci(int n){
        //recursive algorithm
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }
}
