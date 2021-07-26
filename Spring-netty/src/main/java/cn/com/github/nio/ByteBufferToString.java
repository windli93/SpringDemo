package cn.com.github.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;

@Slf4j
public class ByteBufferToString {


    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        buffer.flip();
        log.info("Value:{}", buffer.array());
    }

}
