package Archive.rndm;

public class Fakultät {
    public static void main(String[] args) {

        int a = 10;
        int x = 1;
        int y = 1;
        while (x<=a) {
            y *= x;
            x += 1;
        }
        System.out.println("Die Fakultät von "+a+" ist "+y);

    }
}
