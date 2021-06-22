ADT Set
---
-------------------------------------------------------
pred      -- Vorgaenger
sub       -- Subtraktion
mult      -- Multiplikation
div       -- Ganzzahldivision
mod       -- ganzzahliger Rest
even      -- Praedikat der Geradzahligkeit
-------------------------------------------------------



type Nat
import Bool

operators
0:    -> Nat                 -- Konstruktor
suc:  Nat -> Nat             -- Konstruktor, Nachfolger
add:  Nat x Nat -> Nat       -- Addition
=*:   Nat x Nat -> Bool      -- Gleichheitsrelation
>:    Nat x Nat -> Bool      -- Vergleich
pred: Nat       -> Nat
sub:  Nat x Nat -> Nat
mult: Nat x Nat -> Nat
div:  Nat x Nat -> Nat
mod:  Nat x Nat -> Nat
even: Nat       -> Bool

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
sub(suc(x),suc(y)) = sub(x, y)
sub(x, suc(y)) = pred(sub(x,y))

mult(x,0) = 0
mult(x,1) = x
mult(x,y) = mult(y,x)
mult(x,suc(y)) = add(x, mult(x,y))

div(0,y) = 0
div(x,1) = x
div(x,y) ∧ x=y = 1
div(x,y) = if y>x then 0
           else suc(div(sub(x,y),y))

div(x,y) = div(sub(x,mod(x,y)), y) //Funktioniert nicht, wenn mod(x,y) = 0 - Idee: Auflösen nach q in Darstellung: x=q*y+r

mod(0,y) = 0
mod(x,1) = 0
mod(x,y) = if y>x then x
           else mod(sub(x,y),y) 
mod(sub(x,y), pred(y)) = mod(x,y)

even(x) = mod(x,suc(suc(0)) = 0


preconditions:
pred(x): x > 0
sub(x,y): x>=y
div(x,y): y>0
mod(x,y): y>0