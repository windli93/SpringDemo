package cn.com.github.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SimpleChatServer
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 10:53
 **/
@Slf4j
public class SimpleChatClient {

    private String host;
    private int port;

    public SimpleChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.option(ChannelOption.SO_BACKLOG,128);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.handler(new SimpleChatClientInitializer());
           //连接本地地址
           ChannelFuture future = bootstrap.connect(host,port).sync();
           future.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            group.shutdownGracefully();
        }
    }
}
