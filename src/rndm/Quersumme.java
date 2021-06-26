package rndm;

public class Quersumme {
    public static void main(String[] args) {
        int x = 525739;
        int y = 0;
        while (x > 0) {
            y += x % 10;
            x /= 10;
        }
        System.out.println(y);
    }

}

