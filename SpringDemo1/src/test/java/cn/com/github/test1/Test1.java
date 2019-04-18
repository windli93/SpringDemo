package cn.com.github.test1;

import cn.com.github.demo1.bean.AppInfo;
import cn.com.github.demo1.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test1
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 10:28
 **/
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class Test1 {


    @Test
    public void test1() {
        log.info("hello world{}", "我是word");
    }


    @Test
    public void test2() {
        AppInfo info = new AppInfo();
        log.info("info value1{}", info.getName());
        log.info("info value2{}", info.getAge());
    }
}
