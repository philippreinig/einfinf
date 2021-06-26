package tutorium;

import java.util.Arrays;

import static java.lang.Thread.sleep;

public class GameOfLife {
    //Generierung eines 2-dimensionalen Arrays für das Spielfeld
    public static int[][] generierungSpielfeld(int laenge, double wahrscheinlichkeit) {
        int[][] spielfeld = new int[laenge][laenge];
        for (int x = 0; x < laenge; x++) {
            for (int y = 0; y < laenge; y++) {
                if ((Math.random() * (0.99) + 0.01) < wahrscheinlichkeit) { //Belegung der Felder mit gegebener Wahrscheinlichkeit
                    spielfeld[x][y] = 1;
                } else {
                    spielfeld[x][y] = 0;
                }
            }
        }
        return spielfeld;
    }

    //Ausgeben des Zustands aller Zellen durch Iteration über alle Koordinaten x,y
    public static void aktuellenZustandAusgeben(int[][] spielfeld) {
        for (int x = 0; x < spielfeld.length; x++) {
            for (int y = 0; y < spielfeld.length; y++) {
                System.out.print(spielfeld[x][y] + " ");
            }
            System.out.println();
        }
    }

    //Anwendung der 4 Regeln des Spiels zur Berechnung der nächsten Generation
    public static int[][] aenderung(int[][] spielfeld) {
        int[][] copySpielfeld = Arrays.copyOf(spielfeld, spielfeld.length);
        for (int x = 0; x < spielfeld.length; x++) {        //Iteration über gesamtes Spielfeld
            for (int y = 0; y < spielfeld.length; y++) {
                int anzahlNachbarn = anzahlDerNachbarn(spielfeld, x, y);        //Abfrage der Anzahl der Nachbarn der Zelle
                //Regel 1: Vereinsamung
                if ((spielfeld[x][y] == 1) && (anzahlNachbarn < 2)) {
                    copySpielfeld[x][y] = 0;

                    //Regel 2: Nahrungsmangel
                } else if ((spielfeld[x][y] == 1) && (anzahlNachbarn > 3)) {
                    copySpielfeld[x][y] = 0;

                    //Regel 3: Reproduktion
                } else if ((spielfeld[x][y] == 0) && (anzahlNachbarn == 3)) {
                    copySpielfeld[x][y] = 1;

                    //Regel 4: Zustand beibehalten
                } else {
                    //copySpielfeld[x][y]=spielfeld[x][y];
                }
            }
        }
        return copySpielfeld;
    }

    //Berechnung der Anzahl der Nachbarn
    public static int anzahlDerNachbarn(int[][] spielfeld, int x, int y) {
        int nachbarn = 0;
        nachbarn -= spielfeld[x][y];      //Ignorieren der eigenen Zellen

        for (int i = -1; i <= 1; i++) {         //Iteration über alle möglichen Nachbarn
            for (int j = -1; j <= 1; j++) {
                try {       //Abfangen einer ArrayIndexOutOfBoundsException
                    if (spielfeld[(x + i)][(y + j)] == 1) {
                        nachbarn++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        return nachbarn;
    }

    //Durchführung des Spiels
    public static void main(String[] args) {
        //Generierung des Spielfelds zu Beginn
        int[][] spielfeld = generierungSpielfeld(Integer.parseInt(args[0]), Double.parseDouble(args[1]));
        aktuellenZustandAusgeben(spielfeld);

        //Endloser Ablauf des Spiels
        for (int x = 1; true; x++) {
            spielfeld = aenderung(spielfeld); //Berechnung der nächsten Generation

            System.out.println("----- Generation: " + x + " -----");
            aktuellenZustandAusgeben(spielfeld);//Ausgabe der aktuellen Generation


            try {
                sleep(1000);            //Verzögerung des Programms, als zeitlicher Ablauf des Spiels
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
