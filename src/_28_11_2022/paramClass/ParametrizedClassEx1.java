package _28_11_2022.paramClass;

import java.util.Map;
import java.util.function.BiFunction;

public class ParametrizedClassEx1 {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("K", 55);
        System.out.println(pair.getValue1() + " : " + pair.getValue2());
    }
}

class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}
