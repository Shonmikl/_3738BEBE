import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class JTExample2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,13,42,51);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer =  (x) -> System.out.println(x);
        // it can be "Consumer<Integer> consumer =  (Integer x) -> System.out.println(x);"

        analogForEach(list, consumer);

    }

    // it can be "public static <T> void forEach(List<T> list, Consumer<T> consumer)"
    public static void analogForEach(List<Integer> list, Consumer<Integer> consumer) {

        // it can be "for (T t : list)"
        for (Integer t : list)
            consumer.accept(t);
    }
}
