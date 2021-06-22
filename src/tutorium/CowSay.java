package tutorium;

public class CowSay {

    public static String eyes(String parameter) {               //Bestimmt Augen anhand des Parameters
        switch (parameter) {
            case "-e":
                return "oo";
            case "-d":
                return "XX";
            case "-g":
                return "$$";
            case "-p":
                return "@@";
            case "-s":
                return "**";
            case "-t":
                return "--";
            case "-w":
                return "00";
            case "-y":
                return "..";
            default:
                System.err.println("ERROR FOUND IN METHOD eyes() - INVALID PARAMETER ENTERED");         //Fehler - sollte nicht auftreten dürfen
                return "Error";
        }
    }

    public static void generationTextbox(int width, String text) {
        int amount_lines;                                                                           //Anzahl der Zeilen
        if (text.length() % width == 0)
            amount_lines = text.length() / width;                       //Test, ob alle Zeilen komplett augefüllt werden können
        else
            amount_lines = text.length() / width + 1;                                              //text.length()%width != 0, also ist eine weiter Zeile notwendig
        int textLength = text.length();
        int modulo = text.length() % width;
        String[] lines = new String[amount_lines];                                                  //Array, das die Zeilen speichert

        //Erstellung der Zeilen
        for (int i = 0; i < amount_lines; i++) {
            int start = i * width;                                                                  //Festlegung von Start und Ende, um Substrings von text zu erstellen
            int end = 0;
            if (modulo != 0) {                                                                      //Letzte Zeile wird nicht vollständig ausgefüllt
                if (i < amount_lines - 1) {
                    end = i * width + width;
                } else {
                    end = i * width + (text.length() % width);
                }
            } else {                                                                                //Letzte Zeile wird vollständig ausgefüllt
                end = i * width + width;
            }
            lines[i] = text.substring(start, end);                                                  //Jede Zeile ist ein Substring von text mit Zeilenanfang start und Zeilenende end
        }

        //Ausgabe der oberen Rahmenlinie
        System.out.print(" ");
        for (int j = 1; j <= width; j++) {
            System.out.print("_");
        }
        System.out.println();

        if (textLength < width) { //Checkt ob der eingegebene Text kleiner als die Breite ist -> gibt Text nur in einer Zeile aus
            System.out.print("|" + lines[0]);
            if (modulo != 0) {
                for (int j = 0; j < width - modulo; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println("|"); //oben
        } else {

            System.out.print("/" + lines[0]);
            System.out.println("\\"); //Ausgabe der obersten Zeile mit Text

            for (int i = 1; i < amount_lines - 1; i++) {
                System.out.println("|" + lines[i] + "|");
            } //Ausgabe der mittleren Zeilen mit Text

            System.out.print("\\" + lines[amount_lines - 1]);
            if (modulo != 0) {
                for (int j = 0; j < width - modulo; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println("/"); //Ausgabe der untersten Zeile mit Text
        }

        //Ausgabe der unteren Rahmenlinie
        System.out.print(" ");
        for (int j = 1; j <= width; j++) {
            System.out.print("-");
        }

    }

    public static void generationCow(String eyes, boolean tongue) {
        //Erstellt Kuh in einzelnen Zeilen
        System.out.println();
        System.out.println("       \\   ^__^");
        System.out.println("        \\  (" + eyes + ")\\_______");
        System.out.println("           (__)\\       )\\/\\");
        if (tongue) {
            System.out.println("            " + "U" + "  ||----w |");
        } else {
            System.out.println("            " + "   ||----w |");
        }
        System.out.println("               ||     ||");

    }

    public static void main(String[] args) {
        int width;
        boolean tongue;
        String eyes = "";
        String text = "";
        //Einlesen der Parameter

        if (args.length < 2) {
            System.err.println("INVALID AMOUNT OF PARAMETERS ENTERED! AT LEAST 2 ARE NECESSARY [EYES AND TEXT]");
            System.exit(-1);
        } //Prüft ob es weniger als 2 Parameter sind

        try {
            if (isInteger(args[0])) {
                System.err.println("WIDTH WAS ENTERED WITHOUT SPECIFICATION '-W' IN FRONT OF IT!");
                System.exit(-1);
            }
            //Wenn dieser Teil vom code genutzt wird wurde die breite als Parameter eingegeben

            width = Integer.parseInt(args[1]);
            tongue = args[2].equals("-T");
            if (args.length == 4) {                   //if-Bedingungem zur Bestimmung der einzelnen Variablen
                eyes = args[2];
            } else if (args.length == 5) {
                if (tongue == true) eyes = args[3];
                else if (args[2].equals("-e")) {
                    eyes = args[3];
                }
            } else if (args.length == 6) { //tongue = true,
                eyes = args[4];
            }
            text = args[args.length - 1];

        } catch (NumberFormatException nfe) {
            //width wurde nicht eingegeben

            width = 40;
            tongue = args[0].equals("-T");
            if (args.length == 3) {

                if (args.length == 2) {                  //if-Bedingungem zur Bestimmung der einzelnen Variablen
                    eyes = args[0];
                } else if (args.length == 3) {
                    if (tongue == true) eyes = args[1];
                    else if (args[0].equals("-e")) eyes = args[1];
                } else if (args.length == 4) {
                    eyes = args[2];
                } else System.out.println("=???");
                text = args[args.length - 1];
            }
        }

        if (eyes.length() != 2) {
            System.err.println("Invalid parameter for eyes! Has to be 2 characteres long and either '-e', '-b', '-d', '-g', '-p', '-s', '-t' or '-w'!");
            System.exit(-1);
        } //prüft ob eyes ein richtiger parameter ist


        /**
         if (!(eyes.equals("-e") || eyes.equals("-b") || eyes.equals("-d") || eyes.equals("-g") || eyes.equals("-p") || eyes.equals("-s") || eyes.equals("-t") || eyes.equals("-w"))){
         System.err.println("Invalid parameter for eyes! Has to be '-e', '-b', '-d', '-g', '-p', '-s', '-t' or '-w'!");
         System.exit(-1);
         }
         **/

        if (width < 1) {
            System.err.println("Width entered has to be at least 1!");
            System.exit(-1);
        }//prüft ob width kleiner 1 ist


        if (eyes.equals("-d") || eyes.equals("-s")) tongue = !tongue; //


        generationTextbox(width, text);
        if ((eyes.equals("-e") || eyes.equals("-b") || eyes.equals("-d") || eyes.equals("-g") || eyes.equals("-p") || eyes.equals("-s") || eyes.equals("-t") || eyes.equals("-w"))) {
            generationCow(eyes(eyes), tongue);
        } else generationCow(eyes, tongue);


        test();

    }

    //Checkt ob der eingegebene Parameter eine Zahl ist
    public static boolean isInteger(String parameter) {
        try {
            Integer.parseInt(parameter);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void test() {
        int width = 10;
        String eyes = "-g";
        boolean tongue = false;
        String text = "Lorem ipsum dolor si";

        for (int i = 2; i <= width; i++) {
            generationTextbox(i, text);
            generationCow(eyes(eyes), tongue);
        }
    }
}