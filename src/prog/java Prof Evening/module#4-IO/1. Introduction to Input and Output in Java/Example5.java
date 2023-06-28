/*
1.Create a File
2.Check if File or Directory Exists
3.Create a Directory if it Does Not Exist
4.File Length
5.Rename or Move File or Directory
6.Delete File or Directory
7.Check if Path is File or Directory
8.Read List of Files in Directory
 */

import java.io.File;

public class Example5 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        boolean isExist = file.exists();

        System.out.println("Файл сущействует?: " + isExist);

        file = new File("new_dir");

        boolean wasCreated = file.mkdir();
        System.out.println("Directory was created: " + wasCreated);

        long length = file.length();
        System.out.println(length);

        boolean success = file.delete();
        System.out.println(success);

        File direcory = new File("data");
        boolean isDirecory = file.isDirectory();
        System.out.println(isDirecory);

        direcory = new File("data");
        String[] fileNames = file.list();
        File[] files = file.listFiles();
    }
}
