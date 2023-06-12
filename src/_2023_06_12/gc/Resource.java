package _2023_06_12.gc;

/**
 * Важно отметить, что использование финализаторов
 * не рекомендуется в современном коде Java,
 * поскольку они имеют некоторые ограничения и могут
 * вызывать проблемы с производительностью и непредсказуемым
 * поведением. Вместо финализаторов рекомендуется использовать
 * методы try-with-resources, finally блоки или обработчики
 * исключений для правильного освобождения ресурсов.
 *
 * В этом примере класс Resource реализует интерфейс AutoCloseable,
 * что позволяет использовать его в конструкции try-with-resources.
 * Класс также переопределяет метод finalize(), который будет вызван
 * перед уничтожением объекта сборщиком мусора.
 *
 * В методе finalize(), который не рекомендуется использовать,
 * выполняется завершающая операция, такая как освобождение ресурсов
 * или закрытие соединений. Обратите внимание, что метод finalize()
 * вызывает метод super.finalize() для обеспечения корректной работы
 * сборщика мусора.
 *
 * В методе close(), который используется в конструкции try-with-resources,
 * также выполняется закрытие ресурса и освобождение соответствующих ресурсов.
 *
 * В методе main() показано использование класса Resource в конструкции
 * try-with-resources, что гарантирует автоматическое закрытие
 * ресурса после использования.
 */
public class Resource implements AutoCloseable {
    private final int resourceId;

    public Resource(int resourceId) {
        this.resourceId = resourceId;
    }

    public void useResource() {
        System.out.println("Using resource: " + resourceId);
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing resource: " + resourceId);
            // Освобождение ресурсов, закрытие соединений и т. д.
        } finally {
            super.finalize();
        }
    }

    @Override
    public void close() throws Exception {
        // Закрытие ресурса в явном виде (не используется финализатор)
        System.out.println("Closing resource: " + resourceId);
        // Освобождение ресурсов, закрытие соединений и т. д.
    }

    public static void main(String[] args) {
        try (Resource resource = new Resource(1)) {
            resource.useResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}