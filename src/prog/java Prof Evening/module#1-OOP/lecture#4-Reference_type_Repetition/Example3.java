/*
автоупаковка и распаковка на примере Collections
 */

import java.util.ArrayList;

public class Example3 {
    public static void main(String[] args) {
        Example3 e3 = new Example3();
        e3.textCollectionBoxing();
    }

    public void textCollectionBoxing() {
        // Creating an empty Arraylist of integer type
        ArrayList<Integer> list = new ArrayList<>();

        // int primitives type values
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("ArrayList: " + list);
    }
}
