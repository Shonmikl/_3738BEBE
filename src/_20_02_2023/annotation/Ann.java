package _20_02_2023.annotation;

import lombok.ToString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ToString
@Inter
public class Ann {

    @Inter
    private String name;

    public String getName() {
        return name;
    }
}


@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Inter {

}