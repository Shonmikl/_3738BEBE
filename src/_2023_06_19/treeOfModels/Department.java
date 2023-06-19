package _2023_06_19.treeOfModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//Tree of models
@Getter
public class Department {
    private String name;
    private List<Employee> employees;
    private List<Department> subDepartments;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.subDepartments = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addSubDepartment(Department department) {
        subDepartments.add(department);
    }

    public void printDepartmentHierarchy(String prefix) {
        System.out.println(prefix + name);

        for (Department sub : subDepartments) {
            sub.printDepartmentHierarchy(prefix + "  ");
        }

        for (Employee emp : employees) {
            System.out.println(prefix + "  " + emp.getName() + " - " + emp.getPosition());
        }
    }
}

@Getter
@AllArgsConstructor
class Employee {
    private String name;
    private String position;
}

class Main {
    public static void main(String[] args) {
        Department devDep = new Department("Development");
        Department frontDep = new Department("FrontEnd");
        Department backDep = new Department("BackEnd");
        Department markDep = new Department("Marketing");

        Employee john = new Employee("John", "Dev");
        Employee nik = new Employee("Nik", "Marketing");

        devDep.addEmployee(john);
        markDep.addEmployee(nik);

        devDep.addSubDepartment(frontDep);
        devDep.addSubDepartment(backDep);

        devDep.printDepartmentHierarchy("");
        markDep.printDepartmentHierarchy("");
    }
}