package _16_01_2023.serial.p1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerialEx1P1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Alexandr");
        employees.add("Oxana");
        employees.add("Alexey");
        employees.add("Jelena");
        employees.add("Anatolii");

        try (ObjectOutputStream outputStream
                     = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            outputStream.writeObject(employees);
            System.out.println("DONE!");
        } catch (IOException e) {
            throw new RuntimeException("!!!!");
        }
    }
}