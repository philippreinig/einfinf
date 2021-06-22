package Archive.exercises;

import java.util.Arrays;
import java.util.Random;

public class MedianOfThree {

    // 1. Methode, um den Median der 3 Zahlen zu finden
    public static int median(int a, int b, int c) {
        int num1 = 0, num2 = 0, num3 = 0;

        //Sortierung der 3 Zahlen in aufsteigender Reihenfolge durch alle 6 möglichen Vergleichskombinationen
        if ((a <= b) && (b <= c)) {          // a < b < c
            num1 = a;
            num2 = b;
            num3 = c;
        }

        if ((a <= c) && (c <= b)) {          // a < c < b
            num1 = a;
            num2 = c;
            num3 = b;
        }

        if ((b <= a) && (a <= c)) {          // b < a < c
            num1 = b;
            num2 = a;
            num3 = c;
        }

        if ((b <= c) && (c <= a)) {          // b < c < a
            num1 = b;
            num2 = c;
            num3 = a;
        }

        if ((c <= a) && (a <= b)) {          // c < a < b
            num1 = c;
            num2 = a;
            num3 = b;
        }

        if ((c <= b) && (b <= a)) {          // c < b < a
            num1 = c;
            num2 = b;
            num3 = a;
        }

        //Rückgabe der 2-ten, also "mittleren" der 3 Zahlen
        return num2;

    }

    //2. Methode, um Median der 3 Zahlen zu finden
    public static int median2(int a, int b, int c) {
        int num1, num2, num3;

        //Sortierung der 3 Zahlen in aufsteigender Reihenfolge, indem zunächst a und b verglichen wird und c anschließend an die passende Stelle gefügt wird
        if (a <= b) {                      // a < b
            num1 = a;
            num2 = b;
            if (c < a) {                   // c < a < b
                num1 = c;
                num2 = a;
                num3 = b;
            } else if (c >= a && c <= b) {    // a < c < b
                num2 = c;
                num3 = b;
            } else {                      // a < b < c
                num3 = c;
            }
        } else {                          // b < a
            num1 = b;
            num2 = a;
            if (c < b) {                   // c < b < a
                num1 = c;
                num2 = b;
                num3 = a;
            } else if (c >= b && c <= a) {    // b < c < a
                num2 = c;
                num3 = a;
            } else {                      // b < a < c
                num3 = c;
            }
        }

        //Rückgabe der 2-ten, also "mittleren" der 3 Zahlen
        return num2;
    }

    //Testmethode, die sicher den Median der 3 Zahlen zurückgibt
    public static int test(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);

        return array[1];
    }

    public static void main(String[] args) {
        //Abfangen von Fehlern
        try {
            //Abbruch, wenn nicht genau 3 Zahlen übergeben wurden
            if (args.length != 3) {
                System.out.println("Bitte genau 3 Zahlen übergeben!");
                return;
            }

            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            System.out.println("Median: Der Median von " + a + "," + b + "," + c + " ist: " + median(a, b, c));
            System.out.println("Median2: Der Median von " + a + "," + b + "," + c + " ist: " + median2(a, b, c));

            //Abbruch, wenn ungültige Eingaben enthalten sind
        } catch (NumberFormatException nfe) {
            System.out.println("Ungültige Eingabe! Bitte nur ganze Zahlen übergeben!");
            return;

        }

        //Testen der Methoden median und median2

        //Festlegung von Variablen zum Testen
        int testvorgänge = 100000;          //Anzahl der Testvorgänge
        int max = 100;                      //Obere Grenze des Testintervalls
        int min = -100;                     //Untere Grenze des Testintervalls

        Random random = new Random();

        for (int i = 0; i < testvorgänge; i++) {
            //Zufällige Generierung von 3 Zahlen aus dem Testintervall
            int x = random.nextInt(max - min) + min;
            int y = random.nextInt(max - min) + min;
            int z = random.nextInt(max - min) + min;

            //Ausgabe wenn eine Abweichung von den Ergebnissen der Methoden median1 bzw. median2 zur Testmethode gefunden wurde und Abbruch
            if ((median(x, y, z) != test(x, y, z)) || (median2(x, y, z) != test(x, y, z))) {
                System.out.println("Fehler gefunden! x: " + x + "y: " + y + "z: " + z);
                return;
            }
        }

        //Test erfolgreich
        System.out.println("Alle Tests erfolgreich durchlaufen!");
    }
}
