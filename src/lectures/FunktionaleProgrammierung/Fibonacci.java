package lectures.FunktionaleProgrammierung;

public class Fibonacci {
    static int counterRec = 0;
    static int counterRecOptimized = 0;

    static int fibonacciRec(int x) {
        counterRec++;
        if (x == 0) return 0;
        else if (x == 1) return 1;
        else return fibonacciRec(x - 1) + fibonacciRec(x - 2);
    }

    static int fibonacciRecOptimized(int x) {
        counterRecOptimized++;
        if (x == 0) return 0;
        else if (x == 1) return 1;
        else return fibonacciRecOptimized(x, 0, 1);
    }

    static int fibonacciRecOptimized(int x, int y, int z) {
        counterRecOptimized++;
        if (x == 2) return y + z;
        else return fibonacciRecOptimized(x - 1, z, y + z);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciRec(100));
        System.out.println(counterRec);
        System.out.println("---");
        System.out.println(fibonacciRecOptimized(100));
        System.out.println(counterRecOptimized);

    }
}

