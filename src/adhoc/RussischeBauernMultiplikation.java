package Archive.Adhoc;

public class RussischeBauernMultiplikation {

    public static int recursive(int x, int y, int result) {
        if (x == 1) return result;
        x = x / 2;
        y = y * 2;

        if (x % 2 != 0) return recursive(x, y, result + y);
        else return recursive(x, y, result);
    }

    public static int recursive(int x, int y) {
        return recursive(x, y, 0);

    }

    public static int iterative(int x, int y) {
        int result = 0;
        while (x != 1) {
            x = x / 2;
            y = y * 2;
            if (x % 2 != 0) {
                result += y;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int x = 35;
        int y = 99;
        System.out.println(iterative(x, y));
        System.out.println(recursive(x, y));
    }
}