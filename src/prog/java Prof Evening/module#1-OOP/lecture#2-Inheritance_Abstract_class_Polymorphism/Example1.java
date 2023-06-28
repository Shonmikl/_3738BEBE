public class Example1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.voice();
    }
}

class Dog {
    public void voice() {
        System.out.println("Dog voice!");
    }
}

class Cat extends Dog {
    @Override
    public void voice() {
        super.voice();
        System.out.println("Cat voice!");
    }
}