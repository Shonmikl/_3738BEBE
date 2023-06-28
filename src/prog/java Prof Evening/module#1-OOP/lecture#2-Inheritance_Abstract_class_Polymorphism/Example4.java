/*
2. Многоуровневое наследование:
в многоуровневом наследовании производный класс будет наследовать базовый класс, и как, и производный класс, он также
будет выступать в качестве базового класса для другого класса.

 */

public class Example4 {
}

class OneOne {
    public void printOne() {
        System.out.println("One");
    }
}


class TwoTwo extends OneOne {
    public void printTwo() {
        System.out.println("Two");
    }
}

class ThreeThree extends TwoTwo {
    public void printThree() {
        System.out.println("Three");
    }
}