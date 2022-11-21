package _21_11_2022;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorEx {
    public static void main(String[] args) {
        String s = "text";

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Ivan");
        linkedList.add("Petr");
        linkedList.add("Mikhail");
        linkedList.add("Mariya");
        linkedList.add("Nikolay");
        linkedList.add("Elena");
        linkedList.add("Svetlana");

        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("**********************************");

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
