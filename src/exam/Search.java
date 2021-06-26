package exam;

class Search {
    static int count = 0;

    /// find integer part of sqrt(x)
    /// Aufwand: O(n) = sqrt(n), da i solange um 1 hochgezählt wird bis i = sqrt(n)
    public static int linear_isqrt(int x) {
        assert x >= 0;

        int i = 0;
        while (i < (int) Math.sqrt(x)) { // Hier muss eine geeignete Bedingung stehen!
            ++i;
        }
        return i;

        //Aufwan
    }

    /// find integer part of sqrt(x)
    public static int bonus_linear_isqrt(int x) {
        assert x >= 0;

        int i = 0;
        // BONUS-Aufgabe: Wie oben, aber nur mit Addition!

        return i;
    }

    /// Bob's version of a binary search for integer part of sqrt(x)
    //Aufwand von bobs_binsearch_isqrt() ist quadratisch, also O(n) = sqrt(n), da die for-Schleife quadratischen Aufwand hat, um das Array zu generieren
    public static int bobs_binsearch_isqrt(int x) {
        assert x >= 0;

        int[] a = new int[x + 1];

        // generate array of squares i*i: 0, 1, 4, 9, ...
        int i = 0;
        for (i = 0; i * i <= x; ++i) {
            count++;
            a[i] = i * i;
        }
        // apply binary search
        return binsearch(x, a, 0, i);
    }

    /// binary search for index i of largest element a[i] <= x
    static int binsearch(int x, int[] a, int left, int right) {
        if (left <= right) {
            int m = (left + right) / 2;

            if (a[m] < x)
                return binsearch(x, a, m + 1, right);
            else
                return binsearch(x, a, left, m - 1);
        }
        return right;
    }

    /// Alice's version of a binary search
    public static int alice_binsearch_isqrt(int x) {
        assert x >= 0;

        int[] a = new int[x + 1];

        // generate array of squares i*i: 0, 1, 4, 9, ...
        int i;
        for (i = 0; i * i <= x; i += i) {
            count++;
            a[i] = i * i;
        }
        // apply binary search
        return binsearch(x, a, 0, i);
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 100;

        System.out.println(alice_binsearch_isqrt(100));
        System.out.println(count);
    }
}
