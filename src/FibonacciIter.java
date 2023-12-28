import java.util.ArrayList;
import java.util.List;

public class FibonacciIter {
    public static int iterativeFunction(String input) {
        int n = Integer.parseInt(input);

        List<Integer> sequenceList = new ArrayList<>();
        sequenceList.add(0);
        sequenceList.add(1);

        for (int i = 2; i <= n; i++) {
            sequenceList.add(sequenceList.get(i - 1) + sequenceList.get(i - 2));
        }
        return sequenceList.get(sequenceList.size()-1);
    }

    public static void main(String[] args) {
        if (args.length > 0){
            int result = iterativeFunction(args[0]);
            System.out.println("Fib("+args[0]+") = "+ result);
        }
        else {
            System.out.println("use syntax: java FibonacciIter n");
        }
    }
}

