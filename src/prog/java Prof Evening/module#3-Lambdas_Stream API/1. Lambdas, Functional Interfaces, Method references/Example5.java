import java.util.ArrayList;

public class Example5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<>();

        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        arrL.add(5);

        arrL.forEach(n -> System.out.print(n + " "));

        System.out.println();

        arrL.forEach(n -> {
            if (n % 2 == 0)
                System.out.print(n + " ");
        });

    }
}
