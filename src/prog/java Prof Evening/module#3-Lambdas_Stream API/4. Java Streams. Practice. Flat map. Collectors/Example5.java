import java.util.ArrayList;
import java.util.List;

public class Example5 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Aleks", "Developer", 1500));
        employees.add(new Employee("Thomas", "Manager", 680.50));
        employees.add(new Employee("Thea", "CEO", 2000));
        employees.add(new Employee("Mary", "Manager", 700));
        employees.add(new Employee("Ken", "Developer", 900));

        List<Employee> employeesNoCEO = employees
                .stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .toList();

        System.out.println(employeesNoCEO);

        List<Employee> employeesDevOnly = employees
                .stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .filter(x -> !"Manager".equals(x.getStaff()))
                .toList();

        System.out.println(employeesDevOnly);

    }
}

class Employee {
    private String name, staff;
    private double salary;

    public Employee(String name, String staff, double salary) {
        this.name = name;
        this.staff = staff;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getStaff() {
        return staff;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name +  " is CEO, salary=" + salary;
    }
}
