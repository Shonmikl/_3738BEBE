package _16_01_2023.serial.p2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialEx1P2 {
    public static void main(String[] args) {
        ArrayList employees;
        try (ObjectInputStream inputStream
                     = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            employees = (ArrayList) inputStream.readObject();
            System.out.println(employees);
            System.out.println("DONE!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}