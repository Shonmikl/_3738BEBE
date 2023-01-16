package _16_01_2023.serial.emp;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
public class Employee implements Serializable {
    String name;
    String department;
    int age;
    double salary;
    Car car;
}