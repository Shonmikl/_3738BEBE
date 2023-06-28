import java.util.function.Supplier;

public class JTExample6 {

    private static final String VERSION = "v.1.14.9";

    public static void main(String[] args) {
        Supplier<Double> randomizer = () -> Math.random();

        System.out.println(randomizer.get());
        System.out.println(randomizer.get());
        System.out.println(randomizer.get());
        System.out.println(randomizer.get());


        Supplier<String> version = () -> VERSION;
        System.out.println(version.get());
        System.out.println(version.get());

    }
}
