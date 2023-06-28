import java.io.*;

public class Example4 {
    public static void main(String[] args) {
        two();
    }

    public static void one() {
        String data = "This is file output stream";

        try {
            FileOutputStream stream = new FileOutputStream("test.txt");
            byte[] array = data.getBytes();

            stream.write(array);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    method flush()
    Используется для сброса содержимого буфера в выходной поток.
    Буфер — это часть памяти, которая используется для хранения потока данных.
    Чтобы не ждать заполнения буфера для отправки используем метод flush().

    Часто данные для записи сначала собираются в большие блоки в памяти, а потом только пишутся на диск.
    Команда flush требует немедленно записать всю несохраненную информацию на диск.

    При вызове close() метод flush() вызывается автоматически
     */

    public static void two() {
        try {
            OutputStream outputStream = new FileOutputStream("test.txt");
            InputStream inputStream = new FileInputStream("test.txt");

            outputStream.write('A');
//            outputStream.flush();
            outputStream.write('B');


            System.out.println("" + (char)inputStream.read());
            System.out.println("" + (char)inputStream.read());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
