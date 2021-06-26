package exercises;

public class ComplexNumber {

    private class InvalidInputForSquareRoot extends RuntimeException {
        public InvalidInputForSquareRoot(String errMessage) {
            super(errMessage);
        }
    }

    public static double real;
    public static double imag;

    public ComplexNumber(double real, double imag) {
        ComplexNumber.real = real;
        ComplexNumber.imag = imag;
    }

    public double get_real() {
        return real;
    }

    public double get_imag() {
        return imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        real += other.get_real();
        imag += other.get_imag();
        return this;
    }

    public ComplexNumber mult(ComplexNumber other) {
        real = this.get_real() * other.get_real() - this.get_imag() * other.get_imag();
        imag = this.get_real() * other.get_imag() + this.get_imag() * other.get_real();
        return this;
    }

    public double absoluteValue() {
        return Math.sqrt(Math.pow(this.get_real(), 2)) + Math.sqrt(Math.pow(this.get_imag(), 2));
    }

    public ComplexNumber sqrt() throws InvalidInputForSquareRoot {
        if (this.get_imag() == 0) return new ComplexNumber(Math.sqrt(this.get_real()), 0);
        else throw new InvalidInputForSquareRoot("Imaginary part != 0");
    }


    public String toString() {
        // bitte nicht veraendern (wegen Backend-Kontrolle)
        return real + " + " + imag + "*i";
    }

    public static void main(String[] args) {
        ComplexNumber z1 = new ComplexNumber(-8.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(-8.0, 0.0);
        ComplexNumber z3 = new ComplexNumber(16.0, 0.0);
        ComplexNumber z4 = new ComplexNumber(16.0, 0.0);

        System.out.println(z1.add(z2).toString());
    }
}
