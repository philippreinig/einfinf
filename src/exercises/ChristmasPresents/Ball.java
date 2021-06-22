package Archive.exercises.ChristmasPresents;

public class Ball extends Present {
    private double radius = 1; // in meters

    Ball(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Ball [radius: " + this.radius + "]";
    }

    @Override
    public double surface() {
        return 4 * Math.pow(this.radius, 2) * Math.PI;
    }

}