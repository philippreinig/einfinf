package Archive.Vorlesung;

public class WeirdXYZ {
    //xyz is calculating  ⌊ sqrt(x) ⌋
    static int xyz(int x) {
        int z = 0;
        int w = 1;
        int y = 1;

        while (w <= x) {
            z += 1;
            w += y + 2;
            y += 2;
        }
        return z;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": sqrt=" + Math.sqrt(i) + ", xyz=" + xyz(i));
        }

        /*
        System.out.println(xyz(1));
        int counterAmount = 50;

        int counter = 0;
        int temp;
        int currentNumber = 1;

        for (int i = 1; i <= counterAmount; i++) {
            temp=xyz(currentNumber+1);
            while(temp == xyz(currentNumber)){
                counter++;
                temp=xyz(currentNumber);
                currentNumber++;

            }
            System.out.println(i + ":" + counter);
            counter=0;

        }

         */
    }

}
