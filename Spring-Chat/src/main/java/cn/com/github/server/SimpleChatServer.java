package cn.com.github.server;

import io.netty.bootstrap.ServerBootstrap;
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
public class SimpleChatServer {

    private int port;

    public SimpleChatServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup,workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG,128);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
            bootstrap.handler(new SimpleChatServerInitializer());
            log.info("服务器启动了。。。。。。。。。。。。。");
            //监听端口,获取接收到的连接
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            log.info("服务器关闭了。。。。。");
        }
    }
}
