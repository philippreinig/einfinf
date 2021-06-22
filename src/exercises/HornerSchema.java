package Archive.exercises;

 /*
    3)
    Es werden für evalSimple 0+1+2+3+4+...+(n-1) = (n+1) * (n/2) = (n^2+n)/2 Multiplikationen zur Berechnung benötigt
    Es werden für evalHornerRec nur n-1 Multiplikationen zur Berechnung benötigt. Die Methode ist also vor allem für lange Polynome wesentlich effizienter

*/

public class HornerSchema {
    //Berechnung von Potenzen
    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) result *= base;
        return result;
    }

    //Naive Auswertung
    public static double evalSimple(double[] a, double x) {
        int counterMultiplications = 0;
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * power(x, i);
            counterMultiplications += i;
        }
        System.out.println("Zur Berechnung mit der evalSimple Methode wurden " + counterMultiplications + " Multiplikationen benötigt");
        return sum;
    }

    //Auswertung mit Hornerschema
    public static double evalHorner(double[] a, double x) {
        double sum = a[a.length - 1];
        int counter = 0;
        for (int i = a.length - 2; i >= 0; i--) {
            sum = sum * x + a[i];
            counter++;
        }
        //System.out.println(counter);

        return sum;
    }


    //Aufruf einer Hilfsmethode
    public static double evalHornerRec(double[] a, double x) {
        return evalHornerRec(a, x, 0);
    }

    //Rekursive Auswertung mit Hornerschema
    private static double evalHornerRec(double[] a, double x, int n) {
        double partResult;
        if (n == a.length - 1) {
            return a[n];
        } else {
            partResult = evalHornerRec(a, x, n + 1);
        }
        return partResult * x + a[n];
    }


    public static void main(String[] args) {
        double[] x = {3, -4, 5};
        System.out.println("evalsimple: " + evalSimple(x, 1));
        System.out.println("evalHorner: " + evalHorner(x, 1));
        System.out.println("evalHornerRec: " + evalHornerRec(x, 1));


    }
}