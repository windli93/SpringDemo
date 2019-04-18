package cn.com.github.demo1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Config
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 10:46
 **/
@PropertySource(value = {"classpath:log4j.properties", "classpath:application.properties"})
@Configuration
public class AppConfig {

}
