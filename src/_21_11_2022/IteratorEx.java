package _21_11_2022;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ivan");
        arrayList.add("Petr");
        arrayList.add("Mikhail");
        arrayList.add("Mariya");
        arrayList.add("Nikolay");
        arrayList.add("Elena");
        arrayList.add("Svetlana");

        System.out.println(arrayList);
        // Сигнатура = форма записи
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayList);
    }
}