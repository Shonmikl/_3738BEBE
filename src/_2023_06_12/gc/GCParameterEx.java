package _2023_06_12.gc;

import java.io.IOException;

public class GCParameterEx {
    public static void main(String[] args) {
        String gcParameters =
                "-XX:NewSize=256m -XX:MaxNewSize=256m -XX:SurvivorRatio=6";

        String javaCommand = "java " + gcParameters + " GCParameterEx";

        try {
            Process process = Runtime.getRuntime().exec(javaCommand);
            int exitCode = process.waitFor();

            if(exitCode == 0) {
                System.out.println("DONE");
            } else {
                System.out.println("Error " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}