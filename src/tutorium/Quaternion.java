package tutorium;

public class Quaternion {
    //Values to describe a quaternion
    double a;
    double i;
    double j;
    double k;

    //Initializing the quaternion
    Quaternion(double a, double i, double j, double k) {
        this.a = a;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    //Method for getting value of A
    double getA() {
        return this.a;
    }

    //Method for getting value of I
    double getI() {
        return this.i;
    }

    //Method for getting value of J
    double getJ() {
        return this.j;
    }

    //Method for getting value of K
    double getK() {

        return this.k;
    }

    //Add to quaternions by adding the values of each component
    Quaternion add(Quaternion other) {
        this.a += other.getA();
        this.i += other.getI();
        this.j += other.getJ();
        this.k += other.getK();

        return this;
    }

    //Add to quaternions by substracting the values of each component
    Quaternion substract(Quaternion other) {
        this.a -= other.getA();
        this.i -= other.getI();
        this.j -= other.getJ();
        this.k -= other.getK();

        return this;
    }


    //Formula:  https://mathepedia.de/Quaternionen.html
    Quaternion multiply(Quaternion other) {
        double[] qThis = {this.getA(), this.getI(), this.getJ(), this.getK()};
        double[] qOther = {other.getA(), other.getI(), other.getJ(), other.getK()};
        this.a = qThis[0] * qOther[0] - qThis[1] * qOther[1] - qThis[2] * qOther[2] - qThis[3] * qOther[3];
        this.i = qThis[0] * qOther[1] + qThis[1] * qOther[0] + qThis[2] * qOther[3] - qThis[3] * qOther[2];
        this.j = qThis[0] * qOther[2] - qThis[1] * qOther[3] + qThis[2] * qOther[0] + qThis[3] * qOther[1];
        this.k = qThis[0] * qOther[3] + qThis[1] * qOther[2] - qThis[2] * qOther[1] + qThis[3] * qOther[0];

        return this;
    }

    // result = this * 1/other
    //diving qThis by qOther = qThis * 1/qOther and 1/qOther is the inverse of qOther
    Quaternion divide(Quaternion other) {
        this.multiply(other.getInverse());

        return this;
    }

    //Calculate the inverse
    //Formula: https://mathepedia.de/Quaternionen.html
    Quaternion getInverse() {
        double magnitudeSquared = Math.pow(this.getA(), 2) + Math.pow(this.getI(), 2) + Math.pow(this.getJ(), 2) + Math.pow(this.getK(), 2);
        Quaternion qConjugated = this.getConjugated();
        return new Quaternion(qConjugated.getA() / magnitudeSquared, qConjugated.getI() / magnitudeSquared, qConjugated.getJ() / magnitudeSquared, qConjugated.getK() / magnitudeSquared);
    }

    //Conjugated Quaternion has negative prefix
    Quaternion getConjugated() {
        return new Quaternion(this.a, -this.i, -this.j, -this.k);
    }

    //toString method to print Quaternion
    public String toString() {
        return ("(" + this.a + ", " + this.i + ", " + this.j + ", " + this.k + ")");
    }

    //main method for testing
    public static void main(String[] args) {
        /*
        Quaternion q1 = new Quaternion(1, 5, 10, 7);
        Quaternion q2 = new Quaternion(1, 2, 3, 4);

        System.out.println("q1: " + q1.toString());
        System.out.println("q2: " + q2.toString());

        q1.divide(q2);
        System.out.println("q1 divided by q2: " + q1.toString());

         */

        Quaternion q1 = new Quaternion(0, 0, 0, 0);  // entspricht der reellen 0
        Quaternion q2 = new Quaternion(0, 1, 1, 1);  // 0 + i + j + k
        Quaternion q3 = new Quaternion(0, 0, 1, 1);  // 0 +     j + k
        Quaternion q4 = new Quaternion(0, 0, 0, 1);  // 0         + k
        System.out.println(q1.add(q2).add(q3).add(q4));
        System.out.println("q1: " + q1.toString());

    }
}
