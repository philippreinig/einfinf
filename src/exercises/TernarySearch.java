package exercises;

/*
3.
Beispiel:
Array mit 10.000 Einträgen (1 -> 10.000), gesucht wird die Zahl 3720.
Die binäre Suche benötigt 14 Funktionsaufrufe, die ternäre Suche nur 10.
Allerdings finden bei der binären Suche pro Funktionsaufruf nur 3 Vergleiche statt,
die ternäre Suche benötigt 5 Vergleiche - bzw. weden nur 2 für binäre und 4 für ternäre Suche benötigt,
wenn die Abbruchbedingung end<start nicht mitgezählt wird. Demnach finden für die binäre Suche 28 Vergleiche statt,
für die ternäre Suche 40.
Laufzeitkomplexität: O(log3(n)), da bei jedem Schritt der Bereich des Arrays gedrittelt, statt halbiert wird
Werden also die Vergleiche berücksichtigt hat die binäre Suche die Laufzeit O(2*log2(n)) und die ternäre Suche
die Laufzeit O(4*log3(n)), gekürzt ergibt sich O(log2(n)) vs. O(2*log3(n)) -> 2*log3(n) > log2(n), also ist binäre Suche effizienter
Vorteile laut Internet scheinbar: Finden von Maxima bei unimodalen Funktionen und bei ternären Suchbäumen
 */

public class TernarySearch {
    static final int UNDEF = -1;

    static int counterBinary = 0;
    static int counterTernary = 0;

    public static int binaryRec(int[] a, int x) {
        counterBinary++;
        return binaryRec(a, 0, a.length - 1, x);
    }

    private static int binaryRec(int[] a, int l, int r, int x) {
        counterBinary++;
        if (l > r) return UNDEF;
        int m = (l + r) / 2;
        if (x == a[m]) return m;
        else if (x < a[m]) return binaryRec(a, l, m - 1, x);
        else return binaryRec(a, m + 1, r, x);
    }

    public static int ternaryRec(int[] a, int x) {
        counterTernary++;
        if (a.length == 0 || x < a[0] || x > a[a.length - 1]) return UNDEF;
        else return ternaryRec(a, x, 0, a.length - 1);
    }

    private static int ternaryRec(int[] a, int x, int start, int end) {
        counterTernary++;
        if (end < start) return UNDEF;
        int mid1 = start + (end - start) / 3;
        int mid2 = start + (end - start) * 2 / 3;
        if (a[mid1] == x) return mid1;
        else if (a[mid2] == x) return mid2;
        else if (x < a[mid1]) return ternaryRec(a, x, start, mid1 - 1);
        else if (x > a[mid2]) return ternaryRec(a, x, mid2 + 1, end);
        else return ternaryRec(a, x, mid1 + 1, mid2 - 1);

    }

    public static void main(String[] args) {
        /*
        for(int i = 0; i<100; i++){
            int[] testArray = new int[i];
            for (int j = 0; j < testArray.length; j++) {
                testArray[j] = j+1;
            }
            Random r = new Random();
            int testNumberRndm = r.nextInt(i+1);
            System.out.println("Number: " + testNumberRndm + ", result: " + ternaryRec(testArray, testNumberRndm) + ", array: " + Arrays.toString(testArray));
        }
         */

        int[] testArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            testArray[i] = i + 1;
        }

        int testNumber = 37219;

        System.out.println(binaryRec(testArray, testNumber));
        System.out.println(counterBinary);
        System.out.println("---");

        System.out.println(ternaryRec(testArray, testNumber));
        System.out.println(counterTernary);


    }
}