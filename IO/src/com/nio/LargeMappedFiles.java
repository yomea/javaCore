package com.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
/**
 * 内存映射文件
 * @author may
 *
 */
public class LargeMappedFiles {

	static int length = 1024 * 8;//8KB 

	public static void main(String[] args) throws Exception {
		
		FileChannel channel =  new RandomAccessFile("src/largeFile.dat", "rw").getChannel();

		MappedByteBuffer out = channel.map(MapMode.READ_WRITE, 0,
				length);
		
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		out.rewind();
		for (int i = length/2; i < (length/2 + 6); i++) {
			System.out.println((byte)out.get());
		}
		channel.write(out);
		out.clear();
		channel.close();
		

	}

}
