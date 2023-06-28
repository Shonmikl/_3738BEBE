/*
Наблюдение 3: в Java у нас может быть абстрактный класс без какого-либо абстрактного метода.
Это позволяет нам создавать классы, экземпляры которых нельзя создать, но которые можно только наследовать

 */

public class Example11 {
    public static void main(String[] args) {
        Caller11 caller11 = new Caller11();
        caller11.print();
    }
}

abstract class AbstractClass11 {
    void print() {
        System.out.println("Function of AbstractClass11 is called");
    }
}

class Caller11 extends AbstractClass11 {
    // This class only inherits the Base class methods and properties
}
