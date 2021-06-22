package Archive.math;

public class ArithmetischesMittel {

    public static double AMI(int[] array) {      //Iterative Ermittlung des Arithmetischen Mittels
        double sum = 0;

        for (int element : array) {
            sum += element;
        }
        return sum / array.length;

    }

    public static double AMR(int[] array) {
        return AMR(array, 0.0);

    }

    public static int counter = 0;

    public static double AMR(int[] array, double sum) {      //Rekursive Ermittlung des Arithmetischen Mittels
        double summand = sum + (double) array[counter] / array.length;
        if (counter == array.length - 1) return summand;
        else {
            counter++;
            return AMR(array, summand);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 2, 3, 4, 5};

        System.out.println(AMI(array));
        System.out.println(AMR(array));

    }
}
