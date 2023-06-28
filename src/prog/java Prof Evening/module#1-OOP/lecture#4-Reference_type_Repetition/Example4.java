import java.util.ArrayList;
import java.util.List;

/*
найти сумму нечетных чисел в списке
Важно!!!
операторы остатка (%) и унарного плюса (+=) не применяются к объектам Integer.
Integer в примитивное значение int происходит путем вызова метода intValue().
 */

public class Example4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int sum = sumOfOddNumber(list);
        System.out.println("Sum of odd numbers = " + sum);

    }

    public static int sumOfOddNumber(List<Integer> list) {
        int sum = 0;

        for (Integer i : list) {
            if (i % 2 != 0) { // Unboxing of i automatically
                sum += 1;
            }

            if (i.intValue() % 2 != 0) { // Unboxing of i is done automatically using intValue()
                sum += i.intValue();
            }
        }

        return sum;
    }
}
