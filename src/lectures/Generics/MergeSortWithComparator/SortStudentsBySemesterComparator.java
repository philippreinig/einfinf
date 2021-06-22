package Archive.Vorlesung.Generics.MergeSortWithComparator;

import java.util.Comparator;

public class SortStudentsBySemesterComparator implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        return student1.semester - student2.semester;
    }

}
