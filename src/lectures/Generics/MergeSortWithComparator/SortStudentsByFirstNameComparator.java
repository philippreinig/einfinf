package Archive.Vorlesung.Generics.MergeSortWithComparator;

import java.util.Comparator;

public class SortStudentsByFirstNameComparator implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        if (less(student1.firstName.toCharArray(), student2.firstName.toCharArray())) return -1;
        else if (student1.firstName.equals(student2.firstName)) return 0;
        else return 1;
    }

    static boolean less(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (i >= b.length) return false;
            else if (a[i] < b[i]) return true;
            else if (a[i] > b[i]) return false;
        }
        return true;
    }

}
