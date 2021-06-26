package lectures.FunktionaleProgrammierung;

import static lectures.FunktionaleProgrammierung.BasicArithmetic.succ;

public class Prime {
    static int counter = 0;
    static int counterOptimized = 0;

    static boolean isPrime(int x) {
        counter++;
        if (x < 2) return false;
        else return divisible(x, 2);
    }

    static boolean isPrimeOptimized(int x) {
        counterOptimized++;
        if (x < 2) return false;
        else return divisibleOptimized(x, 2);
    }

    static boolean divisible(int x, int y) {
        counter++;
        if (y == x) return true;
        if (y > x) return false;
        else return (x % y != 0 && divisible(x, succ(y)));
    }


    static boolean divisibleOptimized(int x, int y) {
        counterOptimized++;
        if (Math.pow(y, 2) > x) return true;
        else if (y == 2) return x % 2 != 0 && divisibleOptimized(x, 3);
        else return x % y != 0 && divisibleOptimized(x, y + 2);
    }

    public static void main(String[] args) {
        //Comparing speed
        System.out.println(isPrime(25));
        System.out.println(counter);

        System.out.println(isPrimeOptimized(25));
        System.out.println(counterOptimized);

    }
}
