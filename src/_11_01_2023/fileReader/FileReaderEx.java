package _11_01_2023.fileReader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
//
//        try {
//             FileReader fileReader fileReader= new FileReader("prog.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            fileReader.close();
//        } old version

        try (FileReader fileReader = new FileReader("prog.txt")) {
            int characters;

            while ((characters = fileReader.read()) != -1) {
                System.out.print((char) characters);
            }

            System.out.println("\nDONE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}