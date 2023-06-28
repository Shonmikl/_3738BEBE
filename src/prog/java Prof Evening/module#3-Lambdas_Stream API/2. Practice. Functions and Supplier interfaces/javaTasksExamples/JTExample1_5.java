import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// привести реализацию, с помощью функционального интерфейса, где коллекция типа List<Integer> будет сконвертирована
// в List<String>
// пример для презентации

public class JTExample1_5 {
    public static void main(String[] args) {
        Function<Integer, String> func = (x) -> "Element: " + x;

        List<Integer> a = Arrays.asList(1,2,3);

//        так
//        List<String> b = a.stream().map(x -> func.apply(x)).toList();

//        или так, т.к. map() пока не изучали
        List<String> b = new ArrayList<>();

        for (Integer i : a)
            b.add("Element " + i);

        System.out.println(b);
    }
}
