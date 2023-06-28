/*
FileInputStream & FileOutputStream examples
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args) {
        inputExample();
        outputExample();
    }

    public static void inputExample() {
        // пример чтения
        try {
            String path = "test_stream.txt";
            FileInputStream input = new FileInputStream(path);

            int data = input.read();

            while (data != -1) {
                System.out.print((char) data + " ");
                data = input.read();
            }

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputExample() {
        try {
            String path = "test_stream.txt";
            FileOutputStream out = new FileOutputStream(path, true);
            out.write("\nhello from java outputstream".getBytes());
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
