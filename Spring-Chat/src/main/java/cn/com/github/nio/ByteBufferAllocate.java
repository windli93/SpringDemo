package cn.com.github.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;

@Slf4j
public class ByteBufferAllocate {


    @Test
    public void test1() {
        //堆内存分配方式
        Class buffer = ByteBuffer.allocate(10).getClass();
        //直接内存分配方式
        Class buffer1 = ByteBuffer.allocateDirect(10).getClass();

        log.info("Class path:{}",buffer.getName());
        log.info("Class1 path:{}",buffer1.getName());
    }

}
