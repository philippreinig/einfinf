package Archive.Vorlesung.Suchalgorithmen;

public class SequentielleSuche {

    static int findSeq(int[] a, int x) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 45, 98};
        System.out.println(findSeq(a, 25));

    }
}
