package Archive.Vorlesung;

public class PrimeTester {

    /**
     * Diese Methode testet, ob die übergebene Zahl n eine Primzahl ist.
     *
     * @param n Die zu überprüfende Zahl
     * @return true genau dann wenn n eine Primzahl ist.
     */
    public static boolean isPrime(int n) {

        // 1 und alle Zahlen kleiner als 1 sind keine Primzahlen
        if (n <= 1) {
            return false;
        }

        // 2 ist eine Primzahl
        if (n == 2) {
            return true;
        }

        // Alle geraden Zahlen > 2 sind keine Primzahlen
        if (n % 2 == 0) {
            return false;
        }

        // Es brauchen nur ungerade Zahlen als Teiler getestet werden,
        // also starten wir bei 3 und erhöhen in Zweierschritten.
        // Außerdem brauchen wir nur bis Wurzel(n) testen, da von einem
        // Teilerpaar (a,b) mit a*b = n immer eine der beiden Zahlen a,b
        // kleiner oder gleich Wurzel(n) sein muss.
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) { // n ist ohne rest durch i teilbar, also nicht prim
                return false;
            }
        }

        // Wenn wir bis hier gekommen sind, haben wir keine Teiler für n gefunden
        return true;
    }

    public static void main(String[] args) {
        // Prüfe auf die richtige Anzahl von Kommandozeilenparametern
        if (args.length != 1) {
            System.err.println("Bitte genau einen Parameter angeben!");
            System.exit(-1);
        }

        try {
            // Wandle den ersten Kommandozeilenparameter in einen int um
            int zahl = Integer.parseInt(args[0]);

            // Prüfe ob zahl prim ist und gebe einen entsprechenden Text aus.
            if (isPrime(zahl)) {
                // printf nimmt als Argument einen Format-String und eine Liste von Parametern
                // %d wird für Dezimalzahlen verwendet
                // %f wird für Fließkommazahlen verwendet,
                //          z.B. %2.4f gibt eine Fließkommazahl mit 2 Stellen vor und 4 Stellen nach dem Komma aus
                // %s wird für Strings verwendet,
                //          z.B. %15s füllt den String von links mit Leerzeichen auf, bis er 15 Zeichen lang ist
                // %n erzeugt einen Zeilenumbruch
                System.out.printf("%d ist eine Primzahl.%n", zahl);
            } else {
                System.out.printf("%d ist KEINE Primzahl.%n", zahl);
            }

            // Kommandozeilenparameter lässt sich nicht in eine Zahl umwandeln
        } catch (NumberFormatException exception) {
            System.err.printf("Der eingegebene Parameter '%s' konnte nicht in eine Zahl umgewandelt werden.", args[0]);
            System.exit(-1);
        }
    }
}