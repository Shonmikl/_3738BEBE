package _05_12_2022.treeSet.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Stud implements Comparable<Stud> {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stud stud)) return false;
        return age == stud.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public int compareTo(Stud o) {
        return this.age - o.age;
    }
}