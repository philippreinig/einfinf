package tutorium;

import java.util.HashMap;

public class Statistics {
    public static void main(String[] args) {


        //Initialisierung von Variablen für spätere Berechnungen und Ergebnisse
        int sum = 0;
        float average = 0;
        float variance = 0;
        float probability = 1f / args.length;
        int number;


        //Fehler abfangen, wenn ungültige Eingaben enthalten sind
        for (int t = 0; t < args.length; t++) {
            try {
                number = Integer.parseInt(args[t]); //
            } catch (NumberFormatException nfe) {
                System.out.println("Fehlerhafte Eingabe! Bitte nur ganze Zahlen eingeben!");
                return;
            }
        }

        System.out.println(args.length);

        //Summe und Mittelwert berechnen
        for (int i = 0; i < args.length; i++) {
            ///System.out.println("Eingabeparameter " + i + " ist: " + args[i]);
            int entry = Integer.parseInt(args[i]);
            sum += entry;
            average += probability * entry;
        }

        //Varianz berechnen
        for (int i = 0; i < args.length; i++) {
            int entry = Integer.parseInt(args[i]);
            variance += Math.pow((entry - average), 2) * probability;

        }

        //Standardabweichung berechnen
        float standard_deviation = (float) Math.sqrt(variance);

        //Berechnete Werte ausgeben
        System.out.println("Summe: " + sum);
        System.out.println("Mittelwert: " + average);
        System.out.println("Varianz: " + variance);
        System.out.println("Standardabweichung: " + standard_deviation);


        //HashMap erstellen, die die Anzahl der Zahlen im Array enthält
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        for (int i = 0; i < args.length; i++) {
            int element = Integer.parseInt(args[i]);
            //System.out.println(element);
            if (histogram.containsKey(element)) {
                histogram.replace(element, histogram.get(element) + 1);
            } else {
                histogram.put(element, 1);
            }
        }
        System.out.println(histogram);

        //Gibt Sterne für die Anzahl der Zahlen aus
        System.out.println(histogram.keySet());
        for (int i : histogram.keySet()) {
            System.out.print(i + ":");
            for (int x = 0; x < histogram.get(i); x++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
