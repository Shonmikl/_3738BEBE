package _21_12_2022;

import _19_12_2022.streams.students.Faculty;
import _19_12_2022.streams.students.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {
        Student st1 = new Student("Uliana", 'f', 25, 2, 7.4);
        Student st2 = new Student("Elina", 'f', 24, 4, 8.4);
        Student st3 = new Student("Pavel", 'm', 27, 3, 9.4);
        Student st4 = new Student("Alexander", 'm', 30, 2, 6.5);
        Student st5 = new Student("Anatoli", 'm', 32, 4, 9.9);

        ArrayList<Student> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);

        Faculty math = new Faculty("Math");
        Faculty it = new Faculty("IT");

        math.addStOnF(st1);
        math.addStOnF(st2);
        it.addStOnF(st3);
        it.addStOnF(st4);
        it.addStOnF(st5);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(math);
        faculties.add(it);

//        faculties.stream()
//                .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
//                .forEach(System.out::println);

        //groupingBy()
//        Map<Integer, List<Student>> map = list.stream()
//                .map(student -> {
//                    student.setName(student.getName().toUpperCase());
//                    return student;
//                }).collect(Collectors.groupingBy(student -> student.getCourse()));
//
//        for (Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
//            System.out.println(entry);
//        }

        //partitioningBy
//        Map<Boolean, List<Student>> map = list.stream()
//          .collect(Collectors.partitioningBy(student -> student.getAvgGrade() > 8));
//
//        for (Map.Entry<Boolean, List<Student>> entry: map.entrySet()) {
//            System.out.println(entry);
//        }

        //findFirst()
//        Student stud = list.stream()
//                .filter(student -> student.getSex() == 'f')
//                .sorted((s1, s2) -> s1.getAge() - s2.getAge())
//                .findFirst()
//                .get();
//
//        System.out.println(stud);

        //min / max / average
        Student min = list.stream().min((s1, s2) -> s1.getAge() - s2.getAge()).get();
        Student max = list.stream().max((s1, s2) -> (int) (s1.getAvgGrade() - s2.getAvgGrade())).get();
        double aver = list.stream()
                .mapToDouble(el -> el.getAvgGrade())
                .average()
                .getAsDouble();

        List<Double> courses =
                list.stream()
                        .mapToDouble(Student::getSex)
                        .boxed()
                        .toList();

//        list.stream()
//                .filter(el -> el.getAge() > 18)
//                .limit(2)
//                .forEach(System.out::println);

        list.stream()
                .filter(el -> el.getAge() > 18)
                .skip(2)
                .forEach(System.out::println);
    }
}