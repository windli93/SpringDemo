package cn.com.github.demo1.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName AppInfo
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 11:09
 **/
@Component
@Getter
@Setter
@ToString
public class AppInfo {

    @Value("${user1.name}")
    private String name;

    @Value("${user1.age}")
    private Long age;

}
