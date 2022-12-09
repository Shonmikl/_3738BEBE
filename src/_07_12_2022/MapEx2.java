package _07_12_2022;

import _23_11_2022.employee.Employee;

import java.util.*;

public class MapEx2 {
    public static void main(String[] args) {

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Employee, Integer> hashMapEmp = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        Employee em1
                = new Employee(12, "Konstantin", "JAVA DEV", 550);
        Employee em2
                = new Employee(21, "Oxana", "JAVA DEV", 1500);
        Employee em3
                = new Employee(13, "Elina", "JAVA DEV", 900);
        Employee em4
                = new Employee(4, "Svitlana", "JAVA DEV", 2500);

        Employee em5
                = new Employee(13, "Elina", "JAVA DEV", 900);

        hashMapEmp.put(em1, 1);
        hashMapEmp.put(em2, 1);
        hashMapEmp.put(em3, 1);
        hashMapEmp.put(em4, 1);

        System.out.println(em5.hashCode());


        hashMap.put(1, "888");
        hashMap.put(12, "0000");
        hashMap.put(9, "99");



    }
}
