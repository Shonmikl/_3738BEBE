/*
Spliterator
 */

import java.util.ArrayList;
import java.util.Spliterator;

public class Example4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(-3);
        list.add(-4);
        list.add(5);

        System.out.println(list);

        Spliterator spr = list.spliterator();

        // estimateSize method
        System.out.println("estimate size: " + spr.estimateSize());

        // getExactSizeIfKnown method
        System.out.println("exact size: " + spr.getExactSizeIfKnown());

        // hasCharacteristics and characteristics method
        System.out.println(spr.hasCharacteristics(spr.characteristics()));
    }
}
