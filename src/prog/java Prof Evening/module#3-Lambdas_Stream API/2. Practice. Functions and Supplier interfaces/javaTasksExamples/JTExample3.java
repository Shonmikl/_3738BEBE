import java.util.function.Function;

public class JTExample3 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiply2 = (a) -> a * 2;
        Function<Integer, Integer> multiply10 = (a) -> a * 10;
        Function<Integer, Integer> add3 = (a) -> a + 3;
        Function<Integer, Integer> add1 = (a) -> a + 1;

        // (((3 * 2) + 3) + 1) => 10
        Function<Integer, Integer> oneChain = multiply2.andThen(add3).andThen(add1);
        System.out.println(oneChain.apply(3));

        // ((((3 * 10) + 1) + 3) * 2 => 68
        Function<Integer, Integer> twoChain = multiply2.compose(add3).compose(add1).compose(multiply10);
        System.out.println(twoChain.apply(3));
    }
}
