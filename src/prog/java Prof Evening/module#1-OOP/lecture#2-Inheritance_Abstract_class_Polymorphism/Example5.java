/*
Иерархическое наследование.
При иерархическом наследовании один класс служит суперклассом (базовым классом) для более чем одного подкласса.
 */

public class Example5 {
    public static void main(String[] args) {
        B b = new B();
        b.printA();
        b.printB();

        C c = new C();
        c.printA();
        c.printC();

        D d = new D();
        d.printA();
        d.printD();
    }
}

class A {
    public void printA() { System.out.println("Class A"); }
}

class B extends A {
    public void printB() { System.out.println("Class B"); }
}

class C extends A {
    public void printC() { System.out.println("Class C"); }
}

class D extends A {
    public void printD() { System.out.println("Class D"); }
}