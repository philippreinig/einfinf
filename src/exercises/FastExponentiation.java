package Archive.exercises;

/********************************************************
 1) Ausgabe der Funktion fastPotRek für x=2 und n=13 ist 8192.0, für diese Zahlenwerte also korrekt.
 ********************************************************/

public class FastExponentiation {
    public static int counterRek = 0;
    public static int counterIter = 0;

    public static double fastPotRek(double x, int n) {
        counterRek++;
        if (n == 0) return 1;
        else if (n % 2 == 0 && n > 1) return fastPotRek(x * x, n / 2);
        else return x * fastPotRek(x, n - 1);
    }

    public static double fastPotIter(double x, int n) {
        double result = 1;
        while (n > 0) {
            counterIter++;
            if (n % 2 == 0 && n > 1) {
                x *= x;
                n /= 2;
            } else {
                result *= x;
                n -= 1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int amount = 100;
        int x = 2;

        for (int i = 0; i < amount; i++) {
            double resultFastPotRek = fastPotRek(x, i);
            double resultFastPotIter = fastPotIter(x, i);
            int diff = counterRek - counterIter;
            System.out.println("x=" + x + ", n=" + i + ", counterRek=" + counterRek + ", counterIter=" + counterIter + ", difference: " + diff + ", fastPotRek: " + resultFastPotRek + ", fastPotIter: " + resultFastPotIter);
            counterRek = 0;
            counterIter = 0;
        }

    }
}

/*
Tests in der main-Methode:
x=2, n=0, counterRek=1, counterIter=0, difference: 1, fastPotRek: 1.0, fastPotIter: 1.0
x=2, n=1, counterRek=2, counterIter=1, difference: 1, fastPotRek: 2.0, fastPotIter: 2.0
x=2, n=2, counterRek=3, counterIter=2, difference: 1, fastPotRek: 4.0, fastPotIter: 4.0
x=2, n=3, counterRek=4, counterIter=3, difference: 1, fastPotRek: 8.0, fastPotIter: 8.0
x=2, n=4, counterRek=4, counterIter=3, difference: 1, fastPotRek: 16.0, fastPotIter: 16.0
x=2, n=5, counterRek=5, counterIter=4, difference: 1, fastPotRek: 32.0, fastPotIter: 32.0
x=2, n=6, counterRek=5, counterIter=4, difference: 1, fastPotRek: 64.0, fastPotIter: 64.0
x=2, n=7, counterRek=6, counterIter=5, difference: 1, fastPotRek: 128.0, fastPotIter: 128.0
x=2, n=8, counterRek=5, counterIter=4, difference: 1, fastPotRek: 256.0, fastPotIter: 256.0
x=2, n=9, counterRek=6, counterIter=5, difference: 1, fastPotRek: 512.0, fastPotIter: 512.0
x=2, n=10, counterRek=6, counterIter=5, difference: 1, fastPotRek: 1024.0, fastPotIter: 1024.0
x=2, n=11, counterRek=7, counterIter=6, difference: 1, fastPotRek: 2048.0, fastPotIter: 2048.0
x=2, n=12, counterRek=6, counterIter=5, difference: 1, fastPotRek: 4096.0, fastPotIter: 4096.0
x=2, n=13, counterRek=7, counterIter=6, difference: 1, fastPotRek: 8192.0, fastPotIter: 8192.0
x=2, n=14, counterRek=7, counterIter=6, difference: 1, fastPotRek: 16384.0, fastPotIter: 16384.0
x=2, n=15, counterRek=8, counterIter=7, difference: 1, fastPotRek: 32768.0, fastPotIter: 32768.0
x=2, n=16, counterRek=6, counterIter=5, difference: 1, fastPotRek: 65536.0, fastPotIter: 65536.0
x=2, n=17, counterRek=7, counterIter=6, difference: 1, fastPotRek: 131072.0, fastPotIter: 131072.0
x=2, n=18, counterRek=7, counterIter=6, difference: 1, fastPotRek: 262144.0, fastPotIter: 262144.0
x=2, n=19, counterRek=8, counterIter=7, difference: 1, fastPotRek: 524288.0, fastPotIter: 524288.0
x=2, n=20, counterRek=7, counterIter=6, difference: 1, fastPotRek: 1048576.0, fastPotIter: 1048576.0
x=2, n=21, counterRek=8, counterIter=7, difference: 1, fastPotRek: 2097152.0, fastPotIter: 2097152.0
x=2, n=22, counterRek=8, counterIter=7, difference: 1, fastPotRek: 4194304.0, fastPotIter: 4194304.0
x=2, n=23, counterRek=9, counterIter=8, difference: 1, fastPotRek: 8388608.0, fastPotIter: 8388608.0
x=2, n=24, counterRek=7, counterIter=6, difference: 1, fastPotRek: 1.6777216E7, fastPotIter: 1.6777216E7
x=2, n=25, counterRek=8, counterIter=7, difference: 1, fastPotRek: 3.3554432E7, fastPotIter: 3.3554432E7
x=2, n=26, counterRek=8, counterIter=7, difference: 1, fastPotRek: 6.7108864E7, fastPotIter: 6.7108864E7
x=2, n=27, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.34217728E8, fastPotIter: 1.34217728E8
x=2, n=28, counterRek=8, counterIter=7, difference: 1, fastPotRek: 2.68435456E8, fastPotIter: 2.68435456E8
x=2, n=29, counterRek=9, counterIter=8, difference: 1, fastPotRek: 5.36870912E8, fastPotIter: 5.36870912E8
x=2, n=30, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.073741824E9, fastPotIter: 1.073741824E9
x=2, n=31, counterRek=10, counterIter=9, difference: 1, fastPotRek: 2.147483648E9, fastPotIter: 2.147483648E9
x=2, n=32, counterRek=7, counterIter=6, difference: 1, fastPotRek: 4.294967296E9, fastPotIter: 4.294967296E9
x=2, n=33, counterRek=8, counterIter=7, difference: 1, fastPotRek: 8.589934592E9, fastPotIter: 8.589934592E9
x=2, n=34, counterRek=8, counterIter=7, difference: 1, fastPotRek: 1.7179869184E10, fastPotIter: 1.7179869184E10
x=2, n=35, counterRek=9, counterIter=8, difference: 1, fastPotRek: 3.4359738368E10, fastPotIter: 3.4359738368E10
x=2, n=36, counterRek=8, counterIter=7, difference: 1, fastPotRek: 6.8719476736E10, fastPotIter: 6.8719476736E10
x=2, n=37, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.37438953472E11, fastPotIter: 1.37438953472E11
x=2, n=38, counterRek=9, counterIter=8, difference: 1, fastPotRek: 2.74877906944E11, fastPotIter: 2.74877906944E11
x=2, n=39, counterRek=10, counterIter=9, difference: 1, fastPotRek: 5.49755813888E11, fastPotIter: 5.49755813888E11
x=2, n=40, counterRek=8, counterIter=7, difference: 1, fastPotRek: 1.099511627776E12, fastPotIter: 1.099511627776E12
x=2, n=41, counterRek=9, counterIter=8, difference: 1, fastPotRek: 2.199023255552E12, fastPotIter: 2.199023255552E12
x=2, n=42, counterRek=9, counterIter=8, difference: 1, fastPotRek: 4.398046511104E12, fastPotIter: 4.398046511104E12
x=2, n=43, counterRek=10, counterIter=9, difference: 1, fastPotRek: 8.796093022208E12, fastPotIter: 8.796093022208E12
x=2, n=44, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.7592186044416E13, fastPotIter: 1.7592186044416E13
x=2, n=45, counterRek=10, counterIter=9, difference: 1, fastPotRek: 3.5184372088832E13, fastPotIter: 3.5184372088832E13
x=2, n=46, counterRek=10, counterIter=9, difference: 1, fastPotRek: 7.0368744177664E13, fastPotIter: 7.0368744177664E13
x=2, n=47, counterRek=11, counterIter=10, difference: 1, fastPotRek: 1.40737488355328E14, fastPotIter: 1.40737488355328E14
x=2, n=48, counterRek=8, counterIter=7, difference: 1, fastPotRek: 2.81474976710656E14, fastPotIter: 2.81474976710656E14
x=2, n=49, counterRek=9, counterIter=8, difference: 1, fastPotRek: 5.62949953421312E14, fastPotIter: 5.62949953421312E14
x=2, n=50, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.125899906842624E15, fastPotIter: 1.125899906842624E15
x=2, n=51, counterRek=10, counterIter=9, difference: 1, fastPotRek: 2.251799813685248E15, fastPotIter: 2.251799813685248E15
x=2, n=52, counterRek=9, counterIter=8, difference: 1, fastPotRek: 4.503599627370496E15, fastPotIter: 4.503599627370496E15
x=2, n=53, counterRek=10, counterIter=9, difference: 1, fastPotRek: 9.007199254740992E15, fastPotIter: 9.007199254740992E15
x=2, n=54, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.8014398509481984E16, fastPotIter: 1.8014398509481984E16
x=2, n=55, counterRek=11, counterIter=10, difference: 1, fastPotRek: 3.6028797018963968E16, fastPotIter: 3.6028797018963968E16
x=2, n=56, counterRek=9, counterIter=8, difference: 1, fastPotRek: 7.2057594037927936E16, fastPotIter: 7.2057594037927936E16
x=2, n=57, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.44115188075855872E17, fastPotIter: 1.44115188075855872E17
x=2, n=58, counterRek=10, counterIter=9, difference: 1, fastPotRek: 2.8823037615171174E17, fastPotIter: 2.8823037615171174E17
x=2, n=59, counterRek=11, counterIter=10, difference: 1, fastPotRek: 5.7646075230342349E17, fastPotIter: 5.7646075230342349E17
x=2, n=60, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.15292150460684698E18, fastPotIter: 1.15292150460684698E18
x=2, n=61, counterRek=11, counterIter=10, difference: 1, fastPotRek: 2.305843009213694E18, fastPotIter: 2.305843009213694E18
x=2, n=62, counterRek=11, counterIter=10, difference: 1, fastPotRek: 4.6116860184273879E18, fastPotIter: 4.6116860184273879E18
x=2, n=63, counterRek=12, counterIter=11, difference: 1, fastPotRek: 9.223372036854776E18, fastPotIter: 9.223372036854776E18
x=2, n=64, counterRek=8, counterIter=7, difference: 1, fastPotRek: 1.8446744073709552E19, fastPotIter: 1.8446744073709552E19
x=2, n=65, counterRek=9, counterIter=8, difference: 1, fastPotRek: 3.6893488147419103E19, fastPotIter: 3.6893488147419103E19
x=2, n=66, counterRek=9, counterIter=8, difference: 1, fastPotRek: 7.378697629483821E19, fastPotIter: 7.378697629483821E19
x=2, n=67, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.4757395258967641E20, fastPotIter: 1.4757395258967641E20
x=2, n=68, counterRek=9, counterIter=8, difference: 1, fastPotRek: 2.9514790517935283E20, fastPotIter: 2.9514790517935283E20
x=2, n=69, counterRek=10, counterIter=9, difference: 1, fastPotRek: 5.9029581035870565E20, fastPotIter: 5.9029581035870565E20
x=2, n=70, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.1805916207174113E21, fastPotIter: 1.1805916207174113E21
x=2, n=71, counterRek=11, counterIter=10, difference: 1, fastPotRek: 2.3611832414348226E21, fastPotIter: 2.3611832414348226E21
x=2, n=72, counterRek=9, counterIter=8, difference: 1, fastPotRek: 4.722366482869645E21, fastPotIter: 4.722366482869645E21
x=2, n=73, counterRek=10, counterIter=9, difference: 1, fastPotRek: 9.44473296573929E21, fastPotIter: 9.44473296573929E21
x=2, n=74, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.888946593147858E22, fastPotIter: 1.888946593147858E22
x=2, n=75, counterRek=11, counterIter=10, difference: 1, fastPotRek: 3.777893186295716E22, fastPotIter: 3.777893186295716E22
x=2, n=76, counterRek=10, counterIter=9, difference: 1, fastPotRek: 7.555786372591432E22, fastPotIter: 7.555786372591432E22
x=2, n=77, counterRek=11, counterIter=10, difference: 1, fastPotRek: 1.5111572745182865E23, fastPotIter: 1.5111572745182865E23
x=2, n=78, counterRek=11, counterIter=10, difference: 1, fastPotRek: 3.022314549036573E23, fastPotIter: 3.022314549036573E23
x=2, n=79, counterRek=12, counterIter=11, difference: 1, fastPotRek: 6.044629098073146E23, fastPotIter: 6.044629098073146E23
x=2, n=80, counterRek=9, counterIter=8, difference: 1, fastPotRek: 1.2089258196146292E24, fastPotIter: 1.2089258196146292E24
x=2, n=81, counterRek=10, counterIter=9, difference: 1, fastPotRek: 2.4178516392292583E24, fastPotIter: 2.4178516392292583E24
x=2, n=82, counterRek=10, counterIter=9, difference: 1, fastPotRek: 4.8357032784585167E24, fastPotIter: 4.8357032784585167E24
x=2, n=83, counterRek=11, counterIter=10, difference: 1, fastPotRek: 9.671406556917033E24, fastPotIter: 9.671406556917033E24
x=2, n=84, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.9342813113834067E25, fastPotIter: 1.9342813113834067E25
x=2, n=85, counterRek=11, counterIter=10, difference: 1, fastPotRek: 3.8685626227668134E25, fastPotIter: 3.8685626227668134E25
x=2, n=86, counterRek=11, counterIter=10, difference: 1, fastPotRek: 7.737125245533627E25, fastPotIter: 7.737125245533627E25
x=2, n=87, counterRek=12, counterIter=11, difference: 1, fastPotRek: 1.5474250491067253E26, fastPotIter: 1.5474250491067253E26
x=2, n=88, counterRek=10, counterIter=9, difference: 1, fastPotRek: 3.0948500982134507E26, fastPotIter: 3.0948500982134507E26
x=2, n=89, counterRek=11, counterIter=10, difference: 1, fastPotRek: 6.1897001964269014E26, fastPotIter: 6.1897001964269014E26
x=2, n=90, counterRek=11, counterIter=10, difference: 1, fastPotRek: 1.2379400392853803E27, fastPotIter: 1.2379400392853803E27
x=2, n=91, counterRek=12, counterIter=11, difference: 1, fastPotRek: 2.4758800785707605E27, fastPotIter: 2.4758800785707605E27
x=2, n=92, counterRek=11, counterIter=10, difference: 1, fastPotRek: 4.951760157141521E27, fastPotIter: 4.951760157141521E27
x=2, n=93, counterRek=12, counterIter=11, difference: 1, fastPotRek: 9.903520314283042E27, fastPotIter: 9.903520314283042E27
x=2, n=94, counterRek=12, counterIter=11, difference: 1, fastPotRek: 1.9807040628566084E28, fastPotIter: 1.9807040628566084E28
x=2, n=95, counterRek=13, counterIter=12, difference: 1, fastPotRek: 3.961408125713217E28, fastPotIter: 3.961408125713217E28
x=2, n=96, counterRek=9, counterIter=8, difference: 1, fastPotRek: 7.922816251426434E28, fastPotIter: 7.922816251426434E28
x=2, n=97, counterRek=10, counterIter=9, difference: 1, fastPotRek: 1.5845632502852868E29, fastPotIter: 1.5845632502852868E29
x=2, n=98, counterRek=10, counterIter=9, difference: 1, fastPotRek: 3.1691265005705735E29, fastPotIter: 3.1691265005705735E29
x=2, n=99, counterRek=11, counterIter=10, difference: 1, fastPotRek: 6.338253001141147E29, fastPotIter: 6.338253001141147E29
 */