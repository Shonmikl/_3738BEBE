/*
Объекты класса для массивов
У каждого массива есть связанный с ним объект Class, общий для всех других массивов с тем же типом компонента.
 */

public class Example3 {
    public static void main(String[] args) {
        int[] intArray = new int[3];
        byte[] byteArray = new byte[3];
        short[] shortsArray = new short[3];
        String[] strArray = new String[3];

        System.out.println(intArray.getClass());                // class [I
        System.out.println(intArray.getClass().getSuperclass());// class java.lang.Object
        System.out.println(byteArray.getClass());               // class [B
        System.out.println(shortsArray.getClass());             // class [S
        System.out.println(strArray.getClass());                // class [Ljava.lang.String;
    }
}
