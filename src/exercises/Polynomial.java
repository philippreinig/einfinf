package exercises;

import java.util.Arrays;

public class Polynomial {
    private int degree; // highest power of x
    private final double[] coeffs; // Array with coefficients, all coefficients [0..degree] are necessary


    //Constructing polynomial
    public Polynomial(double[] c) {
        this.degree = c.length - 1;
        this.coeffs = c;
        for (int i = this.coeffs.length - 1; i >= 0; i--) {
            if (this.coeffs[i] == 0.0) this.degree--;
            else break;
        }
    }

    //Returns degree
    public int getDegree() {
        return this.degree;
    }

    //Returns coefficient at index i
    public double getCoefficient(int i) {
        return coeffs[i];
    }

    //Returns an array containing all coefficients
    public double[] getAllCoefficients() {
        return this.coeffs;
    }

    //Generates a string out of this.coeffs array
    public String toString() {
        String tempString = "";

        if (this.coeffs.length > 0 && coeffs[0] != 0.0) {
            if (this.coeffs.length > 1) tempString += coeffs[0] + "+";
            else tempString += coeffs[0];
        }

        if (this.coeffs.length > 1 && coeffs[1] != 0.0) {
            if (this.coeffs.length > 2) tempString += coeffs[1] + "*x+";
            else tempString += coeffs[1];
        }

        for (int i = 2; i < this.degree; i++) {
            tempString += coeffs[i] + "*x^" + i + "+";
        }

        if (this.degree > 2) tempString += coeffs[this.degree] + "*x^" + this.degree;
        return tempString;
    }

    //Evaluates polynomial for a value x
    public double evaluate(double x) {
        double sum = this.coeffs[this.coeffs.length - 1];
        int counter = 0;
        for (int i = this.coeffs.length - 2; i >= 0; i--) {
            sum = sum * x + this.coeffs[i];
        }
        //System.out.println(counter);

        return sum;
    }

    //Differentiates the polynomial
    public Polynomial differentiate() {
        if (this.coeffs.length <= 1) return new Polynomial(new double[0]);

        double[] diffCoeffs = new double[this.coeffs.length - 1];           //storing coeffs of derivative

        for (int i = 1; i < this.coeffs.length; i++) {                      //multiply each coeff with its power
            diffCoeffs[i - 1] = this.coeffs[i] * i;
        }

        return new Polynomial(diffCoeffs);
    }

    //Testing all methods
    public static void test(Polynomial p, int min, int max) {
        System.out.println("----- START OF TEST -----");
        System.out.println("Polynomial is: " + p.toString());
        System.out.println("As an array it's: " + Arrays.toString(p.getAllCoefficients()));
        System.out.println("Degree is: " + p.getDegree());
        for (int i = 0; i <= p.getDegree(); i++) {
            System.out.println("Coefficient at index " + i + " is " + p.getCoefficient(i));
        }
        System.out.println("Evaluating from " + min + " to " + max);
        for (int i = min; i < max + 1; i++) {
            System.out.println("Value for " + i + " is " + p.evaluate(i));
        }

        System.out.println("----- END OF TEST -----");
        System.out.println();

    }

    public static void main(String[] args) {
        double[] testCoeffs = {2, 0, 4};
        int min = -3;
        int max = 3;

        Polynomial p = new Polynomial(testCoeffs);

        test(p, min, max);

        for (int i = 1; i < testCoeffs.length; i++) {
            System.out.println("...Differentiating...");
            System.out.println();
            p = p.differentiate();
            test(p, min, max);
        }


    }
}