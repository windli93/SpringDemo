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

        log.info("Class path:{}",buffer.getName());//java堆内存，读写效率低，受到java Gc的影响
        log.info("Class1 path:{}",buffer1.getName());//直接内存，读写效率高（少一次拷贝），不受JavaGc的影响，分配效率低
    }

}
