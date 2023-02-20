package _20_02_2023;

import lombok.*;

import java.lang.annotation.Target;

@ToString
//@AllArgsConstructor
@NoArgsConstructor
public class P {
    public int id;
    public String name;
    public String department;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //    @Getter
//    @Setter
    private double salary = 222.22;

    public P(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New department: " + department);
    }

    public void increaseSalary() {
        salary *= 1.25;
    }
}