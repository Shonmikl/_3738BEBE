package _16_01_2023.serial.emp;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@ToString
@AllArgsConstructor
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    String name;
    String department;
    int age;
    transient double salary;
    //Car car;
}