package Archive.Tutorium;

public class Percolation {

    //Generating a medium as a 2D-array with width "x" and length "y" and blocking each cell with probability "probability"
    public static boolean[][] createMedium(int x, int y, double probability) {

        boolean[][] medium = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (Math.random() > probability) medium[i][j] = true;
            }
        }
        return medium;
    }

    //Method for printing the current state of the medium to the console - can either be filled with water or empty
//    public static void printMedium(boolean[][] medium, boolean filled) {
//        if (filled) {
//            for (int i = 0; i < medium.length; i++) {
//                for (int j = 0; j < medium[i].length; j++) {
//                    if (medium[i][j]) {
//                        System.out.print("[ww]");
//                    } else if (medium[i][j] == false) {
//                        System.out.print("[  ]");
//                    } else {
//                        System.err.print("ERROR!!");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println("----------------------------------------");
//        } else {
//            for (int i = 0; i < medium.length; i++) {
//                for (int j = 0; j < medium[i].length; j++) {
//                    if (medium[i][j]) {
//                        System.out.print("[  ]");
//                    } else if (medium[i][j] == false) {
//                        System.out.print("[==]");
//                    } else {
//                        System.err.print("ERROR!!");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println("----------------------------------------");
//        }
//    }

    //Filling the medium from every cell in the top row
    public static boolean[][] fillMedium(boolean[][] medium) {
        boolean[][] filledMedium = new boolean[medium.length][medium[0].length];
        for (int j = 0; j < medium.length; j++) {       //Iterating over the top row
            fill(medium, filledMedium, 0, j);        // Calling method fill to simulate flowing water
        }
        return filledMedium;
    }

    //Simulating the flow of water to all open/unblocked cells from the cell with coordinates x and y
    public static void fill(boolean[][] medium, boolean[][] filledMedium, int x, int y) {
        /*
        try{
            boolean temp = medium[x][y];
        }catch (ArrayIndexOutOfBoundsException AIUOBE){
            return;
            // x or y is outside the array boundaries
        }
        */

        //[Zeile [Spalte 1, Spalte 2]]

        if (x < 0 || y > medium[0].length - 1 || y < 0 || x > medium.length - 1) return;

        if (!medium[x][y]) return;           // cell is blocked -> water cant flow here
        if (filledMedium[x][y]) return;            // cell is already filled with water


        filledMedium[x][y] = true;

        //Calling method recursively to try to fill each surrounding cell
        fill(medium, filledMedium, x + 1, y);   // cell below
        fill(medium, filledMedium, x, y + 1);   // cell to the right
        fill(medium, filledMedium, x, y - 1);   // cell to the left
        fill(medium, filledMedium, x - 1, y);   // cell above
    }

    //checks if there is water in the bottom row to check if the medium is percolating
    public static boolean checkPercolation(boolean[][] medium) {
        boolean[] lastRow = medium[medium.length - 1];
        for (boolean element : lastRow) {
            if (element) return true;
        }
        return false;
    }

    //Runs "amountOfSimulations" simulations and returns how many of the created mediums are percolating
    public static double Statistics(int length, int width, double probability, int amountOfSimulations) {
        double counter = 0.0;
        for (int i = 0; i < amountOfSimulations; i++) {
            boolean[][] medium = createMedium(length, width, probability);
            //printMedium(medium, false);
            boolean[][] filledMedium = fillMedium(medium);
            //printMedium(filledMedium, true);
            if (checkPercolation(filledMedium)) counter++;
        }
        return counter / (double) amountOfSimulations;
    }


    public static void main(String[] args) {
        //Catching potential errors

        //Amount of parameters != 4
        if (args.length != 4) {
            System.out.println("Ungültige Anzahl an Eingaben!");
            return;
        }
        //Invalid parameters entered
        try {
            int length = Integer.parseInt(args[0]);
            int width = Integer.parseInt(args[1]);
            double probability = Double.parseDouble(args[2]);
            int amountOfSimulations = Integer.parseInt(args[3]);

            if (width <= 0 || length <= 0 || probability <= 0 || amountOfSimulations <= 0) {
                System.out.println("Eingegebene Werte für Länge, Breite, Wahrscheinlichkeit und Anzahl der Simulationen muss > 0 sein");
                return;
            }

            if (probability > 1) {
                System.out.println("Eingegebene Wahrscheinlichkeit ist größer als 1");
                return;
            }

            //Prints the result for the entered parameters
            System.out.println("For " + amountOfSimulations + " simulations the probability for a " + length + "x" + width + " matrix, in which each cell is blocked with a chance of " + probability + " to be percolating is: " + Statistics(length, width, probability, amountOfSimulations));
            System.out.println("----------------------------------------------");
            //Prints the results for simulating with different probabilities


            for (double i = 0.0; i <= 1.01; i += 0.01) {
                double probability2 = Math.round(i * 100.0) / 100.0;
                System.out.println("For " + amountOfSimulations + " simulations the probability for a " + length + "x" + width + " matrix, in which each cell is blocked with a chance of " + probability2 + " to be percolating is: " + Statistics(length, width, probability2, amountOfSimulations));
            }

            //System.out.println(checkedCells.length);


        } catch (NumberFormatException nfe) {
            System.out.println("Fehlerhafte Eingabe");
        }
    }
}