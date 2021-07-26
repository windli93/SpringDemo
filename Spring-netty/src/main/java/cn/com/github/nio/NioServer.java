package cn.com.github.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR windli
 * @DATE 2021/7/19 11:50
 * @DESC
 **/
@Slf4j
public class NioServer {

    @Test
    public void test1() throws IOException {
         //使用Nio来理解阻塞模式
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //创建服务器
        ServerSocketChannel  channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        //绑定监听器
        channel.bind(new InetSocketAddress(10006));
        //建立连接
        List<SocketChannel> channels = new ArrayList<>();
        while (true){
            //accept建立与客户端连接，SocketChannel用来与客户端通信
            SocketChannel channel1 = channel.accept();
            if (channel1 != null){
                log.debug("connected...{}",channel1);
                channel1.configureBlocking(false);
                channels.add(channel1);
            }
            for (SocketChannel channel2: channels){
                //接收客户端发送的数据
                int read = channel2.read(buffer);
                if (read > 0){
                    buffer.flip();
                    log.info("Buffer data:{}",buffer.array());
                    buffer.clear();
                    log.debug("after read...{}",channel);
                }
            }
        }
    }
}
