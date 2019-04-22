package cn.com.github.test1.base;

import cn.com.github.Main;
import cn.com.github.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
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
@SpringBootTest(classes = {AppConfig.class})
public class BaseTest {

}
