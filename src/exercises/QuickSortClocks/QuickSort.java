package exercises.QuickSortClocks;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] a, int min, int max) {
        if (min < max) {
            int mid = partition(a, min, max); // mid is pivot element
            quickSort(a, mid + 1, max);    // right side
            quickSort(a, min, mid - 1);   // left side
        }

    }

    public static <T extends Comparable<T>> int partition(T[] a, int min, int max) {
        assert (min <= max) : "max > min!";

        int i = min - 1;
        int j = max;
        T p = a[max];
        T t;
        do {
            do ++i; while (a[i].compareTo(p) < 0);
            do --j; while (j > min && (a[j].compareTo(p) > 0));
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        } while (i < j);

        a[j] = a[i];
        a[i] = a[max];
        a[max] = t;

        return i;
    }


    public static void main(String[] args) {
        Random rnd = new Random();
        Clock[] testArray = new Clock[30];
        for (int i = 0; i < testArray.length; i++) {
            int rndH = rnd.nextInt(23);
            int rndM = rnd.nextInt(59);
            Clock rndClock = new Clock(rndH, rndM);
            testArray[i] = rndClock;
        }

        System.out.println("Unsorted array of clocks: " + Arrays.toString(testArray));
        quickSort(testArray);
        System.out.println("Sorted array of clocks: " + Arrays.toString(testArray));
    }

}


