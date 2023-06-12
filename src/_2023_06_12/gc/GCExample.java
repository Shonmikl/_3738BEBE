package _2023_06_12.gc;

import java.util.ArrayList;
import java.util.List;

public class GCExample {
    public static void main(String[] args) {
        int dataSize = 10_000_000;
        List<String> data = new ArrayList<>();

        for (int i = 0; i < dataSize; i++) {
            data.add("DATA: " + i);
        }

        long usedMemoryBeforeGC
                = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Занятый объем до вызова GC: " + usedMemoryBeforeGC);

        System.gc();

        long usedMemoryAfterGC
                = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Занятый объем после вызова GC: " + usedMemoryAfterGC);

        String gcName = System.getProperty("java.vm.name");
        System.out.println("Сборщик: " + gcName);
    }
}