package _28_11_2022.intro;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("qa");
        list.add("aw");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
