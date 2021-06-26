package adhoc;

public class Dreieckszahlen {

    public static boolean isTriangular(int n) {
        int sum = 0;
        for (int i = 1; sum <= n; i++) {
            sum += i;

            if (sum == n) {
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int num = 50404;
        boolean x = isTriangular(num);
        if (x) {
            System.out.println("Die Zahl " + num + " ist eine Dreieckszahl");

        } else {
            System.out.println("Die Zahl " + num + " ist keine Dreieckszahl");
        }

    }
}
