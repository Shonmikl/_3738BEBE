public class Example1 {
    public static void main(String[] args) {
//        primitiveExample();
//        primitiveAnotherExample();
        objectExample();
    }

    // Для примитивных типов быть одинаковым означает иметь одинаковые значения!!!
    public static void primitiveExample() {
        int a = 1;
        int b = 1;

        boolean isEqualsPrimitive = a == b;

        System.out.println(isEqualsPrimitive);
    }

    // C автоматической распаковкой это также работает при сравнении примитивного значения с его классом-оберткой:
    public static void primitiveAnotherExample() {
        int a = 1;
        Integer b = Integer.valueOf(1);

        boolean isEqualsPrimitive = a == b;

        System.out.println(isEqualsPrimitive);
    }

    // сравнение объектов
    public static void objectExample() {
        Cat one = new Cat();
        Cat two = new Cat();

        System.out.println(one.equals(two));
    }
}

class Cat {
    String name;
    int age;
}