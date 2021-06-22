package Archive.math;

public class Aufgabe65 {
    public static int result(int e, int x) {
        return (6 + e + x) % 7;
    }

    public static void main(String[] args) {
        for (int e = 0; e <= 7; e++) {
            for (int x = 0; x <= 20; x++) {
                System.out.println("e=" + e + "/x=" + x + " -> " + result(e, x));


            }

        }

    }
}
