package Klausur;

import java.util.Arrays;

public class Sort {
    //Angepasster Algorithmus hat Aufwand O(n) = n*log(n)


    /// Quicksort algorithm for int[]
    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1, 10);
    }

    public static void quicksort(int[] a, int k) {
        quicksort(a, 0, a.length - 1, k);
    }

    /// recursive implementation of Quicksort
    private static void quicksort(int[] a, int l, int r, int k) {
        if (r > l) {
            int m = partition(a, l, r);
            if (m - 1 - l > k) quicksort(a, l, m - 1, k);
            else insertionsort(a, l, m - 1);
            if (r - m - 1 > k) quicksort(a, m + 1, r, k);
            else insertionsort(a, m + 1, r);
            assert isSorted(a, l, r);
        }
    }

    /// partition called by recursive Quicksort
    private static int partition(int[] a, int l, int r) {
        int p = a[r], t;
        int i = l - 1, j = r;
        do {
            do ++i; while (a[i] < p);           // find
            do --j; while (j > 0 && a[j] > p);
            t = a[i];
            a[i] = a[j];
            a[j] = t;  // swap
        } while (i < j);

        a[j] = a[i];
        a[i] = a[r];
        a[r] = t;

        return i;             // new index of pivot
    }

    /// Insertion sort algorithm for int[]
    public static void insertionsort(int[] a, int l, int r) {
        int n = r;
        for (int i = l; i <= r; ++i) {
            int x = a[i];

            int j;
            for (j = i; j > 0 && a[j - 1] > x; --j) {
                a[j] = a[j - 1];
            }

            a[j] = x;
        }
        assert isSorted(a);
    }

    /// helper: verify order in a
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /// helper: verify order in a[l,...,r]
    public static boolean isSorted(int[] a, int l, int r) {
        for (int i = l; i < r; ++i) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /// Use for testing
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 1, 9, 7, 6, 0, 4, 8};
        quicksort(a);
        assert isSorted(a);
        System.out.println(Arrays.toString(a));
    }
}
