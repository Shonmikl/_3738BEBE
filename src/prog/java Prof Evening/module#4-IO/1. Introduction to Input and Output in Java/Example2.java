/*
Scanner

System.in : это стандартный поток ввода, который используется для чтения символов с клавиатуры или любого другого
стандартного устройства ввода.
 */

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.next());//scanner.nextInt();
        double k = Double.parseDouble(scanner.next());//scanner.nextInt();

        System.out.println(n + k);
    }
}
