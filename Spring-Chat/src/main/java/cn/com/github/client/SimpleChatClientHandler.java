package cn.com.github.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName SimpleChatServerHandler
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 10:54
 **/

@Slf4j
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {


    //获取数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        log.info("SimpleChatServerHandler 读取到的数据：{}", s);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            Channel channel = ctx.channel();
            log.info("输入数据:{}",reader.readLine());
            channel.writeAndFlush(reader.readLine());
        }
    }
}
