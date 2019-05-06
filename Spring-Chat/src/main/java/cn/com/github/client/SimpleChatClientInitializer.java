package cn.com.github.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * @ClassName SimpleChatServerInitializer
 * @AUTHOR ragrokli
 * @DATE 2019/5/6 10:54
 **/
public class SimpleChatClientInitializer extends ChannelInitializer<ServerSocketChannel>{
    @Override
    protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
        ChannelPipeline pipeline = serverSocketChannel.pipeline();
        pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder",new StringDecoder());
        pipeline.addLast("encoder",new StringEncoder());
        pipeline.addLast("handler",new SimpleChatClientHandler());
    }
}
