package _12_12_2022;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Elina");
        stack.push("Natalia");
        stack.push("Ivan");
        stack.push("Oxana");
        stack.push("Anatoli");

        stack.add("777");
        //System.out.println(stack);

        System.out.println(stack.add("9999"));
        stack.add(2, "000000");
        System.out.println(stack);
        //System.out.println(stack.get(2));
        System.out.println(stack.pop());

//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);
//
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);

//        while (!stack.isEmpty()) {
//            System.out.println(stack);
//            System.out.println(stack.pop());
//        }

//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
    }
}