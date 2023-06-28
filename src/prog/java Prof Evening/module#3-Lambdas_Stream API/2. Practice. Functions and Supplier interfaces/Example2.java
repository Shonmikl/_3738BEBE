import java.util.function.Function;

/*
смотрим разницу между default методами
 */

public class Example2 {
    public static void main(String[] args) {

        Function<String, String> function1 = (s) -> s + "1";
        Function<String, String> function2 = (s) -> s + "2";
        Function<String, String> function3 = (s) -> s + "3";
        Function<String, String> function4 = (s) -> s + "4";

        System.out.println(
                function1
                        .andThen(function2)
                        .compose(function3)
                        .compose(function4)
                        .apply(" -> Compose ")
        );

        System.out.println(
                function1
                        .andThen(function2)
                        .andThen(function3)
                        .andThen(function4)
                        .apply(" And then ")
        );
    }
}
