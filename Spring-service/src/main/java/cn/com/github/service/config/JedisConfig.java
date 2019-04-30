package cn.com.github.service.config;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConfig {

    public static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(60 * 1000);
        config.setMaxIdle(50);
        config.setTestOnBorrow(true);
        config.setMinIdle(20);
        config.setMaxTotal(200);
        jedisPool = new JedisPool(config, "localhost");
    }

}
