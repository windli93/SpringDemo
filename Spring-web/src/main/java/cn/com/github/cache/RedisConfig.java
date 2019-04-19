package cn.com.github.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @ClassName RedisConfig
 * @AUTHOR ragrokli
 * @DATE 2019/4/19 14:03
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(o.getClass().getName());
                buffer.append(method.getName());
                for (Object object : objects) {
                    buffer.append(object.toString());
                }
                return buffer.toString();
            }
        };
    }
}
