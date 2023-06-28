/*
enum может содержать как конкретные методы, так и абстрактные методы.
Если класс перечисления имеет абстрактный метод, то каждый экземпляр класса перечисления должен его реализовать.
 */

enum Color4 {
    RED, GREEN, BLUE;

    private Color4() {
        System.out.println("Constructor called for: " + toString());
    }

    public void colorInfo() {
        System.out.println("Universal Color");
    }
}

public class Example4 {
    public static void main(String[] args) {
        Color4 color = Color4.RED;
        System.out.println(color);
        color.colorInfo();
    }
}
