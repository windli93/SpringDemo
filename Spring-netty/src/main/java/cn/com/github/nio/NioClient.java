package cn.com.github.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @AUTHOR windli
 * @DATE 2021/7/19 13:55
 * @DESC
 **/
@Slf4j
public class NioClient {


    @Test
    public void test() throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",10006));
        log.info("waiting.......................");
    }
}
