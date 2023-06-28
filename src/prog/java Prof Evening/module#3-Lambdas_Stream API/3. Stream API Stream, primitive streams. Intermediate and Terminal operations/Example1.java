import java.util.Arrays;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        int result = 0;

        for (Integer i : list) {
            if (i % 2 != 0)
                result += 1;
        }

        System.out.println(result);

        // functional way
        int result2 = list.stream().filter(p -> p % 2 != 0).reduce((c1, c2) -> c1 + c2).orElse(0);
        System.out.println(result2);

        // functional way using reference
        int result3 = list.stream().filter(p -> p % 2 != 0).reduce(Integer::sum).orElse(0);
        System.out.println(result3);
    }
}
