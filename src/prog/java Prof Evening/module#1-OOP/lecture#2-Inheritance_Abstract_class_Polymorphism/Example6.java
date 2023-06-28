public class Example6 {
    public static void main(String[] args) {
        Four four = new Four();
        four.printOne();
        four.printTwo();
        four.printThree();
    }
}

interface OneI {
    public void printOne();
}

interface TwoI {
    public void printTwo();
}

interface ThreeI extends OneI, TwoI {
    public void printThree();
}

class Four implements ThreeI {

    @Override
    public void printOne() {
        System.out.println("One");
    }

    @Override
    public void printTwo() {
        System.out.println("Two");
    }

    @Override
    public void printThree() {
        System.out.println("Three");
    }
}