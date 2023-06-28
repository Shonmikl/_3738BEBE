import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        List<String> names = Arrays.asList("Java", "Collection", "Stream", "Array");
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        result = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        System.out.print("Map result: ");
        number.stream().map(x -> x * x).forEach(x -> System.out.print(x + " "));
        System.out.println();

        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        // или тоже самое, но по-другому
//        int even = number.stream().filter(x -> x % 2 == 0).reduce((ans, i) -> (ans + i)).stream().mapToInt(Integer::intValue).sum();
        System.out.println(even);
    }
}
