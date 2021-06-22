package Archive.exercises;


/*
# Algorithm:  f(x,y)
# Input:      x,y ganzzahlig
# Output:     ?
              if y = 0 then x
              else          f(x-1, y-1)
              fi


1)
Der Algorithmus terminiert nur für Werte von y>=0, da bei jeder Iteration y um 1 reduziert wird, wenn dieses nicht 0 beträgt
x=3,y=2:
    (y=2)!=0 -> x=2, y=1
    (y=1)!=0 -> x=1, y=0
    (y=0)==0 -> 1
    -----end-----
x=5, y=0:
    (y=0)==0 -> 5
    -----end-----

x=7, y=-1:
    (y=-1)!=0 -> x=6, y=-2
    (y=-2)!=0 -> x=5, y=-3
    (y=-3)!=0 -> x=4, y=-4
    .....no end.....

 */
public class RecursiveFunction {

    public static int rec(int x, int y) {
        if (y < 0) {            //Wenn y<0, soll statt 1 subtrahiert 1 addiert werden
            if (y == 0) {            //Ist y==0 wird die Rekursion unterbrochen und x ausgegeben
                return x;
            } else {
                return rec(x + 1, y + 1);     //Rekursion wird mit x+1 und y+1 ausgeführt
            }
        }
        if (y == 0) {            //Ist y==0 wird die Rekursion unterbrochen und x ausgegeben
            return x;
        } else {
            return rec(x - 1, y - 1);     //Rekursion wird mit x-1 und y-1 ausgeführt
        }
    }

    //Rekursion umformuliert als Iteration mit while Schleife
    public static int iter(int x, int y) {
        if (y < 0) {
            while (y != 0) {        //Rekursion wird mit x+1 und y+1 ausgeführt
                y += 1;
                x += 1;
            }
            return x;
        }
        while (y != 0) {        //Rekursion wird mit x-1 und y-1 ausgeführt
            y -= 1;
            x -= 1;
        }
        return x;
    }

    public static void main(String[] args) {
        //Testvariablen
        int x = 454;
        int y = -88;

        //Ergebnisse ausgeben
        System.out.println("Result of rec: " + rec(x, y));
        System.out.println("Result of iter: " + iter(x, y));
        if (rec(x, y) == iter(x, y)) {
            System.out.println("Same result of rec and iter");
        } else {
            System.out.println("Different result of rec and iter:");
        }
    }
}