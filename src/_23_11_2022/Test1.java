package _23_11_2022;

import _14_11_2022.Employee;
import _28_11_2022.example.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("Konstantin");
        list.add("Elina");
        list.add("Jelena");
        list.add("Mikhail");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
