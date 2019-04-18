package cn.com.github.test1;

import cn.com.github.demo1.dao.UserRepository;
import cn.com.github.demo1.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;

@Slf4j
public class UserRepositoryTests extends BaseTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        //userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
        //userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
        //userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

        log.info("size {}",userRepository.findAll().size());
        //Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
