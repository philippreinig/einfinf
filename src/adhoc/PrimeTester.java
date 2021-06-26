package adhoc;

public class PrimeTester {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte genau eine Zahl übergeben!");
            return;
        }
        try {
            int zahl = Integer.parseInt(args[0]);
            if (zahl < 2) {
                System.out.println(zahl + " ist keine Primzahl!");
                return;
            }

            for (int i = 3; i * i <= zahl; i += 2) {
                if (zahl % i == 0) {
                    System.out.println(zahl + " ist keine Primzahl!");
                    return;
                }
            }
            System.out.println(zahl + " ist eine Primzahl!");
        } catch (NumberFormatException exception) {
            System.out.println("Bitte nur Zahlen eingeben!");
            return;
        }

    }
}
