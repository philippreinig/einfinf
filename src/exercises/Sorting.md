1./2.)
**Selection Sort:** 
1. Es wird der kleinste Eintrag des Datensatzes gesucht.
2. Das gefundene kleinste Element wird nach - also rechts neben - dem letzten sortierten Element positioniert.
   Im ersten Durchgang wird das Element an die Position mit Index 0 gesetzt.
3. Wiederhole die Schritte 1 & 2 bis der ganze Datensatz sortiert ist.

Stabilität: Nein, durch das Vertauschen kann es zum ändern der Reihenfolge von "gleichen" Elementen kommen.
Eine stabile Implementierung ist allerdings möglich, wenn statt Elemente zu vertauschen, das Array in einen sortierten und unsortierten Teil unterteilt wird und das Element immer ans Ende der sortierten Elemente angefügt wird.
Alle unsortierten Elemente müssen dazu eine Position nach rechts verschoben werden. Außerdem muss das Suchen des kleinsten Elements immer aus der gleichen Richtung erfolgen - also von links oder rechts.
Allerdings würde eine solche stabile Implementierung zu erheblichen Performanceverlusten führen.

Implementierung in-place / out-of-place: in-place, out-of-place auch möglich

Laufzeitkomplexitätsklasse: O(n)=n^2, identische Laufzeit für best-,worst- und average-case

**Insertion Sort:** 
Es existieren 2 Stapel von Elementen, der eine enthält alle Elemente, die noch nicht sortiert sind, der andere alle die bereits sortiert wurden.
Bei einer in-place Implementierung wird das Array in einen Bereich mit allen sortierten und einen Bereich mit allen unsortierten Werten eingeteilt.
1. Nimm das nächste Element aus dem Stapel der noch nicht sortierten Elemente.
2. Finde die Position an dem das Element in den Stapel der bereits sortierten Elemente eingefügt werden muss.
3. Füge das Element an dieser Position ein.
4. Wiederhole die Schritte 1-3 bis der ganze Datensatz sortiert ist.

Finden der "Einfügeposition" und Einfügen des Elements (Schritte 2 und 3) in einem int-Array:
1. Iteriere von rechts beginnend über das sortierte Array bis ein kleineres als das einzufügende Element gefunden wurde. 
   Im 1. Schritt sind keine Elemente vorhanden. Füge das Element einfach an die Position 0 ein.
2. Schiebe alle Elemente rechts dieses gefunden Elements eine Position nach rechts.
3. Füge das Element an die so frei gewordene Position ein.

Stabilität: Ja, da keine Vertauschungen stattfinden, sondern die Elemente immer an den sortierten Bereich angehängt werden.

Laufzeitkomplexitätsklasse:
    best-case: O(n) = n
    worst-case: O(n) = n^2
    average-case: O(n) = n^2

3.)
Die binäre Suche hat die Laufzeitkomplexitätsklasse O(n) = log(n), somit könnte die Position, an der das Element eingefügt wird mit logarithmischem statt linearem Aufwand
gefunden werden. Allerdings ist für das Verschieben der Elemente trotzdem linearer Aufwand nötig. Somit ergibt sich aus den verschachtelten for-schleifen wieder die
Laufzeitkomplexitätsklasse von O(n) = n^2.