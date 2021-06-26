package lectures.Sortieralgorithmen;

import java.util.Arrays;

public class QuickSort {
    static int[] quickSort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    static int[] quickSort(int[] a, int l, int r) {
        if (r > l) {
            int m = partition(a, l, r);
            quickSort(a, l, m - 1);
            quickSort(a, m + 1, r);
        }

        return a;
    }

    static int partition(int[] a, int l, int r) {
        assert (l <= r);

        int p = a[r];
        int t;
        int i = l - 1;
        int j = r;
        do {
            do ++i; while (a[i] < p);
            do --j; while (j > l && a[j] > p);
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        } while (i < j);

        a[j] = a[i];
        a[i] = a[r];
        a[r] = t;

        return i;
    }


    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 7, 4, 0, 54, 13};
        System.out.println(Arrays.toString(quickSort(testArray)));
    }
}
