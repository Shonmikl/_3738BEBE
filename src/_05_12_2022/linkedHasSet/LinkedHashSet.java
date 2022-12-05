package _05_12_2022.linkedHasSet;

public class LinkedHashSet {
    public static void main(String[] args) {
        java.util.LinkedHashSet<Integer> set = new java.util.LinkedHashSet<>();
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(16);
        set.add(17);

        System.out.println(set);
        set.remove(17);
        System.out.println(set);
        System.out.println(set.contains(11));
    }
}