import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        two();
    }

    public static void one() {
        int[][] arr = {{1, 2, 3}, {17, 13, 15}, {7, 9, 23}};

        int[] newArr = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)   // преобразовываем IntStream<int[]> в IntStream, можно
                                                        // написать через лямбду
                .toArray(); 			                // преобразовываем IntStream в int[]

        System.out.println(Arrays.toString(newArr));
    }

    public static void two() {
        // Отфильтровать "a" (исключить из печати) и распечатать все символы.
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> !x.equals("a"))
                .forEach(x -> System.out.print(x + " "));

        // или
        List<String> collect = Stream.of(array)      // создали Stream<String[]>
                .flatMap(Stream::of)                 // преобразовали в Stream<String>
                .filter(x -> !"a".equals(x))         // отфильтровали "a"
                .collect(Collectors.toList());       // вернули как лист

        collect.forEach(System.out::print);
    }
}
