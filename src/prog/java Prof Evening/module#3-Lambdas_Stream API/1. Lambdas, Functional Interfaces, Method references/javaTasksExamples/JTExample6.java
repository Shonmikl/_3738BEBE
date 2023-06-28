import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JTExample6 {

    static List<Integer> list = Arrays.asList(1,2,3,10,11,12,31,32,33);

    public static void main(String[] args) {
        usingFiler();
        usingPredicate();
        usingPredicateAndMethod();
        usingPredicateOrMethod();
    }

    public static void usingFiler() {

        List<Integer> list_result = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(list_result);
    }

    public static void usingPredicate() {
        Predicate<Integer> predicate = (x) -> x > 5;

        List<Integer> list_result = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(list_result);
    }

    public static void usingPredicateAndMethod() {
        Predicate<Integer> predicateMore5 = (x) -> x > 5;
        Predicate<Integer> predicateLess30 = (x) -> x < 30;

        List<Integer> list_result = list.stream().filter(predicateMore5.and(predicateLess30)).toList();
        System.out.println(list_result);
    }

    public static void usingPredicateOrMethod() {
        Predicate<Integer> predicateMore12 = (x) -> x > 11;
        Predicate<Integer> predicateEquals10 = (x) -> x == 10;

        List<Integer> list_result = list.stream().filter(predicateMore12.or(predicateEquals10)).toList();
        System.out.println(list_result);
    }
}
