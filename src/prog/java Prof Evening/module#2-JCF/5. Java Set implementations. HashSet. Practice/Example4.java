import java.util.ArrayList;
import java.util.HashSet;

/*
Класс HashSet предоставляет высокопроизводительные операции над множеством.
но не стоит забывать об их избыточности. Hash-set-ы резервируют значительно больше памяти, чем нужно для хранения их элементов, поэтому если есть ограничения их имеет смысл использовать только для множеств среднего размера (1000-10000 элементов).
Вы тратите память, чтобы получить более быстрые вычисления.
Для больших множеств следует присмотреться к деревьям.
 */

public class Example4 {
    public static void main(String[] args) {
        HashSet<ArrayList> set = new HashSet<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);

        set.add(list1);
        set.add(list2);

        System.out.println(set);

    }
}
