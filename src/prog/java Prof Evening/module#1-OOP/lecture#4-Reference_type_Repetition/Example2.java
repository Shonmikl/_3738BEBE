/*
преимущество автоматической упаковки и распаковки
-> позволяет нам взаимозаменяемо использовать примитивные типы и объекты класса Wrapper, не нужно явно выполнять
какое-либо приведение типов
 */

public class Example2 {
    public static void main(String[] args) {

        // Integer object
        Integer i = Integer.valueOf(20);

        // unboxing the object
        int unbox = i;

        System.out.println("Value of i: " + i);
        System.out.println("Value of unboxing i: " + unbox);

        // autoboxing of character
        Character a = 'a';

        // unboxing of Character
        char ch = a;

        System.out.println("Value of a: " + a);
        System.out.println("Value of unboxing ch: " + ch);
    }
}
