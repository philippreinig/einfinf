1) 
Zeile 4: fly to the left
Zeile 6: teleport to 0
Zeile 7: run faster to 0
Zeile 8: fly to the right

2)
Beim ÜberLADEN von Methoden unterscheidet sich die Signatur. Der Name ist identisch, aber die Parameterliste ist unterschiedlich.
Java wählt beim Funktionsaufruf abhängig von den eingegebenen Parametern automatisch die zugehörige Methode aus.
Bsp: 
Die Methoden move der Klasse Bird haben den gleichen Namen, aber unterscheiden sich im verlangten Parameter: string und int, int.
In Zeile 4 wird deshalb automatisch die erste der beiden Methoden aufgerufen, da "the left", also ein String als Parameter übergeben wird

Beim ÜberSchreiben von Methoden ist die Signatur der Methoden identisch. Dieses Konzept findet Anwendung wenn eine Methode aus einer Elternklasse vererbt wird. 
Das Verhalten der Objekte einer Klasse unterscheidet sich von dem der Objekte aus der Elternklasse und wird deshalb verändert.
Bsp:
Die Klasse Fish überschreibt die Methode move() der Klasse Animal.

3)
Zeile 2:  Animal gnu = new Animal(); Da die Klasse Animal eine abstrakte Klasse ist. Es können keine Objekte von abstrakten Klassen instanziiert werden.
Zeile 4: Fish nemo = coyote; Da coyote ein Objekt der Klasse RoadRunner ist und deshalb kein Fish sein kann.