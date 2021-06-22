Erweitere diese Definition um die Funktionen:

size, für die Anzahl der Elemente,
union, für die Realisierung der Mengenvereiningung
intersect für den Schnitt von Mengen.
Erkläre die einzelnen Mengenfunktionen jeweils an einem Beispiel.


Type Set[Item]
import Bool, Nat

Operators
empty_set:            --> Set
is_empty:  Set        --> bool
insert:    Set x Item --> Set
is_in:     Set x Item --> bool
size:      Set -> Nat
union:     Set x Set -> Set
intersect: Set x Set -> Set

Axioms
for all s, t: Set[Item]; i, j: Item

insert(insert(s,i),j)) = insert(insert(s,j),i) //commutativity
insert(insert(s,i),i)) = insert(s,i)      // no duplicate elements

is_empty(empty_set)    = true
is_empty(insert(s, i)) = false

is_in (empty_set, i) = false
is_in (insert(s, i), j) = if i=j then true
                          else is_in(s, j)

size(empty_set) = 0;
size(insert(empty_set, i)) = 1
size(insert(s,j)) = if is_in(s,i) then size(s)
                    else size(s) + 1

~~intersect(s,t) = insert(empty_set, i) for all i,j in s,t: if is_in(s,i) and is_in(t,j)~~

~~union(s,t) = insert(empty_set, i) for all i, j in s,t: if is_in(s,i) or is_in(t,j)~~


intersect(empty_set, empty_set) = empty_set
intersect(empty_set, s) = s
intersect(s, t) = intersect(t,s)
intersect(insert(s,i), t) = if (is_in(t,i)) insert(intersect(s,t),i)
                            else intersect(s,t)                            

union(empty_set, empty_set) = empty_set
union(empty_set, s) = s
union(s,t) = union(t,s)
union(insert(s,i),t) = insert(union(s,t),i)





