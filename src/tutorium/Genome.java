package Archive.Tutorium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Genome {
    public static void main(String[] args) {
        try {
            //catch error if no or multiple file paths are submitted
            if (args.length != 1) {
                System.err.println("Bitte genau ein Dateipfad!");
                return;
            }

            //read file to string text using scanner
            Scanner scanner = new Scanner(new File(args[0]));
            String text = "";
            text += scanner.next();

            //variable initialization
            boolean gen_found = false;
            int counter_genes = 0;

            //Reading through the file searching for a start codon
            for (int i = 0; i < text.length() - 2; i += 3) {       //iteration with every third value of i
                String codon = String.valueOf(text.charAt(i)) + text.charAt(i + 1) + text.charAt(i + 2);        //concatenating 3 letters to one codon
                if (codon.equals("atg")) {      //start codon found
                    gen_found = true;
                    int j;
                    for (j = i; gen_found; j += 3) {      //iterating until a stop codon is found and printing each gen to the console
                        codon = String.valueOf(text.charAt(j)) + text.charAt(j + 1) + text.charAt(j + 2);
                        System.out.print(codon);
                        if (codon.equals("tag") || codon.equals("tga") || codon.equals("taa")) {        //returning to outer for loop if a stop codon is found
                            System.out.println();       //entering the next line after a complete gen is found
                            gen_found = false;
                            counter_genes++;       //counting found genes
                        }
                    }
                    i = j;      //going on where inner for loop stopped
                }
            }

            System.out.println(counter_genes + " Gene gefunden");      //printing amount of found genes
        } catch (FileNotFoundException fnf) {       //catch error if file path is invalid
            System.err.println("Ungültiger Dateipfad!");
        }
    }
}