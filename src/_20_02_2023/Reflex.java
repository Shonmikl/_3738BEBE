package _20_02_2023;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflex {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class pClass = Class.forName("_20_02_2023.P");
        //Class pClass2 = P.class;
        Field field = pClass.getField("id");
        System.out.println("Field type is: " + field.getType());
        System.out.println("---------------------------------------");

//        Field[] fields = pClass.getFields();
//        for(Field f : fields) {
//            System.out.println("Filed [" + f + "]" + " has type --> " + f.getType() );
//        }
//        System.out.println("---------------------------------------");

//        Field[] fields = pClass.getDeclaredFields();
//        for(Field f : fields) {
//            System.out.println("Filed [" + f + "]" + " has type --> " + f.getType() );
//        }

//        Method method = pClass.getMethod("increaseSalary");
//        System.out.println("Return type: " + method.getReturnType());
//        System.out.println("Parameter type: " + Arrays.toString(method.getParameterTypes()));

//        Method method = pClass.getMethod("setSalary", double.class);
//        Method[] methods = pClass.getDeclaredMethods();
//        for(Method m : methods) {
//            if(Modifier.isPublic(m.getModifiers())) {
//
//            }
//        }

        Constructor[] constructor = pClass.getConstructors();
        for (Constructor c : constructor) {
            System.out.println("Constructor name: " + c.getName());
            System.out.println("Constructor has: " + c.getParameterCount());
            System.out.println("Constructor type: " + Arrays.toString(c.getParameterTypes()));
        }
    }
}