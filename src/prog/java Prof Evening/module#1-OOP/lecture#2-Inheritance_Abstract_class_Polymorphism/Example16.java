/*
тип 1: полиморфизм времени компиляции, также известен как статический полиморфизм.
Достигается перегрузкой функций или перегрузкой операторов, Java поддерживает только первый вариант.
 */

public class Example16 {
    public static void main(String[] args) {
        System.out.println(Calculator.multiply(2,2));
        System.out.println(Calculator.multiply(2.1,2.1));
    }
}

class Calculator {
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }
}
