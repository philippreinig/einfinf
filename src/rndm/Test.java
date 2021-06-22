package Archive.rndm;


public class Test {
    public static int f(int x) {
        if (x <= 0) return 1;
        else return x * f(x - 1);
    }

    public static int g(int x) {
        if (x == 0) return 1;
        else return x * f(x - 1);
    }

    public static int h(int x) {
        if (x >= 0) return 1;
        else return x * f(x + 1);
    }

    private static void function_f(int n) {
        for (int i = 1; i <= n; i = i + i) System.out.println(i);
    }

    public static void main(String[] args) {
        //function_f(100);

        for (int i = 0; i < 100; i++) {
            System.out.println(i % 1);
        }
    }
}
