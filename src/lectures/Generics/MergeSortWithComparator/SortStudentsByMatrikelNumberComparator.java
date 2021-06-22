package Archive.Vorlesung.Generics.MergeSortWithComparator;

import java.util.Comparator;


public class SortStudentsByMatrikelNumberComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.matrikelNummer - student2.matrikelNummer;
    }
}
