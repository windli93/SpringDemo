package cn.com.github.service.annotation;

import java.lang.annotation.*;

/**
 * @ClassName FruitName
 * @AUTHOR ragrokli
 * @DATE 2019/4/19 14:41
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";
}
