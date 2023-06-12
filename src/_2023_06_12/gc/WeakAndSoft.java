package _2023_06_12.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakAndSoft {
    public static void main(String[] args) {
        Object myObject = new Object();

        WeakReference<Object> weakRef = new WeakReference<>(myObject);
        SoftReference<Object> softRef = new SoftReference<>(myObject);

        myObject = null;

        Object weakObj = weakRef.get();
        System.out.println("WeakReference<Object> : " + weakObj);

        Object softObj = softRef.get();
        System.out.println("SoftReference<Object> : " + softObj);

        System.gc();

        weakObj = weakRef.get();
        System.out.println("WeakReference after GC: " + weakObj);

        softObj = softRef.get();
        System.out.println("SoftReference after GC: " + softObj);
    }
}
