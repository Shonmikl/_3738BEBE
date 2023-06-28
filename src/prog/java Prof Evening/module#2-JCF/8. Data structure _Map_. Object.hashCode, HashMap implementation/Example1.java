import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example1 {
    public static void main(String[] args) {

        /*
        Хранит данные в парах (Ключ, Значение).
        Один объект используется как ключ (индекс) для другого объекта (значения).
        При попытке вставить дубликат ключа, заменится элемент соответствующего ключа.
        HashMap похож на HashTable, но не синхронизирован.
        Позволяет хранить null ключ, но только один и может быть любое количество null значений.
        Этот класс не дает никаких гарантий относительно порядка отображения.
         */

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("a", 100);
        hashMap.put("b", 200);
        hashMap.put("c", 300);
        hashMap.put("d", 400);
        hashMap.put("e", 500);

        System.out.println(hashMap);

        /*
        LinkedHashMap.
        Такой же, как и HashMap, с дополнительной функцией поддержания порядка вставленных в него элементов.
        HashMap предоставлял преимущество быстрой вставки, поиска и удаления, но никогда не поддерживал порядок
        вставки, которые обеспечивает LinkedHashMap, где элементы могут быть доступны в их порядке вставки.
         */

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("a", 100);
        linkedHashMap.put("b", 200);
        linkedHashMap.put("c", 300);
        linkedHashMap.put("d", 400);
        linkedHashMap.put("f", 500);
        linkedHashMap.put("g", 600);

        System.out.println(linkedHashMap);


        /*
        TreeMap
         */
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("a", 100);
        treeMap.put("b", 200);
        treeMap.put("c", 300);

        System.out.println(treeMap);

    }
}
