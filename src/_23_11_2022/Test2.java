package _23_11_2022;

import _23_11_2022.employee.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee em1
                = new Employee(12, "Konstantin", "JAVA DEV", 550);
        Employee em2
                = new Employee(21, "Oxana", "JAVA DEV", 1500);
        Employee em3
                = new Employee(13, "Elina", "JAVA DEV", 900);
        Employee em4
                = new Employee(4, "Svitlana", "JAVA DEV", 2500);

       // Arrays.sort(new Employee[] {em1, em2, em3, em4});

        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);
        employeeList.add(em4);

        System.out.println(employeeList);
        Collections.sort(employeeList, new SalaryComparator());
        System.out.println("************************************************");
        System.out.println(employeeList);
    }
}