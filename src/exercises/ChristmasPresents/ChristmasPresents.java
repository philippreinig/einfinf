package Archive.exercises.ChristmasPresents;

public class ChristmasPresents {
    static final double price = 2.7;

    static double round(double x) {
        return Math.round(x * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(1, 2);
        double cylinderPaperSize = cylinder.computePaperSize();
        double cylinderPaperPrice = round(cylinderPaperSize * price);
        System.out.println(cylinder.toString());
        System.out.println("Amount of paper needed for cylinder is: " + cylinderPaperSize + "m2");
        System.out.println("Price of paper for cylinder is: " + cylinderPaperPrice + "€");

        System.out.println("-----------------");

        Ball ball = new Ball(5);
        double ballPaperSize = ball.computePaperSize();
        double ballPricePaper = round(ballPaperSize * price);
        System.out.println(ball.toString());
        System.out.println("Amount of paper needed for ball is: " + ballPaperSize + "m2");
        System.out.println("Price of paper for ball is: " + ballPricePaper + "€");

        System.out.println("-----------------");

        Cuboid cuboid = new Cuboid(10, 10, 10);
        double cuboidPaperSize = cuboid.computePaperSize();
        double cuboidPricePaper = round(cuboidPaperSize * price);
        System.out.println(cuboid.toString());
        System.out.println("Amount of paper needed for cuboid is: " + cuboidPaperSize + "m2");
        System.out.println("Currently there are " + Present.getCounter() + " presents.");
        System.out.println("Price of paper for cuboid is: " + cuboidPricePaper + "€");

        System.out.println("-----------------");
        System.out.println("There are " + Present.getCounter() + " presents.");


    }
}
