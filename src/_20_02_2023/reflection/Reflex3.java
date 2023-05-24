package _20_02_2023.reflection;

import java.lang.reflect.Field;

public class Reflex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        P p = new P(1, "Oksana", "IT");
        Class pClass = p.getClass();
        Field field = pClass.getDeclaredField("salary");
        field.setAccessible(true);

        double salaryValue = (double) field.get(p);
        System.out.println(salaryValue);
    }
}