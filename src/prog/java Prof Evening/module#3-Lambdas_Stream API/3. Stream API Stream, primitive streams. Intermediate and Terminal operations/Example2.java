import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Конвеерные операции
 */

public class Example2 {
    public static void main(String[] args) {
        List<String> c = Arrays.asList("10", "20", "1", "10", "15", "50", "25");

        System.out.println("Original: " + c);

        // filter & count
        long result = c.stream().filter(p -> p.equals("10")).count();
        System.out.println("Result of filtering and counting: " + result);

        // sorted
        List<String> result2 = c.stream().sorted().collect(Collectors.toList());
        System.out.println("Result of sorting: " + result2);

        // sorted & limit
        List<String> result3 = c.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("Result of sorting and limit(3): " + result3);

        // sorted & skip
        List<String> result4 = c.stream().sorted().skip(3).collect(Collectors.toList());
        System.out.println("Result of sorting and skip(3): " + result4);

        // distinct
        List<String> result5 = c.stream().distinct().collect(Collectors.toList());
        System.out.println("Result of distinct: " + result5);

        // actions via peek()
        System.out.print("Result of peek() mathod: ");
        c.stream().peek( (e) -> System.out.print(e + " hello; ")).collect(Collectors.toList());

        System.out.println();

        // map example1
        System.out.print("Result of map() mathod: ");
        c.stream().map( x -> x + " times").forEach(q -> System.out.print(q + " "));

        System.out.println();

        // map example2
        int[] q = new int[]{1,2,3,4,5};
        int[] qq = Arrays.stream(q).map(x -> x + 10).toArray();
        System.out.println("Result of map example2: " + Arrays.toString(qq));

        // mapToInt
        int[] result6 = c.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
        System.out.println("Result of mapToInt() method: " + Arrays.toString(result6));

        // flatmap (как бы распаковка коллекции или работа с элементами элементов коллекции)
        ArrayList<List<Integer>> l1 = new ArrayList<>();

        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        l1.add(one);
        l1.add(two);

        System.out.print("Result of flatmap method: ");
        l1.stream()
                .flatMap(x -> x.stream())
                .map(x -> x * 2)
                .forEach( x -> System.out.print(x + " "));
        System.out.println();

        // flatmap example2
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> listOfAllIntegers = listOfLists
                .stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Result of example2 for flatmap method: " + listOfAllIntegers);

    }
}
