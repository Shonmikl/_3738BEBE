/*
1. Одиночное наследование.
При одиночном наследовании подклассы наследуют свойства одного суперкласса.
 */

public class Example3 {
}

class One {
    public void printOne() {
        System.out.println("one");
    }
}

class Two extends One {
    public void printFor() {
        System.out.println("two");
    }
}