package exercises.Geometry;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public void translate(int dx, int dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }

    public String toString() {
        return a.toString() + " <-> " + b.toString() + " <-> " + c.toString();
    }

    public double perimeter() {
        return new Line(a, b).length() + new Line(b, c).length() + new Line(a, c).length();
    }
}

