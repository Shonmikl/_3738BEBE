import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class JTExample7 {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> s1 = () -> LocalDateTime.now();
        System.out.println(s1.get());

        Supplier<String> s2 = () -> dtf.format(LocalDateTime.now());
        System.out.println(s2.get());
    }
}
