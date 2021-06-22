package Archive.rndm;

import java.util.Arrays;

public class StichprobenBerechnungen {
    public static double aMittel(int[] array) {             //Arithmetisches Mittel
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }

public static double spv(int[] values) {                    //Stichprobenvarianz

        double aMittel = aMittel(values);
        double sum = 0;
        for (int value : values) sum += Math.pow(value - aMittel, 2);

        return (double) 1 / (values.length - 1) * sum;
    }

    public static double spsaw(double value) {                                          //Stichprobenstandardabweichung
        return Math.sqrt(value);
    }

    public static double skv(int[] daten1, int[] daten2) {                              //Stichprobenkovarianz
        if (daten1.length != daten2.length) {
            System.err.println("ERROR!!");
            return 0.0;
        }

        double aMittel1 = aMittel(daten1);
        double aMittel2 = aMittel(daten2);

        double sum = 0.0;

        for (int i = 0; i < daten1.length; i++) {
            sum += (daten1[i] - aMittel1) * (daten2[i] - aMittel2);
        }

        return (double) 1 / (daten1.length - 1) * sum;

    }

    static public double pkk (double spsaw1, double spsaw2, double skv1){           //Pearsonskorrelationskoeffizient
        return skv1/(spsaw1*spsaw2);

    }

    public static void main(String[] args) {
        int[] values1 = {5, 13, 17, 20, 21, 18, 16, 12, 6};
        int[] values2 = {358, 425, 446, 483, 461, 391, 371, 345, 348};
        double spv1 = spv(values1);                                                 //Stichprobenvarianz 1
        double spsaw1 = spsaw(spv1);                                                //Stichprobenstandardabweichung 1

        double spv2= spv(values2);                                                  //Stichprobenvarianz 2
        double spsaw2 = spsaw(spv2);                                                //Stichprobenstandardabweichung 2

        double skv = skv(values1, values2);                                         //Stichprobenkovarianz
        double pkk = pkk(spsaw1, spsaw2, skv);                                      //Pearsonskorrelationskoeffizient

        double bstern = skv/spv1;
        double astern = aMittel(values2)-bstern*aMittel(values1);

        System.out.println("spv: Stichprobenvarianz / spsaw: Stichprobenstandardabweichung / skv: Stichprobenkovarianz / pkk: Pearsonskorrelationskoeffizient ");

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("spv1 von " + Arrays.toString(values1) + " ist " + spv1);
        System.out.println("spsaw1 von " + Arrays.toString(values1) + " ist " + spsaw1);

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("spv2 von " + Arrays.toString(values2) + " ist " + spv2);
        System.out.println("spsaw2 von " + Arrays.toString(values2) + " ist " + spsaw2);

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("skv von " + Arrays.toString(values1) + " und " + Arrays.toString(values2) + " ist " + skv);
        System.out.println("pkk von " + Arrays.toString(values1) + " und " + Arrays.toString(values2) + " ist " + pkk);

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("b* ist " + bstern);
        System.out.println("a* ist " + astern);




    }

}
