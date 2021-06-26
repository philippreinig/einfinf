package lectures;

public class ggT {
    public static void main(String[] args) {
        int x = 173166;
        int y = 60822;
        int r = 1;
        while (r != 0) {
            r = (x % y);
            x = y;
            y = r;
        }
        System.out.println(x);

    }
}
