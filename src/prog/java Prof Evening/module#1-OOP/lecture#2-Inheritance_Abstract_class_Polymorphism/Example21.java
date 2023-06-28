/*
Статические методы не могут быть переопределены.
Когда вы определяете статический метод с той же сигнатурой, что и статический метод в базовом классе, это называется
сокрытием метода.
 */

public class Example21 {
}

class Parent21 {
    public static void methonOne() {
        System.out.println("Froma parent21 static methodOne()");
    }

    public void methodTwo() {
        System.out.println("Froma parent21 non-static methodTwo()");
    }
}

class Child21 extends Parent21 {
    // it doesn't allow
//    @Override
//    public void methodOne() {
//        System.out.println("From Child21 non-static methodTwo()");
//    }

    @Override
    public void methodTwo() {
        System.out.println("From Child21 non-static methodTwo()");
    }
}