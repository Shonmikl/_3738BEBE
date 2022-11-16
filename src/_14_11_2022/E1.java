package _14_11_2022;

import java.util.Arrays;

public class E1 {
    private static final int MONDAY = 255;
    private static final String MON = "MONDAY";

    static void method(String day) {
        System.out.println("This day is: " + day);
    }

    static void method1(int day) {
        System.out.println("This day is: " + day);
    }

    public static void main(String[] args) {
//        method1(MONDAY);
//        method(MON);
//        method("LLLL");

        Week w1 = Week.MONDAY;
        Week w2 = Week.TUESDAY;
        Week w3 = Week.WEDNESDAY;
        Week w4 = Week.THURSDAY;
        Week w5 = Week.FRIDAY;
        Week w6 = Week.SATURDAY;
        Week w7 = Week.SUNDAY;

//        Today today = new Today(w3);
//        today.getDay();

//        Week w111 = Week.valueOf("MONDAY");//переводит стрингу в энам
//        System.out.println(w111);
        Week[] weeksArray = Week.values();
        System.out.println(Arrays.toString(weeksArray));
    }
}