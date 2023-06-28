/*
final методы не могут быть переопределены: если мы не хотим, чтобы метод был переопределен, мы объявляем его как final.
 */

public class Example20 {
}

class Parent20 {
    final void show() {
        System.out.println("show from Parent20");
    }
}

class Child20 extends Parent20 {
    // it doesn't allow
    // void show() {}
}