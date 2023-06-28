package _28_06_2023;

import java.util.function.Function;

public class Main {
    public static int fun1() {return 10;}
    public static int fun2() {return 20;}
    public static int fun3() {return 5;}

    public static void main(String[] args) {
        //2x + 3y + 5z with args 10 | 20 | 5
        //2*10 + 3*20 + 5*5 = 20 + 60 + 25 = 105
        Function<Integer, Function<Integer, Function<Integer, Integer>>>
                c = x -> y -> z -> 2 * x + 3 * y + 5 * z;

        System.out.println("Evaluating 2x + 3y + 5z with " +
                "x = 10, y = 20 and z = 5 : " +
                c.apply(fun1()).apply(fun2()).apply(fun3()));
    }
}