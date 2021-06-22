package Archive.Adhoc;

public class GCD {
    public static final int UNDEF = 0;

    //compute gcd (Deutsch: ggT) for m>=0 & n>=0
    public static int ggT(int m, int n) {
        System.out.println("ggT(" + m + ", " + n + ")");
        if (m < 0 || n < 0) return UNDEF;
        if (m == 0 && n == 0) return UNDEF;
        else if (m == 0) return n;
        else if (m > n) return ggT(n, m);
        else return ggT(m, n - m);
    }

    public static int f(int x) {
        System.out.println(x);
        if (x > 100) return x - 10;
        else return f(f(x + 11));

    }


    public static int g(int x) {
        if (x == 1) return 1;
        else return g(h(x));

    }

    public static int h(int x) {
        if (x % 2 == 0) return x / 2;
        else return 3 * x + 1;
    }

    public static void main(String[] args) {
        System.out.println(ggT(50, -30));

        //System.out.println(f(0));

        // /*
        for (int i = 1; i < 2; i++) {
            System.out.println(i + ", " + g(50));
        }

        // */


    }
}
