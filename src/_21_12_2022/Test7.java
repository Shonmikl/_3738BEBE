package _21_12_2022;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test7 {
    public static void main(String[] args) {
        int[] test = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};

        //Arrays.stream(arr) == stream
        Stream<Integer> stream = Stream.of(1, 1, 2, 2, 3, 3, 4, 4, 5);
        Stream<Integer> stream1 = Stream.of(5, 6, 6, 7, 7, 8, 8, 9, 9);

        //Arrays.stream(test) == integerStream
        Stream<Integer> integerStream = Stream.concat(stream, stream1);
       // integerStream.forEach(System.out::print);

        //distinct()
       // integerStream.distinct().forEach(System.out::print);


        //count()
       // System.out.println(integerStream.count());
       // System.out.println(integerStream.distinct());

        //peek()
        System.out.println(integerStream.distinct().peek(System.out::println).count());
    }
}
