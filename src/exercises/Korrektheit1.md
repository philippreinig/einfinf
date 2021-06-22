# Algorithm     XYZ
# input         x, y : int
# output        q, r : int
# Vorbedingungen: x >= 0  and  y > 0
# Nachbedingungen: 0 <= r < y and q*y + r = x
# Invariante: 0 <= r and 0 < y and q*y + r = x

r := x; q := 0;
while (r >= y)
do
  r := r - y;
  q := q + 1;
od

1)
r=13, q = 0 -> r=8, q=1 -> r=3, q=2

2)
Vor Schleifeneintritt:
{VOR} => {P}, mit r=x, y=0
(x >= 0) ∧ (y > 0) => (0 <= r) ∧ (0 < y) ∧ (q*y + r = x)    
(x >= 0) ∧ (y > 0) => (0 <= x) ∧ (0 < y) ∧ (0*y + x = x)
(x >= 0) ∧ (y > 0) => (0 <= x) ∧ (0 < y) ∧ (x = x) -> wahr

In der Schleife:
{P∧B} => {P} mit r' = r - y, q' = q + 1
(0 <= r) ∧ (0 < y) ∧ (q*y + r = x) ∧ (r >= y) => (0 <= r') ∧ (0 < y) ∧ (q'*y + r' = x)
(0 <= r) ∧ (0 < y) ∧ (q*y + r = x) ∧ (r >= y) => (0 <= r-y) ∧ (0 < y) ∧ ((q+1) * y + r-y = x)
(0 <= r) ∧ (0 < y) ∧ (q*y + r = x) ∧ (r >= y) => (0 <= r-y) ∧ (0 < y) ∧ (q*y + y r-y = x)
(0 <= r) ∧ (0 < y) ∧ (q*y + r = x) ∧ (r >= y) => (0 <= r-y) ∧ (0 < y) ∧ (q*y + r = x)

Nach der Schleife:
{P∧¬B} => {NACH}
(0 <= r) ∧ (0 < y) ∧ (q*y + r = x) ∧ (r < y) => (0 <= r < y) ∧  (q*y + r = x)







