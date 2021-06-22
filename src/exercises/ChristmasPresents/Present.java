package Archive.exercises.ChristmasPresents;

public abstract class Present {
    static int counter = 0;

    protected Present() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    abstract double surface();

    double computePaperSize() {
        return Math.ceil(surface() * 1.6 * 2) / 2.0;
    }
}
