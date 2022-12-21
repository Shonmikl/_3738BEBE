package _19_12_2022.streams;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        int[] numbers = {4, 51, 32, 1, 21, 24, 5, 7, 89, 86, 5, 4, 12, 20, 2, 6, 71};

        //map()
//        int[] map = Arrays.stream(numbers)
//                .map(el -> el * 2)
//                .toArray();
//        System.out.println(Arrays.toString(map));

        //filter() // forEach()
//       Arrays.stream(numbers)
//                .filter(el -> el % 2 == 0)
//                .forEach(System.out::println);

       //reduce()
//        int reduce = Arrays.stream(numbers)
//                .reduce((num1, num2) -> num1 + num2)
//                .getAsInt();
//        System.out.println(reduce);

        //sorted()
//        int[] sorted = Arrays.stream(numbers)
//                .sorted().toArray();
//        System.out.println(Arrays.toString(sorted));

        //method chaining
        //{4, 51, 32, 1, 21, 24, 5, 7, 89, 86, 5, 4, 12, 20, 2, 6, 71};
//        int chain = Arrays.stream(numbers)
//                .filter(el -> el % 2 == 1) //{51, 1, 21, 5, 7, 89, 5, 71};
//                .map(el -> {
//                    if(el % 5 == 0) {
//                        el /= 5;
//                    }
//                    return el;
//                })//{51, 1, 21, 1, 7, 89, 1, 71};
//                .reduce((el1, el2) -> el1 + el2)
//                .getAsInt();
//        System.out.println(chain);

        //distinct()
        int[] dis = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
//        Arrays.stream(dis)
//                .distinct()
//                .forEach(System.out::println);

        //count()
        long c = Arrays.stream(dis)
                .count();
        System.out.println(c);

//        List<Integer> list = List.of(1);
//        list.set(0, 55);
//        System.out.println(list);
    }
}