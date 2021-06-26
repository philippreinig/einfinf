package exercises;

public class PrimeTwins {

    //Teste, ob eine Zahl eine Primzahl ist
    public static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number < 2) {       //Es existieren keine Primzahlen kleiner 2
            return false;
        }
        for (int i = 2; i < number; i++) {      //Iteriert über alle möglichen Teiler von number
            if (number % i == 0) {              //Wird ein Teiler von number gefunden, kann es sich um keine Primzahl handeln
                isPrime = false;
            }
        }

        return isPrime;
    }

    public static int[][] primeTwins(int amount) {
        int[][] matrix = new int[amount][2];     //Erstellung der Matrix

        int foundPrimeTwins = 0;

        for (int i = 2; foundPrimeTwins < amount; i++) {
            if (isPrime(i) && isPrime(i + 2)) {       //Prüft, ob eine Zahl eine Primzahl ist und ob ein Primzahlzwilling existiert
                matrix[foundPrimeTwins][0] = i;
                matrix[foundPrimeTwins][1] = i + 2;
                foundPrimeTwins++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        //Aufruf der Methode
        int amount = 10;
        int[][] matrix = primeTwins(amount);

        //Ausgeben der Matrix
        System.out.println("p--q");
        for (int p = 0; p < matrix.length; p++) {
            for (int q = 0; q < 2; q++) {
                System.out.print(matrix[p][q] + " ");
            }
            System.out.println();
        }
    }
}
