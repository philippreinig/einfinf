**Aufgabe 1**
1.

{VOR} => {P}, wobei Z=1 und W = Y

Y >= 0 => X^Y = Z*X^W
Y >= 0 => X^Y = X^Y

{P ∧ B} => {P}, wobei B: W!=0, Z'=Z*X und W'=W-1
X^Y = Z*X^W ∧ W!=0 => X^Y = Z'*X^W'
X^Y = Z*X^W ∧ W!=0 => X^Y = Z*X*X^(W-1)
X^Y = Z*X^W ∧ W!=0 => X^Y = Z*X^(W-1+1) = Z*X^W

{P∧¬B} => {NACH}, wobei B: W!=0 => ¬B = 0
X^Y = Z*X^W ∧ W=0 => X^Y = Z*X^W
X^Y = Z => X^Y = Z

2. Es müsste zusätzlich gezeigt werden, dass der Alogrithmus POW für alle Werte von X und Y terminiert.

**Aufgabe 2**
1.

    1) Induktionsanfang:
    y0 = 0 : pow(x,y0) = 1 = x^0=x^y0
       
    2) Induktionsvoraussetzung:
    Für alle z mit y0<=z<=y gilt: pow(x,y) = x^y
       
    3) Induktionsschritt:
    pow(x,y+1) = mult(pow(x,pred(y+1), x)) = mult(pow(x,y+1-1), x)) = mult(pow(x,y), x) =IV= x^y*x = x^y+1
    
    q.e.d.!

    2) Die Funktion ist pow ist partiell, da sie für y<0 nicht ~~terminiert~~ und somit nie ein Ergebnis liefert. 
    Eine partielle Funktion terminiert nicht für alle möglichen Eingabewerte.
       
    Korrektur: Eine partielle Funktion ist nicht für alle möglichen Eingabewerte definiert!




