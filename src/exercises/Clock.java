package exercises;

public class Clock {
    private int h;
    private int min;

    public int getMin() {
        return this.min;
    }

    public int getH() {
        return this.h;
    }

    public Clock(int h, int min) { //Normierung der Uhrzeit zu gültigen Angaben
        while (min >= 60) {
            h++;
            min -= 60;
        }
        this.h = h % 24;
        this.min = min;
    }

    public Clock(String time) {
        String[] timeArray = new String[2];
        timeArray = time.split(":");
        this.h = Integer.parseInt(timeArray[0]);
        this.min = Integer.parseInt(timeArray[1]);
        normalize();
    }

    public Clock add(int min) {
        return new Clock(this.h, this.min + min);


    }

    public Clock add(Clock otherClock) {

        return new Clock(this.h + otherClock.getH(), this.min + otherClock.getMin());
    }

    public String toString() {

        return this.h + ":" + this.min;
    }

    void normalize() {
        while (this.min >= 60) {
            this.min -= 60;
            this.h++;
        }
        this.h %= 24;
    }


    public static void main(String[] args) {


    }
}
