package exampreparation;

public class Suchalgorithmen {
    private static final int UNDEF = -1;

    private static int lineareSuche(int[] a, int x) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == x) return i;
        }
        return UNDEF;
    }

    private static int binaereSucheRek(int[] a, int x) {
        return binaereSucheRek(a, x, 0, a.length - 1);
    }

    private static int binaereSucheRek(int[] a, int x, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            if (a[mid] == x) return mid;
            else if (x < a[mid]) return binaereSucheRek(a, x, left, mid - 1);
            else return binaereSucheRek(a, x, mid, right - 1);
        }
        return UNDEF;
    }

    private static int[] generateSortedTestArray(int testArrayLength) {
        int[] testArray = new int[testArrayLength];
        for (int i = 0; i < testArrayLength; i++) {
            testArray[i] = i;
        }
        return testArray;
    }

    private static int binaereSucheIter(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) return mid;
            else if (x < a[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return UNDEF;
    }

    public static void main(String[] args) {
        int testArrayLength = 100;
        int[] testArray = generateSortedTestArray(testArrayLength);
        int numToFind = 37;
        System.out.println("lin: " + lineareSuche(testArray, numToFind));
        System.out.println("binRek: " + binaereSucheRek(testArray, numToFind));
        System.out.println("binIter: " + binaereSucheIter(testArray, numToFind));
    }
}
