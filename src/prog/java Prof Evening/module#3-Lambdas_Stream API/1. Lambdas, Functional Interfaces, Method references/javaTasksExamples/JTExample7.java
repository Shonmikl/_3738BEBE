import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JTExample7 {
    public static void main(String[] args) {
        IntPredicate predicate = (x) -> x > 10;
        List<Integer> list = Arrays.asList(11,5,20,4,18);

        for (Integer k : list)
            System.out.println(predicate.test(k));

        // or use
//        List<Integer> list_result = IntStream.of(11,5,20,4,18).filter(predicate).boxed().toList();
//        System.out.println(list_result);
    }
}
