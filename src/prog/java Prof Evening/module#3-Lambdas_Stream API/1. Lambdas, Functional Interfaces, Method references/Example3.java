import java.util.function.Function;

/*
Function — это тип функционального интерфейса в Java, который получает только один аргумент и возвращает значение
после необходимой обработки

Bi-Function — принимает два аргумента

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

Unary Operator and Binary Operator - расширяют Function и Bi-Function
унарный оператор принимает только один аргумент и возвращает только один аргумент
бинарный оператор принимает два значения и возвращает одно значение, сравнимое с бифункцией

! тип входного и выходного значения должен быть идентичным и иметь один и тот же тип
 */

public class Example3 {

    public static void main(String[] args) {

        // Function which takes in a number and returns half of it
        Function<Integer, Double> half = (a) -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(8));
    }
}
