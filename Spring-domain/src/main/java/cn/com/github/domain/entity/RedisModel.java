package cn.com.github.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RedisModel implements Serializable {

    private String redisKey;//redis中的key
    private String name;//姓名
    private String tel;//电话
    private String address;//住址
}
