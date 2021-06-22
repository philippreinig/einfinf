package Archive.Vorlesung;

public class Swap {
    public static void main(String[] args) {
        // swap the value of 2 variables a and b
        int a = 3;
        int b = 2;
        System.out.println("a before " + a);
        System.out.println("b before " + b);

        System.out.println("-- Running swap --");
        int t = a;
        a = b;
        b = t;
        System.out.println("a after: " + a);
        System.out.println("b after: " + b);
    }
}
