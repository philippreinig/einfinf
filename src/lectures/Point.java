package lectures;

class Point {
    double x = 0;
    double y = 0;

    public Point(double x, double y) {
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean equals(Object other) {
        if (other instanceof Point) {
            Point q = (Point) other;
            return q.x == this.x && q.y == this.y;
        }
        return false;
    }

    public Object clone() {
        return new Point(this.x, this.y);
    }


    public static void main(String[] args) {


    }

}

