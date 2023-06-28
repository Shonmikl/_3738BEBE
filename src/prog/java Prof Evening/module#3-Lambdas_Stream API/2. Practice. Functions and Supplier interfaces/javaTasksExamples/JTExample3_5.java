import java.util.function.Function;

public class JTExample3_5 {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = (x) -> {
            int result = 1;

            for (int i = 1; i <= x; i++)
                result = result * i;

            return result;
        };

        System.out.println(factorial.apply(5));
    }
}
