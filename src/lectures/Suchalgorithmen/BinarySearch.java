package lectures.Suchalgorithmen;

public class BinarySearch {
    static int findBinRec(int[] array, int x) {
        return findBinRec(array, x, 0, array.length - 1);
    }

    static int findBinRec(int[] array, int x, int start, int end) {
        if (end < start) {
            System.out.println("Number " + x + " not found in given array!");
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == x) return mid;
        else if (x > array[mid]) return findBinRec(array, x, mid + 1, end);
        else return findBinRec(array, x, 0, mid - 1);
    }

    static int findBinIter(int[] array, int x) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == x) return mid;
            else if (x < array[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int x = 56201;
        System.out.println(findBinRec(array, x));

    }
}
