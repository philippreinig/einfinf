package Archive.Tutorium;

public class Factorization {

    public static double Pi(double n) {

        double x = 0, y, z, zähler = 0;
        double pi;
        double min = 0, max = 1;
        double versuche = n;

        for (int k = 0; k < versuche; k++) {

            x = Math.random() * (max - min) + min;
            y = Math.random() * (max - min) + min;
            System.out.println(Math.random());

            z = x * x + y * y;

            if (z < 1) {
                zähler = zähler + 1;
            }
        }
        //Schleife die zählt wie oft z < 1 ist
        pi = zähler / versuche;
        return pi;
    }

    public static int Zonk(int n) {
        int versuche = n;
        double siegeWechsel = 0;

        for (int p = 0; p < versuche; p++) {
            int preis = (int) (3 * Math.random());
            int wahl = (int) (3 * Math.random());
            int zeigen;

            do {
                zeigen = (int) (3 * Math.random());
            } while ((zeigen == wahl) || (zeigen == preis));
            //Die Schleife wird so oft wiederholt bis die variable zeigen den dritten Wert hat

            int rest = 0 + 1 + 2 - zeigen - wahl;
            if (rest == preis) siegeWechsel++;
        }
        System.out.println("Wenn man nicht wechselt ist die Wahrscheinlichkeit zu gewinnen: " + (1 - siegeWechsel / versuche) + "%");
        System.out.println("Wenn man wechselt ist die Wahrscheinlichkeit zu gewinnen: " + (siegeWechsel / versuche) + "%");
        return n;
        //System.out.println("Beim Tor geblieben:"+stehenwin);
        //System.out.println("Das Tor gewechsel:"+wechselwin);

    }

    public static double WürfelFünfen(int n) {
        int anzahltreffer = 0;
        double ergebnis = 0;
        int i = 0, letztertreffer = 0;
        int[] treffer = new int[n];
        double summe = 0;
        int[] würfel = new int[1];
        int w1, w2 = 0;


        for (int versuche = 1; anzahltreffer < n; versuche++) {

            w1 = (int) ((Math.random() * 6.0) + 1);

            if (versuche == 1) {
                w2 = (int) ((Math.random() * 6.0) + 1);
            }

            if (w1 == w2 && w1 == 5) {
                treffer[i] = versuche - letztertreffer; //fehler
                anzahltreffer++;
                letztertreffer = versuche;
                i++;
            } //aufschreiben der Zahl wo beide Augenzahlen 5 waren

            if (anzahltreffer == n) {
                for (int l = 0; l < treffer.length; l++) {
                    summe = summe + treffer[l];
                }
                //Addition der Ergebnisse
                ergebnis = summe / n;
                return ergebnis;
            }
            w2 = w1;
        }
        return 0;
    }

    public static double WürfelReihenfolge(int n) {
        int anzahltreffer = 0;
        double ergebnis = 0;
        int test = 10, i = 0, letztertreffer = 0;
        int[] treffer = new int[n];
        double summe = 0;
        int w1, w2 = 0;


        for (int versuche = 1; anzahltreffer < n; versuche++) {
            w1 = (int) ((Math.random() * 6.0) + 1);

            if (versuche == 1) {
                w2 = (int) ((Math.random() * 6.0) + 1);
            }
            if (w1 == 5 && w2 == 6) {
                treffer[i] = versuche - letztertreffer; //fehler
                anzahltreffer++;
                letztertreffer = versuche;
                i++;
            } //aufschreiben der Zahl wo beide Augenzahlen 5 waren

            if (anzahltreffer == n) {
                for (int j : treffer) {
                    summe = summe + j;
                }
                ergebnis = summe / n;
                System.out.println(ergebnis);
                return ergebnis;
            } //Beenden der Methode, wenn 50 mal beide Augenzahlen 5 waren
            w2 = w1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = args[0];
        int versuche;
        try {
            versuche = Integer.parseInt(args[1]); // setzen der Variable
        } catch (NumberFormatException nfe) {
            System.out.println("Ihr zweites Argument ist keine Zahl.");
            return;
        }
        //Testet ob das zweite Argument eine Zahl ist - abbruch wenn nicht.
        if (str.equals("MonteCarlo") || str.equals("Pi") || str.equals("pi") || str.equals("PI")) {
            double pi = Pi(versuche);
            System.out.println("Pi lautet ungefähr: " + (pi * 4));

        } else if (str.equals("Zonk") || str.equals("zonk") || str.equals("Ziegenproblem") || str.equals("ziegenproblem")) {
            Zonk(versuche);

        } else if (str.equals("Würfel") || str.equals("5und5") || str.equals("würfel") || str.equals("gleich")) {
            double würfelErgebnis = WürfelFünfen(versuche);
            System.out.println("Es hat im Schnitt " + würfelErgebnis + " Versuche gebraucht um zweimal in Folge eine 5 zu würfeln.");

        } else if (str.equals("Reihenfolge") || str.equals("reihenfolge") || str.equals("5und6") || str.equals("würfelreihenfolge")) {
            double reihenfolgeErgebnis = WürfelReihenfolge(versuche);
            System.out.println("Um eine 5 und dann eine 6 zu würfeln hat es im Schnitt: " + reihenfolgeErgebnis + " gedauert.");

        } else {
            System.out.println("Eingabe wurde nicht erkannt");
        }
    }
}
