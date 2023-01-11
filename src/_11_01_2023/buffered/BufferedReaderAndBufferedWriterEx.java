package _11_01_2023.buffered;

import java.io.*;

public class BufferedReaderAndBufferedWriterEx {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("british.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("britishBuff.txt"))) {
//            int character;
//            while ((character = reader.read()) != -1) {
//                writer.write(character);
//            } первый способ
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
