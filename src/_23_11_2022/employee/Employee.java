package _23_11_2022.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String position;
    private int salaryEuro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name)
                && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
//    @Override
//    public int compareTo(Employee anotherEmp) {
//        //this.object compareTo(another object )
//        if(this.id == anotherEmp.id) {
//            return 0;
//        } else if(this.id < anotherEmp.id) {
//            return -1;
//        } else
//        return 1;
//    }

//    @Override
//    public int compareTo(Employee anotherEmp) {
//       return this.id - anotherEmp.id;
//    }

    @Override
    public int compareTo(Employee anotherEmp) {
        return this.salaryEuro - anotherEmp.salaryEuro;
    }
}