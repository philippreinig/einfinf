package Archive.Vorlesung.Suchalgorithmen;

public class Test {

    public static int testingAssertions(int x) {
        assert x > 3 : "x is not greater than 3";
        return x;
    }


    public static void main(String[] args) {
        System.out.println(testingAssertions(0));
    }
}
