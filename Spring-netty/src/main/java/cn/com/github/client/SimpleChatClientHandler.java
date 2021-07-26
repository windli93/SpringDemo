package cn.com.github.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

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
        System.out.println(s);
    }

}
