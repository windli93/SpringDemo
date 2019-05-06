package cn.com.github.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SimpleChatServerHandler
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 10:54
 **/

@Slf4j
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //获取数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        log.info("SimpleChatServerHandler 读取到的数据：{}", s);
        Channel inComing = channelHandlerContext.channel();
        for (Channel channel : channels) {
            if (channel != inComing) {
                log.info("新增channel：{}", channel.remoteAddress().toString());
                channel.writeAndFlush("[" + inComing.remoteAddress() + "]" + s + "\n");
            } else {
                channel.writeAndFlush("[you: ]" + s + "\n");
            }
        }
    }
    //新增
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        channels.writeAndFlush("[Server:]-" + inComing.remoteAddress() + "加入");
    }

    //删除
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        channels.writeAndFlush("[Server:]-" + inComing.remoteAddress() + "离开");
    }

    //在线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        channels.writeAndFlush("[Server:]-" + inComing.remoteAddress() + "在线");
    }

    //掉线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        channels.writeAndFlush("[Server:]-" + inComing.remoteAddress() + "掉线");
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel inComing = ctx.channel();
        channels.writeAndFlush("[Server:]-" + inComing.remoteAddress() + "异常");
        ctx.close();
    }
}
