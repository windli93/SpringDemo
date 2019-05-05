package cn.com.github.manager.test1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class EchoServer {

    private final int PORT = 8100;

    public static void main(String[] args) {
        new EchoServer().start();
    }

    public void start() {
        // 创建事件处理器
        EventLoopGroup group = new NioEventLoopGroup();
        // 创建启动器
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 配置启动器
        bootstrap.group(group)
                // 配置建立连接的处理器
                .channel(NioServerSocketChannel.class)
                // 配置连接建立后的处理器
                // 当一个新连接建立后，就会新建一个childHandler
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        // 将逻辑处理器添加到channel对应的pipeline中
                        ch.pipeline().addLast((ChannelHandler) new EchoServerHandler());
                    }
                });
        try {
            // 绑定地址并且建立连接，sync()表示等到连接绑定完成
            ChannelFuture future = bootstrap.bind(PORT).sync();
            // 阻塞直至连接关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭连接，释放资源
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 逻辑处理器
     * 这里是直接将收到的数据发送回去
     */
    class EchoServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf data = (ByteBuf) msg;
            System.out.println("数据回应：request: " + data.toString(CharsetUtil.UTF_8));
            // 将收到的数据发送回去给客户端
            ctx.writeAndFlush(data);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            // 关闭连接
            ctx.close();
        }
    }
}
