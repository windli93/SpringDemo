package cn.com.github.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName cn.com.github.main.Main
 * @AUTHOR ragrokli
 * @DATE 2019/4/18 10:27
 **/
@ComponentScan(basePackages = "cn.com.github")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
