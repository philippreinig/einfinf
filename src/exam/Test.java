package exam;

public class Test {
    public static int find(int x, int[] a) {
        return find(x, a, 0, a.length - 1);
    }

    static int find(int x, int[] a, int left, int right) {
        if (left > right) return -1; // x =2 a


        int mid = (left + right) / 2;
        System.out.print(a[mid] + ", ");

        if (x == a[mid]) return mid;
        if (x < a[mid]) return find(x, a, left, mid - 1);
        else return find(x, a, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {16, 21, 48, 51, 59, 73, 75, 76, 87, 94, 95, 97};
        find(59, a);

    }
}
