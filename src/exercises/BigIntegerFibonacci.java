package Archive.exercises;

/*
 Fibonaccizahl Nr. 1: 1, Anzahl der benötigten Durchgänge der Methode zur Berechnung: 1
 Fibonaccizahl Nr. 2: 1, Anzahl der benötigten Durchgänge der Methode zur Berechnung: 2
 Fibonaccizahl Nr. 3: 2, Anzahl der benötigten Durchgänge der Methode zur Berechnung: 5
 Fibonaccizahl Nr. 4: 3, Anzahl der benötigten Durchgänge der Methode zur Berechnung: 10
 Fibonaccizahl Nr. 5: 5, Anzahl der benötigten Durchgänge der Methode zur Berechnung: 19

 */
/*
# Algorithm:  fib (x):
        # Input:      natuerliche Zahlen x
        # Output:     Fibonacci-Zahl

        if x = 0 or x = 1
        then:
        else fib(x-2) + fib(x-1)
        fi
 */

import java.math.BigInteger;

public class BigIntegerFibonacci {
    public static int counter = 0;
    public static int counter2 = 0;

    //Rekursive Berechnung der Fibonaccifolge
    public static BigInteger fib1(int n) {
        counter++;
        if ((n == 0) || (n == 1)) return BigInteger.ONE;
        else return ((fib1(n - 1).add(fib1(n - 2))));

    }

    //Iterative Berechnung der Fibonaccifolge
    public static BigInteger fib2(int n) {

        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        BigInteger last = BigInteger.ONE;
        BigInteger current = BigInteger.TWO;
        for (int i = 2; i < n; i++) {
            BigInteger temp = last.add(current);
            last = current;
            current = temp;
            counter2++;
        }

        return current;
    }

    public static void main(String[] args) {
        //Erste n Fibonacci-Zahlen ausgeben:
        int n = 23;

        System.out.println("----Iterative Berechnung-----");
        for (int i = 0; i < n; i++) {
            System.out.println("Fibonaccizahl Nr. " + (i + 1) + ": " + fib2(i) + ", Benötigte Durchgänge: " + counter2);
            counter2 = 0;

        }

        System.out.println("-----Rekursive Berechnung-----");
        for (int i = 0; i < n; i++) {
            System.out.println("Fibonaccizahl Nr. " + (i + 1) + ": " + fib1(i) + ", Benötigte Durchgänge: " + counter);
        }
    }
}

/*
----Iterative Berechnung-----
Fibonaccizahl Nr. 1: 1, Benötigte Durchgänge: 0
Fibonaccizahl Nr. 2: 1, Benötigte Durchgänge: 0
Fibonaccizahl Nr. 3: 2, Benötigte Durchgänge: 0
Fibonaccizahl Nr. 4: 3, Benötigte Durchgänge: 1
Fibonaccizahl Nr. 5: 5, Benötigte Durchgänge: 2
Fibonaccizahl Nr. 6: 8, Benötigte Durchgänge: 3
Fibonaccizahl Nr. 7: 13, Benötigte Durchgänge: 4
Fibonaccizahl Nr. 8: 21, Benötigte Durchgänge: 5
Fibonaccizahl Nr. 9: 34, Benötigte Durchgänge: 6
Fibonaccizahl Nr. 10: 55, Benötigte Durchgänge: 7
Fibonaccizahl Nr. 11: 89, Benötigte Durchgänge: 8
Fibonaccizahl Nr. 12: 144, Benötigte Durchgänge: 9
Fibonaccizahl Nr. 13: 233, Benötigte Durchgänge: 10
Fibonaccizahl Nr. 14: 377, Benötigte Durchgänge: 11
Fibonaccizahl Nr. 15: 610, Benötigte Durchgänge: 12
Fibonaccizahl Nr. 16: 987, Benötigte Durchgänge: 13
Fibonaccizahl Nr. 17: 1597, Benötigte Durchgänge: 14
Fibonaccizahl Nr. 18: 2584, Benötigte Durchgänge: 15
Fibonaccizahl Nr. 19: 4181, Benötigte Durchgänge: 16
Fibonaccizahl Nr. 20: 6765, Benötigte Durchgänge: 17
Fibonaccizahl Nr. 21: 10946, Benötigte Durchgänge: 18
Fibonaccizahl Nr. 22: 17711, Benötigte Durchgänge: 19
Fibonaccizahl Nr. 23: 28657, Benötigte Durchgänge: 20
-----Rekursive Berechnung-----
Fibonaccizahl Nr. 1: 1, Benötigte Durchgänge: 1
Fibonaccizahl Nr. 2: 1, Benötigte Durchgänge: 2
Fibonaccizahl Nr. 3: 2, Benötigte Durchgänge: 5
Fibonaccizahl Nr. 4: 3, Benötigte Durchgänge: 10
Fibonaccizahl Nr. 5: 5, Benötigte Durchgänge: 19
Fibonaccizahl Nr. 6: 8, Benötigte Durchgänge: 34
Fibonaccizahl Nr. 7: 13, Benötigte Durchgänge: 59
Fibonaccizahl Nr. 8: 21, Benötigte Durchgänge: 100
Fibonaccizahl Nr. 9: 34, Benötigte Durchgänge: 167
Fibonaccizahl Nr. 10: 55, Benötigte Durchgänge: 276
Fibonaccizahl Nr. 11: 89, Benötigte Durchgänge: 453
Fibonaccizahl Nr. 12: 144, Benötigte Durchgänge: 740
Fibonaccizahl Nr. 13: 233, Benötigte Durchgänge: 1205
Fibonaccizahl Nr. 14: 377, Benötigte Durchgänge: 1958
Fibonaccizahl Nr. 15: 610, Benötigte Durchgänge: 3177
Fibonaccizahl Nr. 16: 987, Benötigte Durchgänge: 5150
Fibonaccizahl Nr. 17: 1597, Benötigte Durchgänge: 8343
Fibonaccizahl Nr. 18: 2584, Benötigte Durchgänge: 13510
Fibonaccizahl Nr. 19: 4181, Benötigte Durchgänge: 21871
Fibonaccizahl Nr. 20: 6765, Benötigte Durchgänge: 35400
Fibonaccizahl Nr. 21: 10946, Benötigte Durchgänge: 57291
Fibonaccizahl Nr. 22: 17711, Benötigte Durchgänge: 92712
Fibonaccizahl Nr. 23: 28657, Benötigte Durchgänge: 150025
 */