2)
Insertion-Sort:  O(n) = n^2
Selection-Sort: O(n) = n^2
Bubble-Sort: O(n) = n^2
Mergesort: O(n) = n*log(n)
Quicksort: O(n) = n*log(n)
Binäres Suchen: O(n) = log(n)
Lineares Suchen: O(n) = n
Schnelles Potenzieren: O(n) = log(n)
Berechnung der Quersumme einer Dezimalzahl: O(n) = log(n)
Fibonacci-Zahlen (iterativ): O(n) = x
Fibonacci-Zahlen (rekursiv): O(n) = 2^x

3)
(a) for (int i = 0; i < n; ++i);

O(n) = n

(b) for (int i = 100; i < n; ++i);

O(n) = n

(c) for (int i = 1; i <= n; i=i+i);

O(n) = log(n)

(d) for (int i = 1; i <= n; ++i)
for (int j = n; j > i; --j);

O(n) = n^2

(e) for (int i = n/2; i < n; ++i);

O(n) = n

(f) for (int i = 0; i < n ; ++i)
for (int j = 1; j <= n*n; ++j);

O(n) = n^3

