package _28_11_2022.paramClass;

import java.lang.constant.Constable;
import java.util.ArrayList;

public class ParametrizedClassEx {
    public static void main(String[] args) {
        //Info<String> info = new Info<>("Hi");
//        System.out.println(info);
//        String s = info.getValue();


        Info<? extends Number> info1 = new Info<>(11);
        System.out.println(info1);
    }

//    public void get(Info<String> info) {Info info
//        String s = info.getValue();
//    }
//
//    public void get(Info<Integer> info) {Info info
//        Integer s = info.getValue();
//    }
}

class Info<T extends Number & Constable> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Info: " + value;
    }
}

interface Inter {

}

interface Supers {

}
//
//class Parent<T> {
//    public void get(Info<Integer> info) {
//        info.getValue();
//    }
//}
//
//class Child<T> extends Parent<T> {
//    public void get(Info<Integer> info) {
//        info.getValue();
//    }
//}