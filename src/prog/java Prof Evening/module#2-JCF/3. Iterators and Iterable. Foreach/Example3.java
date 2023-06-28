/*
ListIterator
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class Example3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println(list);

        ListIterator<String> iterator = list.listIterator();

        System.out.println("Displaying list elements in forward direction: ");

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();
        System.out.println("Displaying list elements in backward direction: ");

        while (iterator.hasPrevious())
            System.out.print(iterator.previous() + " ");

        System.out.println();
    }
}
