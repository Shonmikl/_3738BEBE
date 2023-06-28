import java.util.Date;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("Пример с переносами строк:");
        System.out.printf("one%ntwo%nthree");

        System.out.println();
        System.out.println();

        System.out.println("Пример с логическими типами:");
        System.out.printf("%b%n", null);
        System.out.printf("%B%n", false);
        System.out.printf("%B%n", 2);
        System.out.printf("%b%n", "text");

        System.out.println();

        System.out.println("Пример с текстовыми данными:");
        System.out.printf("%50.4s", "Hi guys!");

        System.out.println();

        System.out.println("Пример с символами:");
        System.out.printf("%c%n", 'a');
        System.out.printf("%C%n", 'a');

        System.out.println();

        System.out.println("Примеры с числами:");
        int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

        float y = 3.14f;
        System.out.printf("Formatted to specific width: n = %.6f\n", y);

        y = 1234567.3f;
        System.out.printf("Formatted to right margin: n = %50.4f\n", y);

        System.out.println();

        System.out.println("примеры с датой:");
        Date date = new Date();
        System.out.println(date);

        // Символы H, M, S отвечают за часы, минуты и секунды
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);
        System.out.printf("%1$tA, %1$tB %1$tY %n", date);
    }
}
