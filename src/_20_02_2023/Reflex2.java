package _20_02_2023;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflex2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class pClass = Class.forName("_20_02_2023.P");
        Constructor<P> constructor = pClass.getConstructor();
        P obj = constructor.newInstance();

        Constructor constructor1 = pClass.getConstructor(int.class, String.class, String.class);
        Object o = constructor1.newInstance(11, "Mikhail", "IT");
        System.out.println(o);

        Method method = pClass.getMethod("setSalary", double.class);

        method.invoke(o, 1111.11);
    }
}
