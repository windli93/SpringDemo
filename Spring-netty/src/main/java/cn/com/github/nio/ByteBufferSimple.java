package cn.com.github.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class ByteBufferSimple {

    @Test
    public void byteBuffTest1() throws Exception {
        String path = this.getClass().getClassLoader().getResource("data.txt").getPath();
        FileChannel channel = new FileInputStream(path).getChannel();
        //准备缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (true) {
            int length = channel.read(buffer);
            log.info("length:{}", length);
            if (length == -1) {
                return;
            }
            //切换写模式
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                log.info("data:{}", (char) b);
            }
            //切换读模式
            buffer.clear();
        }
    }
}
