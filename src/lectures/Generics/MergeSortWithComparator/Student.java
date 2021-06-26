package lectures.Generics.MergeSortWithComparator;

public class Student {
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


    public int compare(Student student1, Student student2) {
        return student1.matrikelNummer - student2.matrikelNummer;
    }

    public String toString() {
        return "(" + matrikelNummer + ", " + firstName + ", " + surName + ", " + semester + ")";
    }
}
