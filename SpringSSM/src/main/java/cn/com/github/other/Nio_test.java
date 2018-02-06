package cn.com.github.other;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Nio_test {
    
	public void nio(){
		RandomAccessFile accessFile;
		try {
			accessFile = new RandomAccessFile("E:\\git\\LearnSQL\\Part\\Part_01.sql", "rw");
			FileChannel iChannel = accessFile.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(48);
			int byteRead = iChannel.read(buffer);
			while(byteRead != -1) {
				buffer.flip();
				while(buffer.hasRemaining()) {
					System.out.println((char)buffer.get());
				}
				buffer.compact();
				byteRead = iChannel.read(buffer);
			}
			accessFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void transfernio() {
		
		try {
			RandomAccessFile	accessFile = new RandomAccessFile("E:\\git\\LearnSQL\\Part\\Part_01.sql", "rw");
			FileChannel iChannel = accessFile.getChannel();
			RandomAccessFile	File = new RandomAccessFile("E:\\git\\LearnSQL\\Part\\Part_05.sql", "rw");
			FileChannel iChannel1 = File.getChannel();
			
			long position = 0;
			long count = iChannel.size();
			iChannel1.transferFrom(iChannel, position, count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  
	public static void main(String[] args) {
		Nio_test test = new Nio_test();
		test.transfernio();
	}
}
