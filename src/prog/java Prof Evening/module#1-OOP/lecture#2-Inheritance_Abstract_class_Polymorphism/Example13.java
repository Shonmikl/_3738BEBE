/*
Наблюдение 6: мы можем использовать ключевое слово abstract для объявления классов верхнего уровня (внешний класс),
а также внутренних классов как абстрактных.
 */

public class Example13 {
    public static void main(String[] args) {
        ClassThird outer = new ClassThird();

        ClassThird.ClassFour inner = outer.new ClassFour();
        inner.printAbstract();
    }
}

abstract class ClassOne {
    public abstract class ClassTwo {
        abstract void printAbstract();
    }
}

class ClassThird extends ClassOne {
    class ClassFour extends ClassTwo {
        @Override
        void printAbstract() {
            System.out.println("Inside abstract method implementation");
        }
    }
}