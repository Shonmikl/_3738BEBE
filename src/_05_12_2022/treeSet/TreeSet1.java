package _05_12_2022.treeSet;

import _05_12_2022.treeSet.student.Stud;

import java.util.TreeSet;

public class TreeSet1 {
    public static void main(String[] args) {
        TreeSet<Stud> treeSet = new TreeSet<>();
        TreeSet<Stud> nullSet = new TreeSet<>();

        Stud st1 = new Stud("Natalia", 22);
        Stud st2 = new Stud("Raul", 23);
        Stud st3 = new Stud("Sergey", 25);
        Stud st4 = new Stud("Olga", 26);
        Stud st5 = new Stud("Ivan", 28);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet.subSet(st2, st4));
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//        System.out.println(nullSet.pollFirst());

//        System.out.println(treeSet.pollLast());
//        System.out.println(treeSet.pollLast());

//        System.out.println(treeSet);
//        System.out.println(treeSet.first());
//        System.out.println(treeSet.last());
//        System.out.println(nullSet.first());
//        System.out.println(nullSet.pollFirst());
//        treeSet.contains(new Stud("Natalia", 22));

        treeSet.stream().filter(el -> el.getAge() == 25).forEach(System.out::println);
    }
}