package _11_01_2023.fileInputStream;

import java.io.*;

//binary files
public class FileInputStreamAndOutputStream {
    public static void main(String[] args) {
//        try (BufferedReader reader
//                     = new BufferedReader(new FileReader("img.png"));
//             BufferedWriter writer = new BufferedWriter(new FileWriter("newImg.png"))) {
//            int character;
//            while ((character = reader.read()) != -1) {
//                writer.write(character);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileInputStream inputStream = new FileInputStream("img.png");
             FileOutputStream outputStream = new FileOutputStream("imgOutput.png")) {
            int i;

            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }

            System.out.println("DONE!!!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException("B");
        } catch (IOException e) {
            throw new RuntimeException("A");
        }
    }
}