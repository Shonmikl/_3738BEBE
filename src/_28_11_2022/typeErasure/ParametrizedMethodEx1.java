package _28_11_2022.typeErasure;

import java.util.ArrayList;

public class ParametrizedMethodEx1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList integers = new ArrayList();
        int i = list.get(0);
        //int i = (Integer) list.get(0);
    }
}