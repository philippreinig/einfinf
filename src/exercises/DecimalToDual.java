package exercises;

import java.util.Random;

public class DecimalToDual {
    public static String transformDual(int dec) {
        String str = "";

        //return 0, wenn Eingabe == 0
        if (dec == 0) {
            return "0";
        }

        //String mit Zahl in umgekehrter binärer Darstellung des eingegebenen Integers erstellen
        while (dec > 0) {
            str += dec % 2;
            dec /= 2;
        }

        //String umkehren für richtige Reihenfolge der binären Darstellung
        return stringUmkehren(str);
    }

    //Gibt einen String mit umgekehrter Reihenfolge der enthaltenen Zeichen wieder
    public static String stringUmkehren(String str) {
        String str_copy = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str_copy += str.charAt(i);
        }
        return str_copy;
    }

    //Erstellt binäre Darstellung mit der Standardmethode Integer.toBinaryString()
    public static String test(int dec) {
        return Integer.toBinaryString(dec);
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Bitte genau eine Zahl übergeben!");
                return;
            }
            int entry = Integer.parseInt(args[0]);
            System.out.println(entry + " in binärer Darstellung ist " + transformDual(entry));
        } catch (NumberFormatException nfe) {
            System.out.println("Ungülitge Eingabe! Bitte nur positive ganze Zahlen oder 0 eingeben!");
            return;
        }

        ///Testen

        //Festlegung von Variablen zum Testen
        int testvorgänge = 126345;   //Anzahl der Testvorgänge
        int max = 1567823;           //Obere Grenze des Testintervalls
        int min = 0;                 //Untere Grenze des Testintervalls

        int counter = 0;

        Random random = new Random();

        for (int i = 0; i < testvorgänge; i++) {
            //Zufällige Generierung einer Zahl aus dem Testintervall
            int x = random.nextInt(max - min) + min;

            //Ausgabe wenn eine Abweichung von den Ergebnissen der Methoden transformDual zur Testmethode gefunden wurde und Abbruch
            if (!(transformDual(x).equals(test(x)))) {
                System.out.println("Fehler gefunden! Keine Übereinstimmung bei " + x);
                System.out.println("Ergebnis der Methode transformDual: " + transformDual(x));
                System.out.println("Ergebnis der Methode test: " + test(x));
                System.out.println(counter + " von " + testvorgänge + " Testvorgängen wurden erfolgreich durchlaufen");
                return;
            }
            counter++;
        }

        //Test erfolgreich
        System.out.println("Alle Tests " + "(" + counter + " von " + testvorgänge + ")" + " erfolgreich durchlaufen!");
    }
}
