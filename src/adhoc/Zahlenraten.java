package Archive.Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Zahlenraten {

    public static boolean checkAnswer(String input) {
        return input.equals("y") || input.equals("n");
    }

    public static void questioning(int min, int max) throws IOException {
        Scanner br = new Scanner(System.in);
        int mid = (min + max) / 2;
        System.out.println("Ist deine Zahl gleich " + mid + "? [y/n]");
        String answer = br.nextLine();

        if (!checkAnswer(answer)) {
            System.out.println("Ungültige Eingabe!");
            System.exit(-1);
        }

        if (answer.equals("y")) {
            System.out.println("Deine Zahl ist also " + mid);
        } else {
            System.out.println("Ist deine Zahl größer als " + mid + "? [y/n]");
            String answer2 = br.nextLine();
            if (answer2.equals("y")) {
                int min_new = mid + 1;
                System.out.println("Deine Zahl ist also aus dem Intervall " + min_new + " -> " + max);
                questioning(min_new, max);
            } else {
                int max_new = mid - 1;
                System.out.println("Deine Zahl ist also aus dem Intervall " + min + " -> " + max_new);
                questioning(min, max_new);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("In welchem Bereich ist deine Zahl? Bitte gib zunächst die untere Grenze an.");
        int min = Integer.parseInt(br.readLine());
        System.out.println("Und was ist die obere Grenze?");
        int max = Integer.parseInt(br.readLine());
        if (max < min) {
            System.out.println("Ungültiges Intervall! Deine obere Grenze ist kleiner als die untere Grenze!");
            System.exit(-1);
        }
        System.out.println("Dein Intervall ist also: " + min + " -> " + max);
        questioning(min, max);


    }

}