package _2023_06_12.gc;

import java.lang.ref.Cleaner;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * В этом примере мы используем класс ByteBuffer для выделения прямой
 * памяти. Затем мы получаем приватное поле cleaner с использованием рефлексии,
 * которое является экземпляром sun.misc.Cleaner. Мы регистрируем объект
 * finalizerObject для очистки памяти, вызывая метод register() у объекта cleaner.
 * После этого мы делаем буфер равным null и вызываем сборщик мусора (System.gc()).
 *
 * В методе finalize() класса finalizerObject мы выводим сообщение
 * о вызове этого метода, чтобы показать, что память освобождается.
 *
 * Обратите внимание, что использование прямой памяти и sun.misc.
 * Cleaner являются внутренними классами и могут изменяться в
 * разных версиях JVM. Рекомендуется использовать эти функции с
 * осторожностью и учитывать, что они могут быть недоступны или
 * иметь другое поведение в некоторых средах выполнения или версиях JVM.
 */
public class DirectMemoryExample {
    public static void main(String[] args) throws Exception {
        int bufferSize = 1024; // Размер буфера в байтах

        // Выделение памяти под прямую память
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);

        // Получение Cleaner-а для управления памятью
        Cleaner cleaner = Cleaner.create();

        // Создание объекта, который будет вызывать Cleaner при освобождении памяти
        Object finalizerObject = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Вызван метод finalize()");
                super.finalize();
            }
        };

        // Получение приватного поля Cleaner-а с использованием рефлексии
        Field cleanerField = buffer.getClass().getDeclaredField("cleaner");
        cleanerField.setAccessible(true);
        Object cleanerInstance = cleanerField.get(buffer);

        // Регистрация finalizerObject для очистки памяти
        cleaner.register(finalizerObject, (Runnable) cleanerInstance);

        // Очистка прямой памяти
        buffer = null;
        System.gc(); // Вызов сборщика мусора

        // Пауза для наблюдения результатов
        Thread.sleep(1000);
    }
}