package cn.com.github.manager.test1;

import cn.com.github.service.annotation.FruitColor;
import cn.com.github.service.annotation.FruitName;
import cn.com.github.service.annotation.FruitProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Apple
 * @AUTHOR ragrokli
 * @DATE 2019/4/19 14:39
 **/
@Getter
@Setter
@Slf4j
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;


    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void displayName() {
        log.info("水果的名字是苹果");
    }
}
