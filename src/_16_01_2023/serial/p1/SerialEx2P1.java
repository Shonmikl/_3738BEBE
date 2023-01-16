package _16_01_2023.serial.p1;

import _16_01_2023.serial.emp.Car;
import _16_01_2023.serial.emp.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialEx2P1 {
    public static void main(String[] args) {
        Car car = new Car("BMW_X7", "BLACK");
        Employee employees
                = new Employee("Anatolii", "IT", 29, 4500);

        try (ObjectOutputStream outputStream
                     = new ObjectOutputStream(new FileOutputStream("EMP.bin"))) {
            outputStream.writeObject(employees);
            System.out.println("DONE!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}