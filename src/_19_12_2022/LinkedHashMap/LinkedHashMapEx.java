package _19_12_2022.LinkedHashMap;

import _28_11_2022.example.Student;

import java.util.LinkedHashMap;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm =
                new LinkedHashMap<>(10, 0.75f, true);

        Student student4 = new Student("Elina",  27);
        Student student1 = new Student("Oksana",  28);
        Student student2 = new Student("Anatolii",  29);
        Student student3 = new Student("Konstantin",  30);

        lhm.put(2.2, student1);
        lhm.put(3.5, student2);
        lhm.put(4.8, student3);
        lhm.put(1.2, student4);

        lhm.get(4.8);

        System.out.println(lhm);

    }
}
