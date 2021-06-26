package lectures.Sortieralgorithmen;

import java.util.Arrays;

public class SelectionSort {
    static int counterOuterForLoop = 0;
    static int counterInnerForLoop = 0;

    static int[] selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            counterOuterForLoop++;
            int minIndex = i;
            for (int j = i + 1; j < n - 1; j++) {
                counterInnerForLoop++;
                if (a[j] < a[minIndex]) minIndex = j;
            }
            int t = a[i];
            a[i] = a[minIndex];
            a[minIndex] = t;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 5, 2, 1, 0, 6, 4, 8, 9, 7, 10, -89, 78, 12, 65, 0, 5, 33, -102, 4568};
        System.out.println(Arrays.toString(selectionSort(testArray)));

        System.out.println("n: " + testArray.length);
        System.out.println("Outer: " + counterOuterForLoop);
        System.out.println("Inner: " + counterInnerForLoop);
    }
}
