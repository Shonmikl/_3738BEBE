import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class JTExample3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Roman", "Alexey", "Denis", "Yaroslav");
        analogForEach(list, (x) -> System.out.println(x.length()));
    }

    public static void analogForEach(List<String> list, Consumer<String> consumer) {
        for (String s : list)
            consumer.accept(s);
    }
}
