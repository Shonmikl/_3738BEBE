package _12_12_2022;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("Alexander");
        queue.add("Svitlana");
        queue.add("Konstantin");
        queue.add("Jelena");
        queue.add("Alexey");
        queue.add("Raul");
        queue.add("Giorgi");


        // System.out.println(queue);

        queue.offer("9999");
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue);
        System.out.println(queue.peek());
    }
}