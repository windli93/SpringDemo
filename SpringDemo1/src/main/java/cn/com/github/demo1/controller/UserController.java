package cn.com.github.demo1.controller;

import cn.com.github.demo1.bean.AppInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppInfo info;

    @RequestMapping("/info")
    public String info() {
        log.info("我的名字是：{} , 年龄是333： {}", info.getName(), info.getAge());
        return "Hello Spring111 Boot, name is " + info.getName() + ", age is " + info.getAge();
    }

    @RequestMapping("/name")
    public String name() {
        log.info("这不是我的名字是：{} , 年龄是333： {}", info.getName(), info.getAge());
        return "Hello 这不是我的名字是 Boot, name is " + info.getName() + ", age is " + info.getAge();
    }
}
