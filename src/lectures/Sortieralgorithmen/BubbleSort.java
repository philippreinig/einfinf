package lectures.Sortieralgorithmen;

import java.util.Arrays;

public class BubbleSort {
    static int[] bubbleSort(int[] a) {
        int n = a.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (a[j - 1] > a[j]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 5, 2, 1, 0, 6, 4, 8, 9, 7, 10, -89, 78, 12, 65, 0, 5, 33, -102, 4568};
        System.out.println(Arrays.toString(bubbleSort(testArray)));

    }
}
