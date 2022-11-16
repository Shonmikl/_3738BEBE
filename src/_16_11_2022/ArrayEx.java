package _16_11_2022;

import _14_11_2022.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayEx {
    public static void main(String[] args) {
        List<Integer> arrayList;
        List<String> linkedList = new LinkedList<>();
        arrayList = Arrays.asList(12, 36, 54, 7, 89);
        arrayList.add(666);
        System.out.println(arrayList);


        linkedList.add("Kon");



        //System.out.println(arrayList);
    }
}
