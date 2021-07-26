package cn.com.github.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @AUTHOR windli
 * @DATE 2021/7/23 16:28
 * @DESC
 **/
@Slf4j
public class DemoServerSockerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client address==============" + ctx.channel().remoteAddress());
        ctx.channel().writeAndFlush("from server" + UUID.randomUUID());
        ctx.fireChannelActive();
        System.out.println(msg);
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
