package _19_12_2022.streams.students;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Faculty {
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentsOnFaculty = new ArrayList<>();
    }

    public void addStOnF(Student s) {
        studentsOnFaculty.add(s);
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }
}