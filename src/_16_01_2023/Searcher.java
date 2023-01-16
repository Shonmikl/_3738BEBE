package _16_01_2023;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Searcher {

    private static void getFiles(File root, List<File> fileList) {
        if (root.isDirectory()) {
            //System.out.println("searching....." + root.getAbsolutePath());
            File[] direcoriFile = root.listFiles();
            if (direcoriFile != null) {
                for (File file : direcoriFile) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().startsWith("release"));
                        fileList.add(file);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList<>();
        getFiles(new File("D:\\"), list);

        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
    }
}