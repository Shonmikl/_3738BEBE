/*
Переопределение метода — это один из способов достижения полиморфизма во время выполнения в Java.
Версия выполняемого метода будет определяться объектом, который используется для его вызова.
Если для вызова метода используется объект родительского класса, то будет выполняться версия в родительском классе,
но если для вызова метода используется объект подкласса, то будет выполняться версия в дочернем классе.
 */

public class Example18 {
    public static void main(String[] args) {
        Parent18 parent18 = new Parent18();
        parent18.show();

        Parent18 child18 = new Child18();
        child18.show();
    }
}

class Parent18 {
    void show() {
        System.out.println("Parent18's show()");
    }
}

class Child18 extends Parent18 {
    @Override
    void show() {
        System.out.println("Child18's show");
    }
}
