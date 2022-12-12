package _12_12_2022;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;

public class DequeEx {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(5);
        deque.add(15);
        deque.add(52);
        deque.add(4);
        deque.add(6);
        deque.add(89);
        System.out.println(deque);

        deque.addFirst(111);
        deque.offerFirst(1111);
        System.out.println(deque);

        //deque.pop();

        deque.addLast(999);
        deque.offerLast(9999);
        System.out.println(deque);
    }
}