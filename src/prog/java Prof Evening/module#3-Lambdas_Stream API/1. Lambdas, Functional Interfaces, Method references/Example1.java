import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
Consumer - принимает только один аргумент.
Интерфейс не имеет возвращаемого значения. Ничего не возвращает.
Существуют также функциональные варианты
Consumer — DoubleConsumer, IntConsumer и LongConsumer.
Эти варианты принимают примитивные значения в качестве аргументов.

Bi-Consumer — вариант интерфейса Consumer - принимает два аргумента.
Bi-Consumer не имеет возвращаемого значения.

Синтаксис:
Consumer<Integer> consumer = (value) -> System.out.println(value);

Эта реализация функционального интерфейса Java Consumer печатает значение, переданное в качестве параметра оператору
печати.
 */

public class Example1 {
    public static void main(String[] args) {
        // Consumer to display a number
        Consumer<Integer> display = System.out::println;

        // Implement display using accept()
        display.accept(10);

        Consumer<List<Integer>> modify = list -> list.replaceAll(integer -> 2 * integer);
        Consumer<List<Integer>> displayList = list -> list.forEach(a -> System.out.print(a + " "));

        // Consumer to display a list of numbers
        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Implement displayList using accept()
        displayList.accept(list);
    }
}

