package Archive.exercises.ChristmasPresents;

public class Cylinder extends Present {
    private double height = 1; // in meters
    private double radius = 1; // in meters

    Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public String toString() {
        return "Cylinder: [height: " + height + ", radius: " + radius + "]";
    }

    @Override
    public double surface() {
        return 2 * Math.PI * Math.pow(this.radius, 2) + 2 * Math.PI * this.radius * height;
    }
}
