package exercises;

import java.math.BigInteger;

/*
# Algorithm:  Ackermann (x, y):
        # Input:      natuerliche Zahlen x, y
        # Output:     Funktionswert

        if      y = 0 then 0
        else if x = 0 then 2*y
        else if y = 1 then 2
        else
        Ackermann(x-1, Ackermann(x, y-1))
        fi

 */

/*
    2)
    Ergebnis von ackermann für 3,3: 65536
    Ergebnis von ackermann für 2,4: 65536
    Ergebnis von ackermann für 1,10: 1024

    3) Der Speicher ist sehr schnell ausgeschöpft, also tritt ein StackOverflowError auf

*/


public class AckermannFunction {
    /*
    public static int ackermann(int x, int y){
        if (y==0) return 0;
        else if (x==0) return 2*y;
        else if (y==1) return 2;
        else return ackermann(x-1, ackermann(x,y-1));
    }
    */

    public static BigInteger ackermann(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        else if (x.equals(BigInteger.ZERO)) return y.multiply(BigInteger.TWO);
        else if (y.equals(BigInteger.ONE)) return BigInteger.TWO;
        else return ackermann(x.subtract(BigInteger.ONE), ackermann(x, y.subtract(BigInteger.ONE)));

    }


    public static void main(String[] args) {
        /*
        System.out.println("Ergebnis von ackermann für 3,3: " + ackermann(3,3));
        System.out.println("Ergebnis von ackermann für 2,4: " + ackermann(2,4));
        System.out.println("Ergebnis von ackermann für 1,10: " + ackermann(1,10));
        */

        BigInteger x = BigInteger.valueOf(1);
        BigInteger y = BigInteger.valueOf(5);
        System.out.println(ackermann(x, y));


    }

}
