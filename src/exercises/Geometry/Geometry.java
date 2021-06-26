package exercises.Geometry;

class Geometry {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void print(String text, String color) {
        /*
        String textColor = switch (color) {
            case ("black") -> ANSI_BLACK;
            case ("red") -> ANSI_RED;
            case ("green") -> ANSI_GREEN;
            case ("yellow") -> ANSI_YELLOW;
            case ("blue") -> ANSI_BLUE;
            case ("purple") -> ANSI_PURPLE;
            case ("cyan") -> ANSI_CYAN;
            case ("white") -> ANSI_WHITE;
            default -> ANSI_RESET;
        };


         */

        String textColor;
        switch (color) {
            case ("black"):
                textColor = ANSI_BLACK;
                break;
            case ("red"):
                textColor = ANSI_RED;
                break;
            case ("green"):
                textColor = ANSI_GREEN;
                break;
            case ("yellow"):
                textColor = ANSI_YELLOW;
                break;
            case ("blue"):
                textColor = ANSI_BLUE;
                break;
            case ("purple"):
                textColor = ANSI_PURPLE;
                break;
            case ("cyan"):
                textColor = ANSI_CYAN;
                break;
            case ("white"):
                textColor = ANSI_WHITE;
                break;
            default:
                textColor = ANSI_RESET;
                break;
        }


        System.out.println(textColor + text + ANSI_RESET);
    }

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static void main(String[] args) {
        print("--- Points ---", "red");
        Point a = new Point(1, 7);
        Point b = new Point(-5, 20);
        Point c = new Point(-3, 11);
        print("Point a: " + a.toString(), "green");
        print("Point b: " + b.toString(), "green");
        print("Point c: " + c.toString(), "green");

        print("--- Lines ---", "red");
        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line ac = new Line(a, c);
        print("Line ab: " + ab.toString(), "yellow");
        print("Line bc: " + bc.toString(), "yellow");
        print("Line cb: " + ac.toString(), "yellow");
        print("Length of ab: " + ab.length(), "yellow");
        print("Length of bc: " + bc.length(), "yellow");
        print("Length of cb: " + ac.length(), "yellow");

        print("--- Triangle ---", "red");
        Triangle abc = new Triangle(a, b, c);
        print("Triangle abc: " + abc.toString(), "purple");
        print("Perimeter of abc: " + abc.perimeter(), "purple");

        print("--- Beginning of randomized tests for points ---", "red");

        int amountTestCases = 5;
        int min = -100;
        int max = 100;
        for (int i = 1; i <= amountTestCases; i++) {
            Point tempPoint = new Point(randomInt(min, max), randomInt(min, max));
            print("Random point " + i + ": " + tempPoint.toString(), "green");

            int dx = randomInt(min, max);
            int dy = randomInt(min, max);

            tempPoint.translate(dx, dy);
            print("After random translation with dx=" + dx + " and dy= " + dy + " the random point is located at: " + tempPoint.toString(), "cyan");
        }

        print("--- Beginning of randomized tests for lines ---", "red");


        for (int i = 1; i <= amountTestCases; i++) {
            Point tempStart = new Point(randomInt(min, max), randomInt(min, max));
            Point tempEnd = new Point(randomInt(min, max), randomInt(min, max));
            Line tempLine = new Line(tempStart, tempEnd);

            print("Random point " + i + ": " + tempLine.toString(), "green");

            int dx = randomInt(min, max);
            int dy = randomInt(min, max);

            tempLine.translate(dx, dy);
            print("After random translation with dx=" + dx + " and dy= " + dy + " the random line is located at: " + tempLine.toString(), "cyan");
        }

        print("--- Beginning of randomized tests for triangles ---", "red");

        for (int i = 1; i <= amountTestCases; i++) {
            Point tempA = new Point(randomInt(min, max), randomInt(min, max));
            Point tempB = new Point(randomInt(min, max), randomInt(min, max));
            Point tempC = new Point(randomInt(min, max), randomInt(min, max));

            Triangle tempTriangle = new Triangle(tempA, tempB, tempC);

            print("Random triangle " + i + ": " + tempTriangle.toString(), "green");

            int dx = randomInt(min, max);
            int dy = randomInt(min, max);

            tempTriangle.translate(dx, dy);
            print("After random translation with dx=" + dx + " and dy= " + dy + " the random line is located at: " + tempTriangle.toString(), "cyan");
        }
    }

}