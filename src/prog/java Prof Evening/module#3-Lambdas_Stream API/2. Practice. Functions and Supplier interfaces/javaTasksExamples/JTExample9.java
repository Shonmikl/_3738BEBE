import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class JTExample9 {
    public static void main(String[] args) {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return this.previous;
            }
        };

        IntStream.generate(fib).limit(10).forEach(x -> System.out.println(x));
    }
}
