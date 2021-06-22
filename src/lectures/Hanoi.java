package Archive.Vorlesung;

public class Hanoi {
    static int counter = 0;

    public static void solve(int n) {
        move_towers(n, 0, 2, 1);
    }

    public static void move_disk(int from, int to) {
        System.out.println("move disk from " + from + " to " + to);
        counter++;
    }

    public static void move_towers(int n, int from, int to, int free) {
        if (n == 1) {
            move_disk(from, to);
        } else {
            move_towers(n - 1, from, free, to); //Bewegen des Stapels der Größe n-1 zu einer freien "Hilfsposition"
            move_disk(from, to);     //Bewegen der größten Scheibe zur Endposition
            move_towers(n - 1, free, to, from); //Bewegen des kleineren Stapels n-1 zur Endposition
        }
    }

    public static void main(String[] args) {
        solve(5);
        System.out.println(counter);

    }
}
