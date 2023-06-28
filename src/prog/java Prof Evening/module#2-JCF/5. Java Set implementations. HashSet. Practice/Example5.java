/*
Array to Set
 */

import java.util.*;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,11,23,12,98,5,64,1};

//        naive(arr);
//        arraysAsList(arr);
//        collectionsAddAll(arr);
//        javaStream(arr);
        setOf(arr);
    }

    public static void naive(Integer[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int t : arr)
            set.add(t);

        System.out.println(set);
    }

    public static void arraysAsList(Integer[] arr) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        System.out.println(set);
    }

    public static void collectionsAddAll(Integer[] arr) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);

        System.out.println(set);
    }

    public static void javaStream(Integer[] arr) {
        Set<Integer> set = Arrays.stream(arr).collect(Collectors.toSet());
        HashSet<Integer> set2 = new HashSet<>(set);

        System.out.println(set2);
    }

    // должен быть использован массив без дубликатов
    public static void setOf(Integer[] arr) {
        HashSet<Integer> set = new HashSet<>(Set.of(arr));

        System.out.println(set);
    }
}
