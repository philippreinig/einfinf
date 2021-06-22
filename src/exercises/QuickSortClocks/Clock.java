package Archive.exercises.QuickSortClocks;

public class Clock implements Comparable<Clock> {
    private final int h; // Stunden (0-23)

    private final int min; // Minuten (0-59)

    private final int gmin; // gesamt-Minuten

    // in set-Methoden gmin aktualisieren!!

    public Clock() {
        h = 0;
        min = 0;
        gmin = 0;
    }

    public int getH() {
        return h;
    }

    public int getMin() {
        return min;
    }

    public Clock(int h, int min) {
        assert (0 <= h && h <= 23 && 0 <= min && min <= 59) : "unallowable time";
        this.h = h;
        this.min = min;
        gmin = h * 60 + min;
    }

    public Clock(int min) {
        h = (min / 60) % 24;
        this.min = min % 60;
        gmin = h * 60 + this.min;
    }

    public Clock(String z) {
        String[] el = z.split(":");
        h = Integer.parseInt(el[0]);
        min = Integer.parseInt(el[1]);
        gmin = h * 60 + min;
    }

    public Clock add(int m) {
        int res = gmin + m;
        return new Clock(res);
    }

    public Clock add(Clock t) {
        // Weiterverarbeiten des Ergebnisses möglich:
        // Clock t = t1.add(t2).add(t3)
        int res = gmin + t.gmin;
        return new Clock(res);
    }

    public String toString() {
        String erg = "";
        erg += h + ":";
        if (min < 10)
            erg += "0";
        erg += min;
        return erg;
    }

    @Override
    public int compareTo(Clock other) {
        if (this.gmin < other.gmin) return -1;
        else if (this.gmin > other.gmin) return 1;
        else return 0;
    }

}