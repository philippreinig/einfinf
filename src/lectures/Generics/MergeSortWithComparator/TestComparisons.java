package lectures.Generics.MergeSortWithComparator;

import java.util.Arrays;


public class TestComparisons {
    public static void main(String[] args) {
        Student student1 = new Student(12345, "Philipp", "Reinig", 1);
        Student student2 = new Student(98765, "Michael", "Müller", 3);
        Student student3 = new Student(55555, "Julia", "Werner", 2);
        Student[] students = {student1, student2, student3};

        SortStudentsByMatrikelNumberComparator sortByMatrikelNummer = new SortStudentsByMatrikelNumberComparator();
        SortStudentsByFirstNameComparator sortByFirstName = new SortStudentsByFirstNameComparator();
        SortStudentsBySemesterComparator sortBySemester = new SortStudentsBySemesterComparator();

        System.out.println("Students[] before sorting: " + Arrays.toString(students));
        //Sort.sort(students, sortByFirstName);
        //Sort.sort(students, sortByMatrikelNummer);
        Sort.sort(students, sortBySemester);
        System.out.println("Students[] after sorting: " + Arrays.toString(students));


    }
}
