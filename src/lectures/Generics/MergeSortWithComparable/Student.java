package Archive.Vorlesung.Generics.MergeSortWithComparable;

public class Student implements Comparable<Student> {
    int matrikelNummer;
    String firstName;
    String surName;
    int semester;

    Student(int matrikelNummer, String firstName, String surName, int semester) {
        this.matrikelNummer = matrikelNummer;
        this.firstName = firstName;
        this.surName = surName;
        this.semester = semester;
    }

    public int compareTo(Student other) {
        return this.matrikelNummer - other.matrikelNummer;
    }

    public boolean isLess(Student other) {
        return this.compareTo(other) < 0;
    }

    public String toString() {
        return "(" + matrikelNummer + ", " + firstName + ", " + surName + ", " + semester + ")";
    }
}
