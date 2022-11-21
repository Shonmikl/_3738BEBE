package _14_11_2022;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {

    private String name;
    private BusinessPosition businessPosition;

    public static void main(String[] args) {
        Employee konstantin = new Employee("Konstantin", BusinessPosition.EMPLOYEE);
    }
}
