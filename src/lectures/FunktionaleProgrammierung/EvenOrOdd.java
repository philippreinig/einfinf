package lectures.FunktionaleProgrammierung;

public class EvenOrOdd {
    static boolean even(int x) {
        System.out.println("even: " + x);
        if (x == 0) return true;
        else if (x > 0) return odd(x - 1);
        else return odd(x + 1);
    }

    static boolean odd(int x) {
        System.out.println("odd: " + x);
        if (x == 0) return false;
        else if (x > 0) return even(x - 1);
        else return even(x + 1);
    }

    public static void main(String[] args) {
        System.out.println(even(-100));
    }
}

/*
How this recursive algorithm works:
1. Function calls for odd and even are alternating
2. The algorithm will always terminate with a function call of either even(0) or odd(0)
3. even(0) -> true, odd(0) -> false
4. If even(0) is the last function call the number has to be even, since the algorithm has to have started with an even number
 otherwise if odd(0) is the last function call the algorithm has to have started with an odd number
5. Evaluation:
    - Started with even number and function call even() -> true
    - Started with an odd number and function call even() -> false
    - Started with an even number and function call odd() -> false
    - Started with an odd number and function call odd() -> true


 */