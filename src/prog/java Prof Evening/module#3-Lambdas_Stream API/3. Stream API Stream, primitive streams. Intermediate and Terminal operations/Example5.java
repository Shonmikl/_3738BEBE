import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        one();
        two();
        three();
        four();
    }

    public static void one() {
        List<String> list = Arrays.asList("BigBen", "BigBob", "Big", "Ben", "Big Bob");

        System.out.println(list.stream().filter("Big"::equals).count());
    }

    public static void two() {
        List<String> list = Arrays.asList("a1", "b5", "a2", "b4");
        System.out.println(list.stream().min(String::compareTo).get());
    }

    public static void three() {
        List<String> list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        List<String> stringList = list.stream()
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stringList);
    }

    public static void four() {
        List<String> list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        List<String> stringList = list.stream()
                .sorted((o1, o2) -> (-1) * (o1.compareTo(o2)))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stringList);
    }
}
