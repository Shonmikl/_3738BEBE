import java.util.function.Function;

public class JTExample2 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = (x) -> x.length();
        Function<Integer, Integer> func2 = (x) -> x * 2;

        int result = func1.andThen(func2).apply("Java");
        System.out.println(result);
    }
}
