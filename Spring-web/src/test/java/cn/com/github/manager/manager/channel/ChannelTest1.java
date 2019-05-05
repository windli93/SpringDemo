package cn.com.github.manager.manager.channel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class ChannelTest1 {

    public void getChannel() throws Exception {
        //channel demo
        FileInputStream inputStream = new FileInputStream(new File("E:\\1.txt"));
        FileOutputStream outputStream = new FileOutputStream(new File("E:\\2.txt"));
        FileChannel intChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        //设置缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            int eof = intChannel.read(byteBuffer);
            if (eof == -1) {
                break;
            }
            //重设
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        intChannel.close();
        outChannel.close();
        inputStream.close();
        outputStream.close();

        Selector selector = Selector.open();
    }
}
