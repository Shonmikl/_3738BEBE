package _12_12_2022;

import _23_11_2022.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Employee> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Employee::getId));
//        priorityQueue.add(12);
//        priorityQueue.add(1);
//        priorityQueue.add(5);
//        priorityQueue.add(23);
//        priorityQueue.add(86);
//        System.out.println(priorityQueue);

        Employee em1
                = new Employee(12, "Konstantin", "JAVA DEV", 850);
        Employee em2
                = new Employee(21, "Oxana", "JAVA DEV", 1500);
        Employee em3
                = new Employee(13, "Elina", "JAVA DEV", 900);
        Employee em4
                = new Employee(4, "Svitlana", "JAVA DEV", 2500);

        priorityQueue.add(em1);
        priorityQueue.add(em2);
        priorityQueue.add(em3);
        priorityQueue.add(em4);

      //  System.out.println(priorityQueue);
        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());
    }
}