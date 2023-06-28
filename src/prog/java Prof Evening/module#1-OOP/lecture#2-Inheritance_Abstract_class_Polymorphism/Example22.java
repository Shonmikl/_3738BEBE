/*
Вызов переопределенного метода из подкласса: мы можем вызвать метод родительского класса в переопределяющем методе,
используя ключевое слово super.
 */

public class Example22 {
    public static void main(String[] args) {
        Parent22 child22 = new Child22();
        child22.show();
    }
}

class Parent22 {
    void show() {
        System.out.println("Parent22's show()");
    }
}

class Child22 extends Parent22 {
    @Override
    void show() {
        super.show();
        System.out.println("Child22's show()");
    }
}