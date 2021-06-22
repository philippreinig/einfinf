package Archive.math;


public class Mathe42 {

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for (int i : array) {
            if (i == v) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static int[] gimmeFilledArray(int modulo, int rest) {
        int[] tempWerteTabelle = new int[(53 - rest) / modulo];
        int value = 53;
        for (int i = 1; !(tempWerteTabelle[tempWerteTabelle.length - 1] == 53); i++) {
            tempWerteTabelle[i - 1] = modulo * i + rest;
        }
        return tempWerteTabelle;
    }

    public static void main(String[] args) {

        int[] wertetabelle1 = gimmeFilledArray(7, 4);
        int[] wertetabelle2 = gimmeFilledArray(5, 3);
        int[] wertetabelle3 = gimmeFilledArray(3, 2);
        int[] wertetabelle4 = gimmeFilledArray(2, 1);

        for (int element : wertetabelle1) {
            System.out.print(element + "    ");
        }
        System.out.println();
        for (int element : wertetabelle2) {
            System.out.print(element + "    ");
        }
        System.out.println();
        for (int element : wertetabelle3) {
            System.out.print(element + "    ");
        }
        System.out.println();
        for (int element : wertetabelle4) {
            System.out.print(element + "    ");
        }

        System.out.println();
        for (int element : wertetabelle1) {
            if (contains(wertetabelle2, element) && contains(wertetabelle3, element) && contains(wertetabelle4, element)) {
                System.out.println(element);
            }
        }


/*
        for (int i=-1000;i<1000;i++){
            if ((Math.floorMod(i,2)==1) && (Math.floorMod(i,3)==2) && (Math.floorMod(i,5)==3) && (Math.floorMod(i,7)==4)){
                System.out.println(i);
            }
        }
        */

    }
}