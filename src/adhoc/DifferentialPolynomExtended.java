package Archive.Adhoc;

import java.util.Arrays;

// Rule for derivate of polynom: y=x^n, y'=n*x^(n-1)

public class DifferentialPolynomExtended {

    public static double[] diffPoly(double[] coeffs) {
        if (coeffs.length <= 1) return new double[0];                       //constant polynom or no coeffs entered

        double[] diffCoeffs = new double[coeffs.length - 1];               //storing coeffs of deriavtive

        for (int i = 1; i < coeffs.length; i++) {                               //multiply each coeff with its power
            diffCoeffs[i - 1] = coeffs[i] * i;
        }

        return diffCoeffs;
    }

    public static double[] diffPoly(double[] coeffs, int n) {
        double[] diffCoeffs = coeffs;

        for (int i = 0; i < n; i++) {
            if (diffCoeffs.length == 0) {
                System.out.println("Keine weitere Ableitung möglich!");
                return new double[0];
            }
            diffCoeffs = diffPoly(diffCoeffs);


        }
        return diffCoeffs;
    }

    public static double intPoly(double[] coeffs, double x0, double x1) {
        double[] integral = new double[coeffs.length + 1];

        //Erstellt Aufleitung
        for (int i = 1; i < coeffs.length + 1; i++) {
            //if(i == 0) integral[0] = 0;
            integral[i] = (coeffs[i - 1] / i);
        }


        System.out.println("Aufleitung: " + java.util.Arrays.toString(integral));

        double testX0 = 0;
        for (int i = 0; i < integral.length; i++) {
            testX0 = testX0 * x0 + integral[i];
        }

        double testX1 = 0;

        for (int i = 0; i < integral.length; i++) {
            testX1 = testX1 * x1 + integral[i];
        }

        double intPoly = testX1 - testX0;

        return intPoly;
    }


    public static void main(String[] args) {

        double[] test = {0, 0, 0, 1};
        //System.out.println(Arrays.toString(diffPoly(test, 1)));

        System.out.println(intPoly(test, -1, 1));





        /*
        double[] coeffs = {5};
        String diffCoeffs = Arrays.toString(diffPoly(coeffs));
        System.out.println(diffCoeffs);


        System.out.println("---------------------Beginning of test---------------------");
        int amount_test_cases = 3;
        int amount_coeffs = 5;
        double range_coeffs_max = 10;
        double range_coeffs_min = -10;

        test(amount_test_cases, amount_coeffs, range_coeffs_max, range_coeffs_min);
          */
    }


    public static void test(int amount_test_cases, int amount_coeffs, double range_coeffs_max, double range_coeffs_min) {
        for (int i = 0; i < amount_test_cases; i++) {
            double[] coeffs = new double[amount_coeffs];
            for (int j = 0; j < amount_coeffs; j++) {
                coeffs[j] = Math.random() * (range_coeffs_max - range_coeffs_min) + range_coeffs_min;
            }
            double[] diffCoeffs = diffPoly(coeffs);
            System.out.println("The diverative for coeffs " + Arrays.toString(coeffs) + " is " + Arrays.toString(diffCoeffs));

        }

    }
}