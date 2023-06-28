import java.util.function.Function;

/*
Статический метод интерфейса Function: identity()
Возвращает интерфейс Function, который всегда возвращает входной параметр
 */

public class Example3 {
    public static void main(String[] args) {
        Function<String, String> function = Function.identity();

        System.out.println(function.apply("Some value"));
    }
}
