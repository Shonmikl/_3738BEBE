import java.util.Comparator;
import java.util.function.Function;

public class Example1 {
    public static void main(String[] args) {

        /*
        Type parameters:
        <T> – the type of the input to the function
        <R> – the type of the result of the function
         */

        Function<Double, Long> function = (aDouble) -> Math.round(aDouble);
        System.out.println(function.apply(3.6));
    }
}