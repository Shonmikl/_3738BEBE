package _14_11_2022;

/**
 * 1. Полиморфизм++
 * 2. Наследование++
 * 3. Инкапсуляция++
 * 4. Абстракция
 */
public class Test1 {
    public static void main(String[] args) {
        Employee employee = new Employee("", BusinessPosition.EMPLOYEE);
        DataBase dataBase = new DataBase();
        dataBase.addEmp(employee);
    }
}
