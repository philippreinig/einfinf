package Archive.Vorlesung.Generics.MergeSortWithComparable;

import java.util.Arrays;


public class TestComparisons {
    public static void main(String[] args) {
        Student student1 = new Student(12345, "Philipp", "Reinig", 1);
        Student student2 = new Student(98765, "Micheal", "Müller", 3);
        Student[] students = {student2, student1};

        System.out.println("-----Testing generic mergeSort algorithm for Students-----");

        System.out.println(Arrays.toString(students));
        Sort.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("-----Testing generic mergeSort algorithm for Integers-----");

        Integer[] intArray = {6, 2, 0, -1, 54, 8, 23, -12, 5};
        System.out.println(Arrays.toString(intArray));
        Sort.sort(intArray);
        System.out.println(Arrays.toString(intArray));


    }
}
