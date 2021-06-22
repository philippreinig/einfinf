package Archive.math;

public class RecursionMath1 {

    public static int recursive(int n) {
        if (n == 0) return 1;
        else return recursive(n - 1) + 6 * (n * (n - 1) + 1);
    }

    public static void main(String[] args) {
        int value = 10;
        for (int n = 0; n <= value; n++) {
            int result = 2 * (int) Math.pow(n, 3) + 4 * n + 1;
            System.out.println("f(" + n + ")=" + result);
        }

        for (int n = 0; n <= value; n++) {
            System.out.println("f(" + n + ")=" + recursive(n));
        }


    }
}

