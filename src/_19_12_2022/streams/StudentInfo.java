package _19_12_2022.streams;

import _19_12_2022.streams.students.Student;

import java.util.ArrayList;

public class StudentInfo {
    void testStudent(ArrayList<Student> al, StudentCheck sc) {
        for (Student s : al) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("Uliana", 'f', 25, 2, 7.4);
        Student st2 = new Student("Elina", 'f', 24, 4, 8.4);
        Student st3 = new Student("Pavel", 'm', 27, 3, 9.4);
        Student st4 = new Student("Alexander", 'm', 30, 2, 6.5);
        Student st5 = new Student("Anatoli", 'm', 32, 5, 9.9);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
        info.testStudent(students, stud -> stud.getAvgGrade() > 8);
    }
}

@FunctionalInterface
interface StudentCheck {
    boolean check(Student s);
}

class CheckOverGrade implements StudentCheck {

    @Override
    public boolean check(Student s) {
        return s.getAvgGrade() > 8;
    }
}