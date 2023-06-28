import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
пример использования Iterator

Преимущества итератора
- можем использовать его для любого класса Collection.
- поддерживает операции READ и REMOVE.
- универсальный API для Collection.
- Названия методов просты и их легко использовать.
 */

public class Example1 {
    public static void main(String[] args) {
        iteratorRemove();
    }

    public static void iteratorGeneralExample() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Iterator<String> iterator = list.iterator();

        System.out.println("List elements: ");

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();
    }

    public static void iteratorRemove() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            list.add(i);


        System.out.println(list);

//        for (Integer e : new ArrayList<>(list))
//            if (e.intValue() % 2 != 0)
//                list.remove(e);

//        OR

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 != 0) {
//                list.remove(i);
//            }
//        }

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int element = itr.next();

            if (element % 2 != 0)
                itr.remove();
        }

        System.out.println(list);

    }
}
