package _14_11_2022;

public class InheritanceEx {
    public static void main(String[] args) {
        Animal animal = new Cat();
        int a = animal.hashCode();
        System.out.println(a);
    }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}