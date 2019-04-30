package cn.com.github.service.impl;

import cn.com.github.domain.entity.RedisModel;
import cn.com.github.service.inter.IRedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {

    private  final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
