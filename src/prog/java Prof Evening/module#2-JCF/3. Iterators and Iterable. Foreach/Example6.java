import java.util.ArrayList;
import java.util.Iterator;

public class Example6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(10);
        list.add(100);
        list.add(32);

        System.out.println(list);

//        one(list);
//        two(list);
//        three(list);
//        four(list);
    }

    // #1
    public static void one(ArrayList<Integer> list) {
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            Integer integer = list.get(i);
            System.out.print(integer + " ");
        }
    }

   //  #2 - читаем «:», используемый в цикле for-each, как «in». цикл читается как «для каждого элемента в элементах»
    public static void two(ArrayList<Integer> list) {
        for (Integer integer: list)
            System.out.print(integer + " ");
    }

    // #3 - В Java 8, используя лямбда-выражения, мы можем просто заменить цикл for-each на
    public static void three(ArrayList<Integer> list) {
        list.forEach(x -> System.out.print(x + " "));
    }

    // #4 - Итератор — это интерфейс, предоставляемый структурой для обхода коллекции и для последовательного доступа к
    // элементам
    public static void four(ArrayList<Integer> list) {
        for (Iterator<Integer> i = list.iterator();  i.hasNext(); ) {
            System.out.print(i.next() + " ");
        }
    }
}
