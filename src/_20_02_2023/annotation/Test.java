package _20_02_2023.annotation;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.lang.annotation.*;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = Class.forName("_20_02_2023.annotation.ANDROID");
        Annotation annotation =  aClass.getAnnotation(SmartPhone.class);
        SmartPhone smartPhone = (SmartPhone) annotation;
        System.out.println("Annotation OS: " + smartPhone.OS());
        System.out.println("Annotation year: " + smartPhone.year());


        Class ipClass = Class.forName("_20_02_2023.annotation.IPHONE");
        SmartPhone annotation1 = (SmartPhone) ipClass.getAnnotation(SmartPhone.class);
        //SmartPhone smartPhone2 = (SmartPhone) annotation;
        System.out.println("Annotation OS: " + annotation1.OS());
        System.out.println("Annotation year: " + annotation1.year());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String OS() default "";
    int year() default 2020;
}

@ToString
@SmartPhone(OS = "IOS", year = 2021)
class IPHONE {
    String model;
    double price;
}

@SmartPhone(OS = "ANDROID", year = 2023)
class ANDROID {
    String model;
    double price;
}