package Current.Tutorien;

import java.util.Random;

public class MergeSortWithInsertionSort {
    static int counterInsertionSort = 0;
    static int counterMergeSort = 0;
    static int counterCombinedSort = 0;

    //insertionSort algorithm from lecture
    public static void insertionsort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int x = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > x; --j) {
                counterInsertionSort++;
                counterCombinedSort++;
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }

    //merge algorithm from lecture
    static void merge(int[] a, int[] b, int[] c) {
        assert (c.length >= a.length + b.length);
        int i = 0, j = 0;
        for (int k = 0; k < a.length + b.length; ++k) {
            counterMergeSort++;
            if (i >= a.length) {
                c[k] = b[j++];
            } else if (j >= b.length) {
                c[k] = a[i++];
            } else if (a[i] <= b[j]) {
                c[k] = a[i++];
            } else c[k] = b[j++];
        }
    }

    //mergesort algorithm from lecture
    public static void mergesort(int[] c) {
        int na = c.length / 2;
        int nb = c.length - na; // mind integer division
        int[] a = new int[na]; // split c: copy parts
        for (int i = 0; i < na; ++i) a[i] = c[i];
        int[] b = new int[nb];
        for (int j = 0; j < nb; ++j) b[j] = c[j + na];
        if (a.length > 1){
            mergesort(a); // recursive
        }
        if (b.length > 1){
            mergesort(b); // sort
        }
        merge(a, b, c); // merge
    }


    //combining merge and insert sort algorithms - changing from merge to insert when length of array < changeParameter
    public static void combinedSort(int[] c, int changeParameter) {
        int na = c.length / 2;
        int nb = c.length - na; // mind integer division
        int[] a = new int[na]; // split c: copy parts
        for (int i = 0; i < na; ++i) a[i] = c[i];
        int[] b = new int[nb];
        for (int j = 0; j < nb; ++j) b[j] = c[j + na];

        //changing to insertion sort if array is small enough - array.length <= changeParameter
        if (a.length > changeParameter) {
            combinedSort(a, changeParameter); // recursive
        } else {
            insertionsort(a);
        }
        if (b.length > changeParameter) {
            combinedSort(b, changeParameter); // sort
        } else {
            insertionsort(b);
        }
        mergeCombined(a, b, c); // merge
    }

    //merge algorithm from lecture
    static void mergeCombined(int[] a, int[] b, int[] c) {
        assert (c.length >= a.length + b.length);
        int i = 0, j = 0;
        for (int k = 0; k < a.length + b.length; ++k) {
            counterCombinedSort++;
            if (i >= a.length) {
                c[k] = b[j++];
            } else if (j >= b.length) {
                c[k] = a[i++];
            } else if (a[i] <= b[j]) {
                c[k] = a[i++];
            } else c[k] = b[j++];
        }
    }

    //testing insert sorting algorithm with given length of array and amount of tests
    static int testInsertionSort(int arrayLength, int testAmount) {
        int[] testArray = new int[arrayLength];
        int average = 0;
        for (int i = 0; i < testAmount; i++) {
            //Fill testArray with rndm int values
            for (int j = 0; j < testArray.length - 1; j++) {
                Random rn = new Random();
                testArray[j] = rn.nextInt(testArray.length);
            }
            insertionsort(testArray);
            average += (double) counterInsertionSort / testAmount;
            counterInsertionSort = 0;
            counterCombinedSort = 0;
        }
        return average;
    }

    //testing merge sorting algorithm with given length of array and amount of tests
    static int testMergeSort(int arrayLength, int testAmount) {
        int[] testArray = new int[arrayLength];
        int average = 0;
        for (int i = 0; i < testAmount; i++) {
            //Fill testArray with rndm int values
            for (int j = 0; j < testArray.length - 1; j++) {
                Random rn = new Random();
                testArray[j] = rn.nextInt(testArray.length);
            }
            mergesort(testArray);
            average += (double) counterMergeSort / testAmount;
            counterMergeSort = 0;
        }
        return average;
    }

    //testing combined sorting algorithm with given length of array and amount of tests
    static int testCombinedSort(int arrayLength, int testAmount, int cp) {
        int[] testArray = new int[arrayLength];
        int average = 0;
        for (int i = 0; i < testAmount; i++) {
            //Fill testArray with rndm int values
            for (int j = 0; j < testArray.length - 1; j++) {
                Random rn = new Random();
                testArray[j] = rn.nextInt(testArray.length);
            }
            combinedSort(testArray, cp);
            average += (double) counterCombinedSort / testAmount;
            counterCombinedSort = 0;
        }
        return average;
    }

    public static void main(String[] args) {
        int arrayLength = 10000;
        int testAmount = 1000;
        int cpMax = 30;
        int cpMin = 18;
        for (int i = cpMin; i <= cpMax; i++) {
            System.out.println("combinedSort - changeParameter "  + i  + ": " + testCombinedSort(arrayLength, testAmount, i));
            //System.out.println("insertionSort: " + testInsertionSort(arrayLength, testAmount));
            System.out.println("mergeSort: " + testMergeSort(arrayLength, testAmount));
        }
        //Die Konstante die am besten funktioniert laut unseren Tests ist 19
    }
}