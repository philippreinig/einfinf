package Archive.Vorlesung;

public class Heron {

    public static void main(String[] args) {

        int volume = Integer.parseInt(args[0]);
        float a = 1;
        float b = volume;
        float diff = Math.abs(b - a);
        while (diff > 0.001) {
            b = volume / a;
            a = (a + b) / 2;
            diff = Math.abs(b - a);
        }
        System.out.println("Die Wurzel von " + volume + " liegt zwischen " + a + " und " + b);


    }
}
