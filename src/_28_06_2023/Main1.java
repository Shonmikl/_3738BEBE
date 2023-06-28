package _28_06_2023;

import java.util.function.Function;

public class Main1 {
    public static void main(String[] args) {
        Function<String, Function<String, String>>
                c = u -> v -> u + v;
        System.out.println("Concate two strings: " + c.apply("Java-").apply("PRO"));
    }
}
