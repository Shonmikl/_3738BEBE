public class Example8 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show();

        Child child = new Child();
        child.show();
    }
}

class Parent {
    void show() {
        System.out.println("Parent's show");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child's show");
    }
}