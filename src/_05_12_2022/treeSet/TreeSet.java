package _05_12_2022.treeSet;

import java.util.Set;

public class TreeSet {
    public static void main(String[] args) {
        Set<Integer> treeSet = new java.util.TreeSet<>();
        treeSet.add(5);
        treeSet.add(52);
        treeSet.add(53);
        treeSet.add(54);
        treeSet.add(55);
        treeSet.add(511);
       // treeSet.add(null); нельзя добавлять null в TreeSet

        System.out.println(treeSet);
    }
}
