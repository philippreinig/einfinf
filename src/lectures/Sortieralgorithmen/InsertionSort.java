package lectures.Sortieralgorithmen;

import java.util.Arrays;

public class InsertionSort {
    static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            int x = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > x; j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
        return a;
    }


    public static void main(String[] args) {
        int[] testArray = {3, 5, 2, 1, 0, 6, 4, 8, 9, 7, 10, -89, 78, 12, 65, 0, 5, 33, -102, 4568};
        System.out.println(Arrays.toString(insertionSort(testArray)));

    }
}
