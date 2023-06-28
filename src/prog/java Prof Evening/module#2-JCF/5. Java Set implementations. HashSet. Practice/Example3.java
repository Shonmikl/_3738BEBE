import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class Example3 {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();

        set.add("Apple");
        set.add("Lemon");
        set.add("Banana");
        set.add("Apple");

        Iterator<String> itr = set.iterator();

        System.out.print("Fruits set: ");
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }
}
