package cn.com.github.service.impl;

import cn.com.github.service.inter.HelloService;

/**
 * @ClassName HelloServiceImpl
 * @AUTHOR ragrokli
 * @DATE 2019/5/5 12:02
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "名字：hello " + name;
    }
}
