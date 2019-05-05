package cn.com.github.manager.test1;

import cn.com.github.service.manager.DisCardClient;
import cn.com.github.service.manager.DisCardServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DisCardTest {

    @Test
    public void test1() throws Exception {
        int port = 8083;
        new DisCardServer(port).run();
    }

    @Test
    public void test2() throws Exception {
        int port = 8083;
        String address = "127.0.0.1";
        new DisCardClient(port, address).run();
    }
}
