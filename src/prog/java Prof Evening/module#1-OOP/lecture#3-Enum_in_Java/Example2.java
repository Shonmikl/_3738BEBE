/*
Мы можем объявить метод main() внутри перечисления. Следовательно, мы можем вызывать enum непосредственно из командной
строки.
 */

public enum Example2 {
    RED, GREEN, BLUE;

    public static void main(String[] args) {
        Example2 color = Example2.RED;
        System.out.println(color);
    }
}
