import java.util.function.Supplier;

/*

Supplier применение
Note -> перейти в интерфейс, посмотреть на метод, обсудить, задать вопросы

Одно из основных применений этого интерфейса это использование для включения отложенного выполнения.
Это означает отсрочку выполнения до тех пор, пока оно не понадобится.
Например, в классе Optional есть метод orElseGet. Этот метод срабатывает, если у option нет данных.
 */

public class Example4 {
    public static void main(String[] args) {
        String str = "String";

        Supplier<String> supplierStr = () -> str.toUpperCase();
        System.out.println(supplierStr.get());
    }
}
