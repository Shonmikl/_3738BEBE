/*
Переопределение и модификаторы доступа: модификатор доступа для переопределяющего метода может разрешить больший, но
не меньший доступ, чем переопределенный метод.
 */

public class Example19 {
    public static void main(String[] args) {
        Parent19 parent19 = new Parent19();
        parent19.methodTwo();

        Parent19 child19 = new Child19();
        child19.methodTwo();
    }
}

class Parent19 {
    private void methodOne() {
        System.out.println("From parent methodOne");
    }

    protected void methodTwo() {
        System.out.println("From parent methodTwo");
    }
}

class Child19 extends Parent19 {
    private void methodOne() {
        System.out.println("From child mathodOne()");
    }

    @Override
    public void methodTwo() {
        System.out.println("From child methodTwo()");
    }
}
