import java.util.function.Consumer;

public class JTExample1 {
    public static void main(String[] args) {
        Consumer<String> print = (x) -> System.out.println(x);
        print.accept("java");
    }
}

