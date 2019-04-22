package cn.com.github.test1.test1;

import cn.com.github.domain.entity.User;
import cn.com.github.service.inter.UserService;
import cn.com.github.service.util.FruitInfoUtil;
import cn.com.github.test1.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;

@Slf4j
public class Test1 extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        String formattedDate = dateFormat.format(date);

//        userService.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
//        userService.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//        userService.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

        //Assert.assertEquals(9, userRepository.findAll().size());
        //Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        //userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void test1() {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
