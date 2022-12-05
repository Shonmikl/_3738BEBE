package _05_12_2022.hashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(2);
        set1.add(1);
        set1.add(3);
        set1.add(8);

        Set<Integer> set2 = new HashSet<>();
        set2.add(7);
        set2.add(4);
        set2.add(3);
        set2.add(5);
        set2.add(8);

//        Set<Integer> union = new HashSet<>(set1);
//        Set<Integer> intersect = new HashSet<>(set1);
//        intersect.retainAll(set2);
//        System.out.println(intersect);

        Set<Integer> subtract = new HashSet<>(set1);
        for (Integer i : subtract) {
            System.out.println(i);
        }
        subtract.removeAll(set2);
        System.out.println(subtract);
    }
}
