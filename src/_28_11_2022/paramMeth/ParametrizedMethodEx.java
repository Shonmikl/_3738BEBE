package _28_11_2022.paramMeth;

import java.util.ArrayList;

public class ParametrizedMethodEx {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(122);
        integers.add(123);
        integers.add(142);
        System.out.println(GetMethod.getSecondElement(integers));

    }
}

class GetMethod {
    public static <T extends Number> T getSecondElement(ArrayList<T> list) {
        return list.get(1);
    }
}

class Pair1<V> {
    private V value1;
    private V value2;

    public V get(V var) {
        return var;
    }

    public Pair1(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }
}