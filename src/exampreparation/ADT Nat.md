type Nat
import Bool

operators
0:    -> Nat                 -- Konstruktor
suc:  Nat -> Nat             -- Konstruktor, Nachfolger
add:  Nat x Nat -> Nat       -- Addition
=*:   Nat x Nat -> Bool      -- Gleichheitsrelation
>:    Nat x Nat -> Bool      -- Vergleich
pred: Nat -> Nat             -- Vorgaenger
sub:  Nat x Nat -> Nat       -- Subtraktion
mult: Nat x Nat -> Nat       -- Multiplikation
div:  Nat x Nat -> Nat       -- Ganzzahldivision
mod:  Natx Nat -> Nat        -- ganzzahliger Rest
even: Nat -> boolean         -- Praedikat der Geradzahligkeit

axioms
x, y: Nat
add(x, 0)          = x
add(x, suc(y))     = suc (add(x, y))

0 =* 0             = true
0 =* suc (x)       = false
suc (x) =* 0       = false
suc (x) =* suc (y) = x =* y

0 > suc(y)         = false
suc(x) > 0         = true
suc(x) > suc(y)    = x > y

pred(suc(0)) = 0
pred(suc(x)) = x

sub(x,0) = x
sub(x,pred(y)) = pred(sub(x,y))

mult(x,0) = 0
mult(x,1) = x
mult(x,y) = mult(y,x)
mult(x,suc(y)) = add(mult(x,y),x)

div(0,y) = 0
div(x,1) = x
div(x,y) and x=y = 1
div(x,y) = if x<y = 0
           else suc(div(sub(x,y),y))

mod(0,y) = 0
mod(x,1) = 0
## mod(x,y) = if x < y then x
           else sub(mod(x,y),y) ##

even(x) = mod(x) == 0
even(0) = true
even(suc(x)) != even(x)


preconditions:
pred(x): x >0
div: x > 0
div: mod(x,y) = 0
mod: x > 0
## sub: x>=y ##
