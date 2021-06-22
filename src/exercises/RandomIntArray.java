package Archive.exercises;

import java.util.Arrays;

public class RandomIntArray {

    //fills integer array with length n with values from min to max
    public static int[] createRandom(int length) {
        int max = 99;
        int min = 5;
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = (int) (Math.random() * (max - min) + min);
        }
        return randomArray;
    }

    //converts integer array to string containing each element separated by a comma
    public static String toString(int[] a) {
        String string = "";
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                string += Integer.toString(a[i]);
            } else {
                string += a[i] + ",";
            }
        }

        return string;
    }

    //converts integer array to string using java method Arrays.toString()
    public static String toString2(int[] a) {
        return Arrays.toString(a);
    }

    //finds position of the lowest value in an integer array
    public static int posMin(int[] a) {
        int minValue = 0;
        int minPosition = 0;

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                minValue = a[i];
            }
            if (a[i] < minValue) {
                minValue = a[i];
                minPosition = i;
            }
        }
        return minPosition;
    }

    //finds lowest value in an integer array
    public static int minValue(int[] a) {
        int minValue = 0;
        int minPosition = 0;

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                minValue = a[i];
            }
            if (a[i] < minValue) {
                minValue = a[i];
                minPosition = i;
            }
        }
        return minValue;
    }

    //swaps first and last value of an integer array
    public static void swap(int[] a) {
        int firstelement = a[0];
        int lastelement = a[a.length - 1];
        int temp;
        temp = firstelement;
        a[0] = lastelement;
        a[a.length - 1] = temp;
    }

    public static void main(String[] args) {
        int length = 30;

        //print a random integer array with specified length, each element seperated by commas
        int[] randomArray = createRandom(length);

        System.out.println("-----createRandom-----");
        System.out.print("Random array: ");
        for (int i = 0; i < randomArray.length; i++) {
            if (i == randomArray.length - 1) {
                System.out.print(randomArray[i]);
            } else {
                System.out.print(randomArray[i] + ",");
            }
        }
        System.out.println();

        //print random integer array converted to string and test if toString and java standard method deliver the same result
        String randomArrayAsString = toString(randomArray);
        String randomArrayAsString2 = toString2(randomArray);

        System.out.println("-----toString-----");
        if (randomArrayAsString.equals(randomArrayAsString2)) {
            System.out.println("Die Methode toString und die Standardmethode liefern das gleiche Ergebnis: ");
        } else {
            System.out.println("Die Methode toString und die Standardmethode liefern unterschiedliche Ergebnisse: ");
        }

        System.out.println("Ergebnis der Methode toString: " + randomArrayAsString);
        System.out.println("Ergebnis der Standardmethode: " + randomArrayAsString2);

        //print position of the lowest value of the random integer array
        int index = posMin(randomArray);
        int position = posMin(randomArray) + 1;

        System.out.println("-----posMin-----");
        System.out.println("Die kleinste Zahl im Array ist " + minValue(randomArray) + " und befindet sich bei Index " + index + " bzw. Position " + position);

        //print integer array and with swaped first and last value
        System.out.println("-----swap-----");
        System.out.println("Array before swap: " + randomArrayAsString);
        swap(randomArray);
        System.out.println("Array after swap:  " + toString(randomArray));
    }
}