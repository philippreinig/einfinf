package Archive.exercises;

public class Complexity {

    static double ld(int n) {
        return Math.log(n) / Math.log(2);
    }

    static double linear(int n) {
        return n;
    }

    static double linearithmic(int n) {
        return ld(n) * linear(n);
    }

    static double quadratic(int n) {
        return n * n;
    }

    static double cubic(int n) {
        return n * n * n;
    }

    static double exponential(int n) {
        return Math.pow(2, n);
    }

    public static void main(String[] args) {
        System.out.println("ein Rechenschritt: 1 Nanosekunde (10^(-9)sec)");

        System.out.println(String.format("%s%25s%10s%20s%15s%20s%25s", // %10s --> String mit 10 Zeichen, rechtsbündig, links mit Leerzeichen aufgefüllt
                "k", "ldn", "n", "n*ldn", "n^2", "n^3", "2^n"));

        for (int i = 1; i <= 10; i++) {
            int j = i * 10 ^ 9;
            System.out.println(
                    String.format("%s%25s%10s%20s%15s%20s%25s", // %10s --> String mit 10 Zeichen, rechtsbündig, links mit Leerzeichen aufgefüllt
                            i, ld(j), linear(j), linearithmic(j), quadratic(j), cubic(j), exponential(j)));
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
        }
         /*
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", // %10s --> String mit 10 Zeichen, rechtsbündig, links mit Leerzeichen aufgefüllt
                        "k", "ldn", "n", "n*ldn", "n^2", "n^3", "2^n"));
*/

    }


}