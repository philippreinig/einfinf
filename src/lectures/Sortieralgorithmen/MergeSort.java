package Archive.Vorlesung.Sortieralgorithmen;

import java.util.Arrays;

public class MergeSort {
    static void merge(int[] a, int[] b, int[] c) {
        assert (c.length >= a.length + b.length);

        int i = 0;
        int j = 0;
        for (int k = 0; k < a.length + b.length; ++k) {
            if (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j]) c[k] = a[i++];
            else c[k] = b[j++];

        }
    }

    static void mergeSort(int[] c) {
        int lenA = c.length / 2;
        int lenB = c.length - lenA;

        int[] a = new int[lenA];
        int[] b = new int[lenB];

        for (int i = 0; i < lenA; ++i) {
            a[i] = c[i];
        }
        for (int i = 0; i < lenB; ++i) {
            b[i] = c[lenA + i];
        }

        if (a.length > 1) mergeSort(a);
        if (b.length > 1) mergeSort(b);

        merge(a, b, c);

    }

    public static void main(String[] args) {
        int[] testArray = {1, 3, 5, 8, 5, 6, 7, 8, 2, 10};
        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

}
