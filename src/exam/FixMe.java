package Klausur;

//Ein int Array stellt eine Referenz auf Daten, nicht diese selbst dar. Es wurde in der Methode clone() die Referenz auf das rgb Array der Instanz white übergeben und deshalb
// in der Methode darker() verändert. Es sollte in der Methode clone() der andere Konstruktor verwendet werden, dem die gleichen Daten, aber nicht die Referenz auf die Daten übergeben wird.

public class FixMe {
    public int rgb[] = {0, 0, 0};

    public FixMe() {
    }

    public FixMe(int r, int g, int b) {
        this.rgb[0] = r;
        this.rgb[1] = g;
        this.rgb[2] = b;
    }

    /// create a copy of myself
    public FixMe clone() {
        FixMe f = new FixMe(this.rgb[0], this.rgb[1], this.rgb[2]);
        return f;
    }

    public FixMe darker() {
        FixMe f = clone();
        f.rgb[0] /= 2;
        f.rgb[1] /= 2;
        f.rgb[2] /= 2;
        return f;
    }

    public String toString() {
        return "rgb = {" + rgb[0] + "," + rgb[1] + "," + rgb[2] + "}";
    }

    public static void main(String[] args) {
        FixMe white = new FixMe(255, 255, 255);
        FixMe gray = white.darker();

        System.out.println("white: " + white + ", " + "gray: " + gray);

    }
}
