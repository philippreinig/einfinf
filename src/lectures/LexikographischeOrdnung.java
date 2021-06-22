package Archive.Vorlesung;

public class LexikographischeOrdnung {

    static boolean less(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (i >= b.length) return false;
            else if (a[i] < b[i]) return true;
            else if (a[i] > b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] a = {'A', 'a', 'l'};
        char[] b = {'A', 'a', 'l', 'e'};
        System.out.println(less(b, a));

    }
}
