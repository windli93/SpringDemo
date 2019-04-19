package cn.com.github.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @ClassName Config
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 10:46
 **/
@ComponentScan(basePackages = {"cn.com.github"})
@PropertySources({
        @PropertySource("classpath:log4j.properties"),
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:redis.properties"),
        @PropertySource("classpath:mysql.properties")})
@Configuration
public class AppConfig {

}
