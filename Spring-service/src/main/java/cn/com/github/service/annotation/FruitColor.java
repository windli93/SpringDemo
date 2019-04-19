package cn.com.github.service.annotation;

import java.lang.annotation.*;

/**
 * @ClassName FruitColor
 * @AUTHOR ragrokli
 * @DATE 2019/4/19 14:36
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color {BULE, RED, GREEN};

    Color fruitColor() default Color.GREEN;
}
