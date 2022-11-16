package _14_11_2022;

public class PermissionCard {
    Employee employee;

    public PermissionCard(Employee employee) {
        this.employee = employee;
    }

    void permit(Employee employee) {
        if (employee.getBusinessPosition() == BusinessPosition.EMPLOYEE) {
            System.out.println("Не пускать в столовую");
        }
    }

    public static void main(String[] args) {
        PermissionCard kc
                = new PermissionCard(new Employee("Konstantin", BusinessPosition.EMPLOYEE));
    }
}