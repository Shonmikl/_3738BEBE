/*
Наблюдение 5: Подобно интерфейсу, мы можем определить статические методы в абстрактном классе, которые можно вызывать
без объекта.
 */

public class Example12 extends Helper {
    public static void main(String[] args) {
        Helper.print();
    }
}

abstract class Helper {
    public static void print() {
        System.out.println("Print from class Helper");
    }
}
