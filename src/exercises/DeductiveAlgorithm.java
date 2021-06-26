package exercises;

public class DeductiveAlgorithm {
    static int getXFromY(int y) {
        int x = 0;
        while (y > 1) {
            if (y % 2 == 0) {
                y /= 2;
                x -= 1;
            } else return 1234;
        }

        return x;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i += 2) {
            if (getXFromY(i) != 1234) System.out.println("i: " + i + " result is " + getXFromY(i));

        }
    }
}
