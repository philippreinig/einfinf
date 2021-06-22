package Archive.Vorlesung.FunktionaleProgrammierung;

public class Factorial {
    static int factorial(int x) {
        if (x == 0) return 0;
        else return x * factorial(x - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(-1));
    }
}
