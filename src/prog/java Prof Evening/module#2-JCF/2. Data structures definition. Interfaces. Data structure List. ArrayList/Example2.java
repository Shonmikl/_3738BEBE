import java.util.AbstractList;
import java.util.ArrayList;

/*
Ассоциация с интерфейсом
AbstractList, CopyOnWriteArrayList и AbstractSequentialList — это классы, реализующие интерфейс List

AbstractList: этот класс используется для реализации немодифицируемого списка, для которого нужно только расширить этот
класс AbstractList и реализовать только методы get() и size().
AbstractList — это абстрактный класс, поэтому ему следует назначить экземпляр его подклассов
 */

public class Example2 {
    public static void main(String[] args) {
        // Creating an empty AbstractList
        AbstractList<String> list = new ArrayList<String>();

        list.add("I");
        list.add("am");
        list.add("learning");
        list.add("Java");

        System.out.println("AbstractList:" + list);
    }
}
