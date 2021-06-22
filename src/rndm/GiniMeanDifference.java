package Archive.rndm;

public class GiniMeanDifference {
    public static void main(String[] args) {
        int[] array ={4400,3400,1800,5600,2300,4100,27400};
        int sum=0;
        double n=7;
        double quotient = 1d/(n*(n-1));
        for (int i=0;i<n;i++){
            for (int j=0; j<n;j++){
                int summand1 = array[i];
                int summand2 = array[j];
                sum+=Math.abs(summand1-summand2);
                //System.out.println("Die Summe nach der "+ counter + ". Berechnung ist: " + sum);

            }

        }
        double result = quotient*sum;
        System.out.println("Die Gini-Mean-Differenz ist: " + result);
        System.out.println("Der Gini-Mean-Koeffizient ist in Prozent: " + result/14000*100);

    }
}
