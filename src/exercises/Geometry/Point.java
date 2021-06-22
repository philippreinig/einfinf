package Archive.exercises.Geometry;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
    }

}
