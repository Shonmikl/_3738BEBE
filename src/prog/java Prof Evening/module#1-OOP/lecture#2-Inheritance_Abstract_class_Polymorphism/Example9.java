/*
Наблюдение 1: В Java, экземпляр абстрактного класса не может быть создан, хотя у нас могут быть ссылки на тип
абстрактного класса.
 */

public class Example9 {
    public static void main(String[] args) {
        AbstractClass caller = new Caller();
        caller.print();
    }
}

abstract class AbstractClass {
    public abstract void print();
}

class Caller extends AbstractClass {
    @Override
    public void print() {
        System.out.println("Caller print() called");
    }
}