package cn.com.github.test;

import org.junit.Test;

/**
 * @ClassName TestServer
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 11:47
 **/
public class TestServer {

    @Test
    public void test1() throws Exception {
        SimpleChatServer simpleChatServer = new SimpleChatServer(8080);
        simpleChatServer.run();
    }
}
