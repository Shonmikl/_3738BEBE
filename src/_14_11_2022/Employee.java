package _14_11_2022;

public class Employee {
    private String name;
    private BusinessPosition businessPosition;


    public String getName() {
        return name;
    }

    public BusinessPosition getBusinessPosition() {
        return businessPosition;
    }

    public Employee(String name, BusinessPosition businessPosition) {
        this.name = name;
        this.businessPosition = businessPosition;
    }

    public static void main(String[] args) {
        Employee konstantin = new Employee("Konstantin", BusinessPosition.EMPLOYEE);
    }
}
