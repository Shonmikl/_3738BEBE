package _28_11_2022.subTyping;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        X x = new Y();
        List<Integer> list = new ArrayList<Integer>();

    }
}

class X {

}

class Y extends X {

}
