package Archive.exercises;

import java.util.Arrays;

// Rule for derivative of polynom: y=x^n, y'=n*x^(n-1)

public class DifferentialPolynom {
    public static double[] diffPoly(double[] coeffs) {
        if (coeffs.length <= 1) return new double[0];                  //constant polynom or no coeffs entered

        double[] diffCoeffs = new double[coeffs.length - 1];           //storing coeffs of deriavtive

        for (int i = 1; i < coeffs.length; i++) {                      //multiply each coeff with its power
            diffCoeffs[i - 1] = coeffs[i] * i;
        }

        return diffCoeffs;
    }


    public static void main(String[] args) {

        double[] coeffs = {5};
        String diffCoeffs = Arrays.toString(diffPoly(coeffs));
        System.out.println(diffCoeffs);


        System.out.println("---------------------Beginning of test---------------------");
        int amount_test_cases = 3;
        int amount_coeffs = 5;
        double range_coeffs_max = 10;
        double range_coeffs_min = -10;

        test(amount_test_cases, amount_coeffs, range_coeffs_max, range_coeffs_min);
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