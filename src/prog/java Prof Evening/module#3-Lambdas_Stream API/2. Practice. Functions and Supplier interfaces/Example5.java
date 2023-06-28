import java.util.Optional;
import java.util.function.Supplier;

/*
Note -> Optional - это новое для группы, можно коротко рассказать, для понимания.
Класс Optional, представленный в Java 8.
Цель класса — предоставить решение на уровне типа для представления необязательных значений вместо null ссылок.
 */

public class Example5 {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random();

        Optional<Double> optional = Optional.empty();
        System.out.println(optional.orElseGet(supplier));
    }
}
