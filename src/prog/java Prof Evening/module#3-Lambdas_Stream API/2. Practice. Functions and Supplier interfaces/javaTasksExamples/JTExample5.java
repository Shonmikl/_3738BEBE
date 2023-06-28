import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class JTExample5 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> func1 = (x1, x2) -> x1 + x2;
        System.out.println(func1.apply(1,2));

        BiFunction<Integer, Integer, List<Integer>> func2 = (x1, x2) -> Arrays.asList(x1, x2);
        System.out.println(func2.apply(10,123));
    }
}
