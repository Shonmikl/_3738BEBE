/*
Полиморфизм времени выполнения
Полиморфизма достигается переопределением метода.
 */

public class Example17 {
    public static void main(String[] args) {
        Parent17 parent17;

        parent17 = new ChildOne17();
        parent17.print();

        parent17 = new ChildTwo17();
        parent17.print();
    }
}

class Parent17 {
    void print() {
        System.out.println("parent class");
    }
}

class ChildOne17 extends Parent17 {
    @Override
    void print() {
        System.out.println("childOne17 class");
    }
}

class ChildTwo17 extends Parent17 {
    @Override
    void print() {
        System.out.println("childTwo17 class");
    }
}