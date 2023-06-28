/*
копирование массивов
 */

public class Example4 {

    public static void main(String[] args) {
//        one();
        two();
    }

    // 1d array example
    public static void one() {
        int intArray[] = { 1, 2, 3 };

        int cloneArray[] = intArray.clone();

        System.out.println(intArray == cloneArray); // different links

        for (int i = 0; i < cloneArray.length; i++) {
            System.out.print(cloneArray[i] + " ");
        }
    }

    // 2d array example
    public static void two() {
        int intArray[][] = { { 10, 20, 30 }, { 40, 50 } };

        int cloneArray[][] = intArray.clone();

        System.out.println(intArray == cloneArray);      // false
        System.out.println(intArray[0] == cloneArray[0]);// true
        System.out.println(intArray[1] == cloneArray[1]);// true
    }
}
