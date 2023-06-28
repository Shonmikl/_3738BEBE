/*
Наблюдение 7: если класс содержит хотя бы один абстрактный метод, то обязательно мы должны объявить класс абстрактным,
иначе мы получим ошибку времени компиляции.
 */

public class Example14 {
    public static void main(String[] args) {
        Child14 child14 = new Child14();
        child14.print();
    }
}

abstract class Demo {
    abstract void print();
}

class Child14 extends Demo {
    @Override
    void print() {
        System.out.println("Hello child");
    }
}