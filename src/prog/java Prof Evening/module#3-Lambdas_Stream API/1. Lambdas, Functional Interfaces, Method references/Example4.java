import java.util.function.Supplier;

/*
Supplier не принимает никаких входных данных или аргументов и при этом возвращает один выходной тип.
Обычно используется при ленивой генерации значений или для определения логики генерации любой последовательности.
Например, логика ряда Фибоначчи может быть сгенерирована с помощью метода Stream.generate, который реализуется
функциональным интерфейсом поставщика.

Расширения функционального интерфейса BooleanSupplier, DoubleSupplier, LongSupplier и IntSupplier.
Возвращаемый тип всех этих дополнительных специализаций — это только их соответствующие примитивы.

Синтаксис
@FunctionalInterface
Supplier<T> {
    T.get();
}
 */

public class Example4 {
    public static void main(String[] args) {

        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
    }
}
