import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Example3 {
    public static void main(String[] args) throws IOException {

        FileInputStream stream = new FileInputStream("test.txt");
        System.out.println("Number of remaining bytes: " + stream.available());

        stream.skip(6);

        int ch;

        while ((ch = stream.read()) != -1)
            System.out.print((char) ch);

        /*
        Канал представляет открытое соединение с источником или адресатом ввода-вывода.

        Все каналы померживают дополнительные методы, предоставляющие доступ к каналу и позволяющие управлять им.
        Например, канал типа FileChannel поддерживает среди прочего методы для получения и установки текущей позиции,
        передачи данных между файловыми каналами, получения текущего размера канала и его блокировки.

        В классе FileChannel предоставляется статический метод open(), который открывает файл и возвращает для него
        канал. Такой результат достигается другим способом получения канала. В классе FileChannel предоставляется
        также метод map(), с помощью которого можно отобразить файл в буфер.

        getChannel() - Возвращает уникальный объект FileChannel, связанный с входным потоком этого файла.
         */
        System.out.println();
        System.out.println(stream.getChannel());

        // getFD() - Возвращает объект FileDescriptor файла из системы.
        System.out.println(stream.getFD());

        stream.close();
    }
}
