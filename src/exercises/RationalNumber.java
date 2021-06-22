package Archive.exercises;

public class RationalNumber implements Comparable<RationalNumber> {
    //Numerator and Denominator of a rational number
    private int num;
    private int denom;

    //Constructing a rational number: denominator has to be != 0 and reducing it if possible
    public RationalNumber(int n, int d) {
        if (d == 0) {
            System.err.println("ERROR! DENOMINATOR IS 0!");
            System.exit(-1);
        }
        reduce(n, d);
    }

    //Method to reduce a rational number
    public void reduce(int n, int d) {
        for (int i = Math.abs(n); i > 1; i--) {
            if ((n % i == 0) && (d % i == 0)) {
                n /= i;
                d /= i;
                i++;
            }
        }
        if (d < 0) {
            n *= -1;
            d *= -1;
        }
        this.num = n;
        this.denom = d;
    }

    //Returns numerator
    public int getNum() {
        return this.num;
    }

    //Returns denominator
    public int getDenom() {
        return this.denom;
    }

    //Check if other rational number is less (-1), greater (1) or equal to (0) rational number
    public int compareTo(RationalNumber other) {
        return Double.compare(this.num / this.denom, other.num / other.denom);
        /*
        if (((double) (this.num/this.denom)) > ((double) (other.num/other.denom))){
            return 1;
        }else if (((double) (this.num/this.denom)) < ((double) (other.num/other.denom))){
            return -1;
        }else return 0;
        */
    }

    //Adding 2 rational numbers together
    public RationalNumber add(RationalNumber other) {
        int tempNum;
        int tempDenom;
        if (this.denom != other.denom) {
            tempDenom = this.denom * other.denom;
            tempNum = this.num * other.denom + other.num * this.denom;
        } else {
            tempNum = this.num + other.num;
            tempDenom = this.denom;
        }
        return new RationalNumber(tempNum, tempDenom);
    }


    //Diving 2 rational numbers
    public RationalNumber div(RationalNumber other) {
        return new RationalNumber(this.num * other.denom, this.denom * other.num);
    }

    //Generating string out of numerator and denominator
    public String toString() {
        return this.num + "/" + this.denom;
    }

    //Testing
    public static void main(String[] args) {
        RationalNumber rn1 = new RationalNumber(-9, 2);
        System.out.println(rn1.toString());


        RationalNumber rn2 = new RationalNumber(-10, 1);
        System.out.println(rn2.toString());

        RationalNumber temp1 = rn1.add(rn2);
        System.out.println(temp1.toString());

        RationalNumber temp2 = rn1.div(rn2);
        System.out.println(temp2.toString());
        System.out.println();

        System.out.println(rn1.compareTo(rn2));


        // TODO: test data
    }
}