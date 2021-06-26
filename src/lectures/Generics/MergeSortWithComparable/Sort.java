package lectures.Generics.MergeSortWithComparable;

public class Sort {
    public static void sort(Comparable[] a) {
        mergeSort(a);


    }

    static void merge(Comparable[] a, Comparable[] b, Comparable[] c) {
        assert (c.length >= a.length + b.length);

        int i = 0;
        int j = 0;
        for (int k = 0; k < a.length + b.length; ++k) {
            if (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i].compareTo(b[j]) < 0 || a[i].compareTo(b[j]) == 0) c[k] = a[i++];
            else c[k] = b[j++];

        }
    }

    static void mergeSort(Comparable[] c) {
        int lenA = c.length / 2;
        int lenB = c.length - lenA;

        Comparable[] a = new Comparable[lenA];
        for (int i = 0; i < lenA; ++i) {
            a[i] = c[i];
        }

        Comparable[] b = new Comparable[lenB];
        for (int i = 0; i < lenB; ++i) {
            b[i] = c[lenA + i];
        }

        if (a.length > 1) mergeSort(a);
        if (b.length > 1) mergeSort(b);

        merge(a, b, c);
    }
}
