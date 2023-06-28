/*
Наблюдение 2: абстрактный класс в Java может содержать конструкторы.
А конструктор абстрактного класса вызывается при создании экземпляра унаследованного класса.

 */

public class Example10 {
    public static void main(String[] args) {
        Caller10 caller10 = new Caller10();
        caller10.print();
    }
}

abstract class AbstractClass10 {
    AbstractClass10() {
        System.out.println("AbstractClass10 Constructor Called");
    }

    abstract void print();
}

class Caller10 extends AbstractClass10 {
    Caller10() {
        System.out.println("Caller10 Constructor Called");
    }

    @Override
    void print() {
        System.out.println("Caller10 print() called");
    }
}