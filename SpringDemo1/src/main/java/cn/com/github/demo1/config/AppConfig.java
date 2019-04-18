package cn.com.github.demo1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @ClassName Config
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 10:46
 **/
@PropertySources({
        @PropertySource("classpath:log4j.properties"),
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:user.properties")})
@ComponentScan(basePackages = "cn.com.github")
@Configuration
public class AppConfig {

}
