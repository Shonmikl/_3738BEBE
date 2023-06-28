import java.util.function.IntSupplier;

public class JTExample8 {
    public static void main(String[] args) {
        IntSupplier i = () -> Integer.MAX_VALUE;
        System.out.println(i.getAsInt());
    }
}
