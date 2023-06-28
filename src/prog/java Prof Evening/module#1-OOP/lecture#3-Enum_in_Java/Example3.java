/*
values(), ordinal() и valueOf()
 */

enum  Color3{
    RED, GREEN, BLUE;
}

public class Example3 {
    public static void main(String[] args) {

        Color3[] arr = Color3.values();

        for (Color3 col : arr) {
            System.out.println(col + " at index " + col.ordinal());
        }

        System.out.println(Color3.valueOf("RED"));
    }
}
