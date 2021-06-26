package exercises;

public class HeronKubik {

    public static void main(String[] args) {

        try {
            //Abbruch bei mehreren oder keinem Eingabeparameter
            if (args.length != 1) {
                System.out.println("Bitte genau eine Zahl übergeben!");
                return;
            }
            //Eingabeparameter als Volumen des Kubus entgegennehmen
            int volume = Integer.parseInt(args[0]);

            //Seiten des Kubus
            double x = 1;
            double y = volume;
            double z = x;
            double eps = 0.000000000000001;

            //Arithmetisches Mittel der 3 Seiten berechnen
            double average = (x + y + z) / 3;

            //Mittlere absolute Abweichung vom arithmetischen Mittel berechnen
            double diff = (Math.abs((x - average)) + Math.abs((y - average)) + Math.abs(z - average)) / 3;

            //Algorithmus zur Annäherung der Kubikwurzel

            while (diff > eps) { //Schleife, solange bis gewünschte Genauigkeit erreicht ist
                x = (y + x + z) / 3;
                z = x;
                y = volume / (x * z);
                diff = (Math.abs((x - x)) + Math.abs((y - x)) + Math.abs(z - x)) / 3;
            }
            //Ausgabe des Ergebisses
            System.out.println("Die Kubikwurzel von " + volume + " liegt zwischen " + x + " und " + y);
        } catch (NumberFormatException nfe) {
            System.out.println("Bitte nur ganze Zahlen eingeben");
            return;
        }


    }
}
