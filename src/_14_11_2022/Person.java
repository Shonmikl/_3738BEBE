package _14_11_2022;

import java.io.Serializable;

public class Person {
    void walk() {};

    public static void main(String[] args) {
    }
}

class Child1 extends Person {

}

class Child2 extends Person implements Flyable, Serializable {

    @Override
    public void fly() {

    }
}

interface Flyable {
    void fly();
}
