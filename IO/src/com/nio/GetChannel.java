package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	
	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		
		FileChannel fc = new FileInputStream("src/hello.txt").getChannel();
		
		ByteBuffer dst = ByteBuffer.allocate(BSIZE);
		
		fc.read(dst);
		
		dst.flip();//调用它，让它做好准备，否则输出的是一堆乱码。为什么这么做呢？主要是这样可以增加读取的速度。
		//Tells whether there are any elements between the current position and the limit.
		while(dst.hasRemaining()) {
			//循环获取每个字符current position 的dst.get()从第一个字符开始往后取值
			System.out.print((char)dst.get());
		}
		
		//清除dst值
		dst.clear();
		fc.close();
	}

}
