package tutorium;

import java.util.Arrays;

public class BinarySearch2D {
    public static int counter = 0;

    //Generating a sorted array with k rows and m columns
    static int[][] generateArray(int k, int m) {
        //Catch invalid entered dimensions
        if (k < 1 || m < 1) {
            System.err.println("Array dimensions have to be at least 1!");
            System.exit(-1);
        }
        int[][] temp = new int[k][m];
        int counter = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = counter;
                counter += 2;
            }
        }
        return temp;
    }

    //Display 2D array in console
    static void printArray2D(int[][] intArray2D) {
        for (int i = 0; i < intArray2D.length; i++) {
            System.out.print("[");
            for (int j = 0; j < intArray2D[0].length; j++) {
                if (j < intArray2D[0].length - 1) {
                    System.out.print(intArray2D[i][j] + ",");
                } else {
                    System.out.print(intArray2D[i][j] + "]");
                    System.out.println();
                }
            }
        }
    }

    //Convert a 2D array to 1D array
    static int[] array2DToArray1D(int[][] matrix) {
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                counter++;
                array[matrix[0].length * i + j] = matrix[i][j];
            }
        }
        return array;
    }

    //Convert 1D array to 2D array
    static int[][] array1DToArray2D(int[] array, int rows, int columns) {
        //Only possible if length of array = rows * columns
        if (array.length != rows * columns) {
            System.err.println("Amount of numbers in array is unequal to amount of rows*columns! Conversion from 1D to 2D-array not possible!");
            System.exit(-1);
        }

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                counter++;
                matrix[i][j] = array[(i * columns) + j];
            }
        }
        return matrix;
    }

    //Recursive binary search algorithm on a 1D array
    static int binarySearch1D(int[] array, int number, int low, int high) {
        counter++;
        if (low < high) {
            int midIndex = (low + high) / 2;
            int midValue = array[midIndex];
            if (number == midValue) return midIndex;
            else if (number > midValue) return binarySearch1D(array, number, midIndex + 1, high);
            else if (number < midValue) return binarySearch1D(array, number, low, midIndex - 1);
            else return -1;
        } else return -1;
    }

    static int binarySearch1D(int[] array, int number) {
        counter++;
        return binarySearch1D(array, number, 0, array.length);

    }

    //Check if number exists in array
    static boolean numberExistsInArray(int[] array, int number) {
        counter++;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) return true;
        }
        return false;
    }

    //Binary search on a 2D array
    static int[] binarySearch2D(int[][] haystack, int needle) {
        counter++;
        //Check if needle exists in haystack
        //if (!numberExistsInArray(array2DToArray1D(haystack), needle)) return new int[]{-1,-1};

        //Check if array is sorted
        if (!Arrays.deepEquals(haystack, sortArray(haystack))) {
            System.out.println("Given array not sorted!");
            System.out.println("Showing result for sorted array:");
            printArray2D(sortArray(haystack));
            haystack = sortArray(haystack);
            return new int[]{-1, -1};
        }

        int index1D = binarySearch1D(array2DToArray1D(haystack), needle);
        if (index1D == -1) {
            return new int[]{-1, -1};
        } else {
            System.out.println("index1D: " + index1D);
            int index1 = index1D / haystack[0].length;
            int index2 = index1D % haystack[0].length;
            return new int[]{index1, index2};
        }
    }

    //Generate a random 2D array with dimension k, m and numbers in range from low to high
    static int[][] generateRandomArray(int k, int m, int low, int high) {
        if (k < 1 || m < 1) {
            System.err.println("Array dimensions have to be at least 1!");
            System.exit(-1);
        }
        int[][] temp = new int[k][m];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = (int) (Math.random() * (high - low + 1)) + low;
            }
        }
        return temp;
    }

    //Sorting a 2D array
    static int[][] sortArray(int[][] arrayUnsorted) {
        counter++;
        int[] array1D = array2DToArray1D(arrayUnsorted);
        Arrays.sort(array1D);
        return array1DToArray2D(array1D, arrayUnsorted.length, arrayUnsorted[0].length);
    }

    //main methods for tests
    public static void main(String[] args) {
        System.out.println("---- Sorted array ----");
        int[][] temp_array = generateArray(10, 10);
        printArray2D(temp_array);
        int[] binarySearch2DMethodResult = binarySearch2D(temp_array, 29);
        System.out.println(Arrays.toString(binarySearch2DMethodResult));
        /*
        System.out.println("------------------------------------");
        int[][] rndmArray = generateRandomArray(3, 3, 0, 10);
        printArray2D(sortArray(rndmArray));

         */
        counter = 0;
        System.out.println("---- Random array -----");
        int[][] randomArray = generateRandomArray(10, 10, 0, 100);
        printArray2D(randomArray);
        System.out.println(Arrays.toString(binarySearch2D(randomArray, -1)));
        System.out.println("Counter: " + counter);          //Amount of function calls needed to find needle in haystack


    }
}