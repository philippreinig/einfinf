package Archive.exercises;

import java.util.Arrays;

public class PerfectShuffle {

    //Mischt zwei Decks zu einem, indem abwechselnd ein Element jedes Arrays zu einem neuen hinzugefügt werden
    public static int[] interleave(int[] a1, int[] a2) {
        int[] interleavedArray = new int[a1.length + a2.length]; //Neues Array hat Länge = Summe der Längen der beiden Arrays
        int counterPos = 0;
        for (int i = 0; i < a1.length + a2.length; i++) {
            interleavedArray[i] = a1[counterPos];
            i++;
            interleavedArray[i] = a2[counterPos];
            counterPos++;

        }
        return interleavedArray;
    }

    //Teilt Array in 2 Hälften und gibt "interleaved-Version" des Arrays aus
    public static int[] perfectShuffle(int[] a) {
        if (a.length % 2 == 1) {    //Filtern von Arrays mit ungerader Länge
            return a;
        }

        int[] a1 = Arrays.copyOfRange(a, 0, a.length / 2);      //1. Hälfte
        int[] a2 = Arrays.copyOfRange(a, a.length / 2, a.length);   //2. Hälfte
        return interleave(a1, a2);

    }

    //
    public static int[] createFilledArray(int n) {
        int[] filledArray = new int[n];
        for (int i = 0; i < n; i++) {
            filledArray[i] = i;
        }
        return filledArray;
    }


    public static int shuffleNumber(int n) {
        int[] array = createFilledArray(n);
        int[] copyOfArray = Arrays.copyOf(array, n);
        System.out.println(array);


        copyOfArray = perfectShuffle(copyOfArray);
        if (n <= 0 || n % 2 == 1) {
            return -1;
        }
        int counter = 1;
        while (!(Arrays.equals(array, copyOfArray))) {
            copyOfArray = perfectShuffle(copyOfArray);
            counter++;
        }
        return counter;
    }


    public static void main(String[] args) {
        /*
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
        for (int element : interleave(a1, a2)) {
            System.out.println(element);
        }

         */

        int[] a = {1, 2, 3, 4, 5, 6};
        for (int element : perfectShuffle(a)) {
            System.out.println(element);
        }
        System.out.println("Anzahl: " + shuffleNumber(10));
    }
}