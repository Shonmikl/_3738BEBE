/*
Если дочерний класс не может обеспечить реализацию всех абстрактных методов родительского класса, тогда мы должны объявить этот дочерний класс абстрактным, чтобы дочерний класс следующего уровня обеспечивал реализацию оставшегося абстрактного метода.
 */

public class Example15 {
    public static void main(String[] args) {
        SecondChild secondChild = new SecondChild();
        secondChild.methodOne();
        secondChild.methodTwo();
        secondChild.methodThree();
    }
}

abstract class ParentAbstract {
    abstract void methodOne();
    abstract void methodTwo();
    abstract void methodThree();
}

abstract class FirstChild extends ParentAbstract {
    @Override
    void methodOne() {
        System.out.println("Inside methodOne");
    }
}

class SecondChild extends FirstChild {
    @Override
    void methodTwo() {
        System.out.println("Inside methodTwo");
    }

    @Override
    void methodThree() {
        System.out.println("Inside methodThree");
    }
}