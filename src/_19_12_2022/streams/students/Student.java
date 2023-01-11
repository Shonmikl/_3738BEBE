package _19_12_2022.streams.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private String name;

    private char sex;
    private int age;
    private Integer course;
    private double avgGrade;
}