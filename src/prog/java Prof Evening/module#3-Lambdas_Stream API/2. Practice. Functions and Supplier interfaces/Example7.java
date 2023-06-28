import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class Example7 {
    public static void main(String[] args) {
        Random random = new Random();

        IntSupplier intSupplier = () -> random.nextInt();
        DoubleSupplier doubleSupplier = () -> random.nextDouble();
        LongSupplier longSupplier = () -> random.nextLong();
        BooleanSupplier booleanSupplier = () -> random.nextBoolean();

        System.out.println(intSupplier.getAsInt());
        System.out.println(doubleSupplier.getAsDouble());
        System.out.println(longSupplier.getAsLong());
        System.out.println(booleanSupplier.getAsBoolean());
    }
}
