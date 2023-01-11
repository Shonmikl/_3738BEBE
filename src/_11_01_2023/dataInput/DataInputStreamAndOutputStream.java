package _11_01_2023.dataInput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//примитивы
public class DataInputStreamAndOutputStream {
    public static void main(String[] args) {
        Path path = Paths.get("data.bin");
        try (DataOutputStream outputStream =
                     new DataOutputStream(Files.newOutputStream(path));
             DataInputStream inputStream =
                     new DataInputStream(Files.newInputStream(path))) {

            outputStream.writeBoolean(true);
            outputStream.writeByte(1);
            outputStream.writeLong(2);
            outputStream.writeInt(3);
            outputStream.writeFloat(4.4f);

//            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
