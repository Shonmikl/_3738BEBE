package _19_12_2022.streams;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class St1 {
    public static void main(String[] args) {
        //Array
        int[] arr = {10, 23, 65, 48, 81, 65, 42, 23, 101, 25, 7, 8};

        Arrays.stream(arr)
                .map(elem -> elem * 3)
                .reduce((el1, el2) -> el1 + el2)
                .getAsInt();

        Arrays.stream(arr)
                .map(elem -> elem * 3)
                .forEach(el -> System.out.println(el));


        int w = Arrays.stream(arr)
                .filter(el -> el % 2 == 0) //10 48 42 8
                .map(el -> el * 10) // 100 480 420 80
                .reduce((el1, el2) -> el1 + el2)//1080
                .getAsInt();
        System.out.println(w);



        //System.out.println(a);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            list.add(new Random().nextInt(55));
        }

        //Collection
        List<Integer> s = list.stream()
                .map(el -> el * 5)
                .toList();
    }
}