package _16_01_2023.serial.p2;

import _16_01_2023.serial.emp.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialEx2P2 {
    public static void main(String[] args) {
        Employee employee;
        try (ObjectInputStream inputStream
                     = new ObjectInputStream(new FileInputStream("EMP.bin"))) {
            employee = (Employee) inputStream.readObject();
            System.out.println(employee);
            System.out.println("DONE!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}