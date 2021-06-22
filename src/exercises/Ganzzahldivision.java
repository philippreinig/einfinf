package Archive.exercises;

public class Ganzzahldivision {
    public static void main(String[] args) {
        int dividend = 4;
        int divisor = 2;
        int quotient = 0;
        int remainder = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }
        //Resetting the value of dividend and calculating remainder for console output
        if (dividend == 0) {
            dividend = divisor * quotient;
        } else {
            remainder = divisor - dividend;
            dividend = divisor * quotient + remainder;
        }
        System.out.println(dividend + " divided by " + divisor + " equals " + quotient + " with the remainder of " + remainder);

    }
}

/*
Erklärung:
Der Divisor wird mittels einer Schleife so oft vom Dividenden subtrahiert und die Male gezählt, bis der Dividend kleiner als der Divisor ist. Die Male, die die Schleife abläuft entspricht dem Quotienten.
Ist der Dividend kleiner als der Divisor bricht die Schleife ab. Der Wert des Dividenden stellt den Rest dar.
Zum Beispiel: 5/2
5-2=3
3-2=1
1<2 -> Schleife beendet
2 Substraktionen benötigt, d.h. Quotient = 2 und der Rest beträgt 1

Der Algorithmus muss terminieren, da bei zwei natürlichen Zahlen eine endlichen Anzahl an Subtraktionen genügt, bis der Wert des Dividenden geringer als der des Divisors ist.
*/
