package _16_01_2023;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Searcher {

    private static void getFiles(File file, List<File> fileList) {

    }

    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList<File>();
        getFiles(new File("E:\\"), list);

        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
    }
}