package adhoc;

public class Palindrome {

    public static int numDigits(int n) {
        int digits = String.valueOf(n).length();
        return digits;
    }

    public static int getDigit(int n, int index) {
        int temp = 0;
        for (int i = 0; i < index; i++) {
            temp = n % 10;
            n = n / 10;
        }
        return temp;
    }

    public static boolean isPalindrome(int n) {
        int laenge = numDigits(n);
        int t1, t2;

        for (int i = 0; i < laenge; i++) {
            t1 = getDigit(n, i + 1);
            t2 = getDigit(n, laenge - i);
            if (t1 == t2) {
            } else {
                System.out.println(n);
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(numDigits(12321));
        System.out.println(getDigit(12321, 2));
        System.out.println(isPalindrome(12321));


    }
}