package cn.com.github.service.util;

import cn.com.github.service.annotation.FruitColor;
import cn.com.github.service.annotation.FruitName;
import cn.com.github.service.annotation.FruitProvider;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @ClassName FruitInfoUtil
 * @AUTHOR ragrokli
 * @DATE 2019/4/19 15:11
 **/
@Slf4j
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = "水果名称";
        String strFruitColor = "水果颜色";
        String strFruitProvider = "供应商信息";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                log.info(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                log.info(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider + "供应商编号  ：" + fruitProvider.id() + "供应商名字 :" + fruitProvider.name() + "供应商地址  :" + fruitProvider.address();
                log.info(strFruitProvider);
            }
        }
    }

}
