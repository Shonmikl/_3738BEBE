import java.util.function.DoubleConsumer;

public class JTExample4 {
    public static void main(String[] args) {
        DoubleConsumer consumer = a -> System.out.println(a * 10);
        consumer.accept(50);
    }
}
