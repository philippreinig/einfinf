package exampreparation;

import java.util.Arrays;
import java.util.Random;

public class Sortieralgorithmen {
    private static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //Find min value
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            //Swap min value with value at position i
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }

    private static int[] insertionSort(int[] a) {
        //Iterate over whole array
        for (int i = 0; i < a.length; i++) {
            // Start at index i (=next element that has to be sorted in to the already sorted part to the left)
            // Iterate until the left end of array is reached or found a smaller number to the left
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                int temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
        return a;
    }

    private static int[] mergeSort(int[] a) {
        int mid = a.length / 2;
        int[] b = new int[mid];
        int[] c = new int[a.length - b.length];

        System.arraycopy(a, 0, b, 0, b.length);
        System.arraycopy(a, mid, c, 0, c.length);
        if (b.length > 1) mergeSort(b);
        if (c.length > 1) mergeSort(c);
        return merge(b, c, a);
    }

    private static int[] merge(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < a.length + b.length; ++k) {
            if (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j]) c[k] = a[i++];
            else c[k] = b[j++];
        }
        return c;
    }

    private static int[] bubbleSort(int[] a) {
        int counter = 1;
        while (counter > 0) {
            counter = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                    counter++;
                }
            }
        }
        return a;
    }

    private static int[] quickSort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    private static int[] quickSort(int[] a, int left, int right) {
        System.out.println(Arrays.toString(a));
        if (left < right) {
            int p = partition(a, left, right);
            quickSort(a, left, p - 1);
            quickSort(a, p + 1, right);
        }
        return a;
    }

    private static int partition(int[] a, int left, int right) {
        int p = a[right];
        int i = left - 1;
        int j = right;
        int t;
        do {
            do ++i; while (a[i] < p);
            do --j; while (j > left && a[j] > p);
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        } while (i < j);

        a[j] = a[i];
        a[i] = a[right];
        a[right] = t;

        return i;
    }

    public static void main(String[] args) {
        int testArrayLength = 10;

        int[] testArray1 = generateRandomUnsortedArray(testArrayLength);
        System.out.println(Arrays.toString(testArray1));
        System.out.println(isArraySorted(testArray1));
        System.out.println("selectionSort: " + Arrays.toString(selectionSort(testArray1)));
        System.out.println(isArraySorted(testArray1));

        int[] testArray2 = generateRandomUnsortedArray(testArrayLength);
        System.out.println(Arrays.toString(testArray2));
        System.out.println(isArraySorted(testArray2));
        System.out.println("insertionSort: " + Arrays.toString(insertionSort(testArray2)));
        System.out.println(isArraySorted(testArray2));

        int[] testArray3 = generateRandomUnsortedArray(testArrayLength);
        System.out.println(Arrays.toString(testArray3));
        System.out.println(isArraySorted(testArray3));
        System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(testArray3)));
        System.out.println(isArraySorted(testArray3));

        int[] testArray4 = generateRandomUnsortedArray(testArrayLength);
        System.out.println(Arrays.toString(testArray4));
        System.out.println(isArraySorted(testArray4));
        System.out.println("quickSort: " + Arrays.toString(quickSort(testArray4)));
        System.out.println(isArraySorted(testArray4));

        int[] testArray5 = generateRandomUnsortedArray(testArrayLength);
        System.out.println(Arrays.toString(testArray5));
        System.out.println(isArraySorted(testArray5));
        System.out.println("mergeSort: " + Arrays.toString(mergeSort(testArray5)));
        System.out.println(isArraySorted(testArray5));
    }
    //##########################################################################

    private static int[] generateRandomSortedArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] generateRandomUnsortedArray(int arrayLength) {
        return shuffleArray(generateRandomSortedArray(arrayLength));
    }

    private static int[] shuffleArray(int[] a) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            int rndIndex = rnd.nextInt(a.length);
            int temp = a[i];
            a[i] = a[rndIndex];
            a[rndIndex] = temp;
        }
        return a;
    }

    private static boolean isArraySorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }
}
