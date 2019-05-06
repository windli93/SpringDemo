package cn.com.github.test;

import cn.com.github.client.SimpleChatClient;
import org.junit.Test;

/**
 * @ClassName TestClient
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 11:48
 **/
public class TestClient {

    @Test
    public void test1(){
        SimpleChatClient chatClient = new SimpleChatClient("127.0.0.1",8080);
        chatClient.run();
    }
}
