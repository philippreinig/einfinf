/*
# Algorithm:  marge(n)
        # Input:      n ganzzahlig, n>=0
        # Output:     ?
        if n = 0
        then 1
        else n - homer(marge(n - 1))
        fi

        # Algorithm:  homer(n)
        # Input:      n ganzzahlig, n>=0
        # Output:     ?
        if n = 0
        then 0
        else n - marge(homer(n - 1))
        fi

        # Algorithm:  dispute(n)
        # Input:      n ganzzahlig, n>=0
        # Output:     ?
                      not(marge(n) = homer(n))


*/

/*
    2)
    Die Algorithmen stellen eine extrem ineffiziente Methode zur rekursiven Berechnung der Fibonaccizahlenfolge dar.
    Um die ersten 10 Fibonaccizahlen auszurechnen werden die Methoden Marge und Homer 1.712.154.676-mal aufgerufen
    3)
    [true, true, true, false, true, false, false, true, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false]
    Wird der 0. Hochzeitstag mitgezählt, gibt es am 7. Hochzeitstag Streit, am 25. (Silberne Hochzeit) allerdings nicht.
    Marge und Homer verstehen sich über die Jahre besser, da die Differenz zweier Fibonaccizahlen im Verlauf der Folge steigt.


 */
package exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveFunction2 {

    public static int counter = 0;

    public static int marge(int n) {                //Implementierung des Algorithmus marge
        counter++;
        if (n == 0) return 1;
        else return n - homer(marge(n - 1));
    }

    public static int homer(int n) {                //Implementierung des Algorithmus homer
        counter++;
        if (n == 0) return 0;
        else return n - marge(homer(n - 1));
    }

    public static boolean dispute(int n) {          //Implementierung des Algorithmus dispute
        return !(marge(n) == homer(n));
    }

    public static boolean[] disputes(int amount) {  //Methode zur Ausgabe eines Boolean Arrays, das angibt ob am Hochzeitstag des Arrays-Index gestritten wird
        boolean[] disputes = new boolean[amount];
        for (int i = 0; i < amount; i++) {
            disputes[i] = dispute(i);
        }
        return disputes;

    }


    public static int[] differenceDisputes(int n) {     //Methode zur Ausgabe der ersten n Differenzen zwischen 2 Streits
        ArrayList<Integer> differenceDisputes = new ArrayList<Integer>();
        int counter = 1;
        int disputes_found = 0;

        for (int i = 1; disputes_found < n; i++) {      //Schleife zählt bis n Zeitintervalle gefunden wurden
            if (dispute(i)) {                       //Gibt es Streit wird das gezählte Zeitintervall in der ArrayList gespeichert und der Counter zurückgesetzt
                differenceDisputes.add(counter);
                counter = 1;
                disputes_found++;
            } else counter++;                           //Ansonsten nur weitergezählt
        }

        return arrListToArr(differenceDisputes);        //Ausgabe des Arrays
    }

    public static int[] arrListToArr(ArrayList<Integer> arrList) {      //Methode, die ArrayList in Array umwandelt
        int[] intArray = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            intArray[i] = arrList.get(i);
        }

        return intArray;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 12; i++) {
            System.out.println("Streit: " + Arrays.toString(disputes(i)));
            System.out.println("Abstände zwischen 2 Streits: " + Arrays.toString(differenceDisputes(i)));
            System.out.println(i + " : " + counter);
            counter = 0;
            System.out.println("-----------------------------------------------------------------");

        }
        int amount = 10;

        //System.out.println("Streit: " + Arrays.toString(disputes(amount)));
        //System.out.println("Abstände zwischen 2 Streits: " + Arrays.toString(differenceDisputes(amount)));
    }
}

