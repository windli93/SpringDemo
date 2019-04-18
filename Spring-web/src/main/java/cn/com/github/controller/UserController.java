package cn.com.github.controller;

import cn.com.github.domain.entity.User;
import cn.com.github.service.inter.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public String info() {
        log.info("用户总数是{}", userService.list());
        return "Hello Spring111 Boot, user list is " + userService.list() + "大小事" + userService.list().size();
    }

    @RequestMapping("findByName")
    public String name() {
        User user = userService.findByName("bb2");
        log.info("用户详细数据是：{}", JSONObject.toJSONString(user));
        return "Hello Spring111 Boot, user list is ragrok is man " + JSONObject.toJSONString(user);
    }
}
