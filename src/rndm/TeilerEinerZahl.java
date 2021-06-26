package rndm;

public class TeilerEinerZahl {
    public static void main(String[] args) {
        int[] array = new int[0];
        if (args.length != 1) {
            System.out.println("Bitte genau eine Zahl übergeben!");
            return;
        }

        try {
            int entry = Integer.parseInt(args[0]);
            for (int i = 2; i < entry; i++) {
                if (entry % i == 0) {
                    System.out.println(i);
                }
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Bitte nur Zahlen eingeben!");
            return;
        }

    }


}
