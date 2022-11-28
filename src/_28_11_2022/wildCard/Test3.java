package _28_11_2022.wildCard;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(5);
//        list.add(2.5);
        List<Double> list1 = new ArrayList<>();
        list1.add(2.5);
        List<String> list2 = new ArrayList<>();
        list2.add("2.5");
        info(list1);
        info(list2);
    }
    static void info(List<?> list) {
        System.out.println(list);
    }
}
