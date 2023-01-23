package _23_01_2023.mr;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MR2 {
    public static void main(String[] args) {
        List<String> names
                = Arrays.asList("ALexandr", "Raul", "Uliana", "Elina");
        names.forEach(el -> System.out.println("List: " + el));
        names.forEach(System.out::println);
    }
}