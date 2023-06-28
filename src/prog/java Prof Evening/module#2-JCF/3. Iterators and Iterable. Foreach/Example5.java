/*
Интерфейс Iterable
Note -> тут мог бы быть пример с реализацией кастомного итератора, на примере MyLinkedList, но это следующая тема.
Там можно будет реализовать и вспомнить


for-each
Причина почему медленнее, но это не всегда истина!!!
- обычные массивы с циклом for-each, на этапе компиляции будут преобразованы в обычный цикл for с целочисленной
счетчиком-переменной.
- если вы используете for-each с коллекциями, то на этапе компиляции цикл будет преобразован в for с итератором.

Note -> смотрим на время, как много его осталось - можно продемонстрировать в коде, можно скомпилировать код, можно
написать сравнение.

 */

public class Example5 {

    public static void main(String[] args) {
        int[] arr = {1,13,9,11,10};

        int max = getMax(arr);
        System.out.println("The max is " + max);

    }

    public static int getMax(int[] arr) {
        int max = arr[0];

        // for-each loop

        for (int num: arr) {
            if (num > max)
                max = num;
        }

        return max;
    }



}
