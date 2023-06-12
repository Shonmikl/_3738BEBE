package _2023_06_07;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class CCLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {
        File file
                = new File(
                        "E:\\_3738BE\\target\\classes\\_2023_06_07\\ClassLoaderTestClass.class");
        byte[] bytecode = loadClassBytes(file);
        return defineClass(name, bytecode, 0, bytecode.length);
    }

    private byte[] loadClassBytes(File file) {
        try (InputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }


    public static void main(String[] args) {
        CCLoader ccLoader = new CCLoader();
        try {
            Class<?> clazz = ccLoader.loadClass("_2023_06_07.ClassLoaderTestClass");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            clazz.getMethod("get").invoke(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException
                 | InstantiationException
                 | IllegalAccessException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}