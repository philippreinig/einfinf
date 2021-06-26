package exercises.Geometry;


class Line implements Movable {
    private final Point start;
    private final Point end;
    // TODO: toString, length, translate

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public String toString() {
        return this.start.toString() + " -> " + this.end.toString();
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    public double length() {
        return this.start.distance(this.end);
    }

    @Override
    public void translate(int dx, int dy) {
        start.translate(dx, dy);
        end.translate(dx, dy);
    }

}

