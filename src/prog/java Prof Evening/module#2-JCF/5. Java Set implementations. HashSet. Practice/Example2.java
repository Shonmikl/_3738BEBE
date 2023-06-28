import java.util.TreeSet;

/*
Итерация по SortedSet
 */

public class Example2 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A");

        for (String value : set)
            System.out.print(value + " ");
    }
}
