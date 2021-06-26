package lectures.FunktionaleProgrammierung;

public class BasicArithmetic {

    static int pred(int x) { //pred = predecessor
        return x - 1;
    }

    static int succ(int x) {    //succ = successor
        return x + 1;
    }

    static int add(int x, int y) {
        if (y >= 0) {
            if (y == 0) return x;
            else return add(succ(x), pred(y));
        } else return add(x, y, 0);
    }

    static int add(int x, int y, int z) {
        if (y == z) return x;
        else return add(succ(x), y, succ(z));
    }

    static int abs(int x) {
        return x >= 0 ? x : -x;
    }

    //Own solution     ---------------------------
    static int multiply(int x, int y) {
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) return -multiply(abs(x), abs(y), abs(x));
        else if (x < 0 && y < 0) return multiply(abs(x), abs(y), abs(x));
        else return multiply(x, y, x);
    }

    static int multiply(int x, int y, int z) {
        if (x == 0 || y == 0) return 0;
        else if (x == 1) return y;
        else if (y == 1) return x;
        else return multiply(add(x, z), pred(y), z);

    }

    //Solution from lecture ------------------------
    static int multiply2(int x, int y) {
        if (y == 0) return 0;
        else return add(multiply2(x, pred(y)), x);
    }

    public static int mult(int x, int y) {
        if (x == 0 || y == 0) return 0;
        else if (x < 0 && y > 0) return -mult(-x, y);
        else if (x > 0 && y < 0) return -mult(x, -y);
        else return mult(x, y, 0);
    }

    private static int mult(int x, int y, int z) {
        if (y == z) return 0;
        else return add(x, mult(x, y, succ(z)));
    }

    static int exponentiate(int x, int y) {
        if (y < 0) {
            System.out.println("Sorry can't calculate power with exponent less than 0: returning 0 as invalid result!");
            return 0;
        } else {
            if (y == 0) return 1;
            else return multiply(exponentiate(x, pred(y)), x);
        }
    }

    public static int diff(int x, int y) {
        if (x > y) return diff(y, x);
        if (x == y) return 0;
        else return diff(x, y, 0);
    }

    //May only be called by diff(int x, int y)
    private static int diff(int x, int y, int z) {
        if (x == y) return z;
        else return diff(succ(x), y, succ(z));
    }

    public static void main(String[] args) {
        System.out.println(diff(10, 8));
        System.out.println(mult(-1, 5));

        System.out.println(add(3, -5));
    }
}
