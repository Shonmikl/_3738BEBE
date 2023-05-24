package _20_02_2023;

public class Test3 {
}

class Parent {
    void get() {
        System.out.println("P");
    }
}

class Child extends Parent {

    @Override
    void get() {
        System.out.println("C");
    }
}