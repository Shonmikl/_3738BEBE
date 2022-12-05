package _05_12_2022;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        linkedList.add(15);
        linkedList.add(16);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        ListIterator<Integer> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous();
            listIterator.remove();
            System.out.println(linkedList);
        }



    }
}
