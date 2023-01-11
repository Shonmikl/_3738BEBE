package _11_01_2023.fileReader;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) {
        String s = "In a wide-ranging interview with Stephen Colbert " +
                "on The Late Show - the first conducted after details " +
                "from the book were published - Harry suggested there had " +
                "been attempts to undermine his book, spoke of his fractured " +
                "relationship with his brother, and attacked the \"bigoted\" " +
                "British press.";
        String path = "E:\\_3738BEBE\\britishEmpty.txt";

        String q = "***** ";

        FileWriter writer = null;
        try {
//            writer = new FileWriter(path, true); //true - добавляет текст к текущему
            writer = new FileWriter(path);
//            for (int i = 0; i < s.length(); i++) {
//                writer.write(s.charAt(i));
//
//            }
//            writer.write(q);
            System.out.println("DONE!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
