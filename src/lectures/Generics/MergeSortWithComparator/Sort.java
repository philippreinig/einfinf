package Archive.Vorlesung.Generics.MergeSortWithComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void sort(Student[] a, Comparator comparator) {
        Arrays.sort(a, comparator);

    }
}
