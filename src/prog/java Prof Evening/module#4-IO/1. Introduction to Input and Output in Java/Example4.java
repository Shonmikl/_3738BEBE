/*
System.err: стандартный поток ошибок
 */

import java.io.IOException;
import java.io.InputStreamReader;

public class Example4 {
    public static void main(String[] args) {

//        System.out.println("simple message");
//        System.out.println("error message");

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        System.out.println("Enter characters, and '0' to quit.");

        char c;

        try {

            do {
                c = (char) inputStreamReader.read();
                System.out.print(c);
            } while (c != '0');

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
