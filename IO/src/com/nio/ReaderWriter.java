package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ReaderWriter {
	
	
	public static void main(String[] args) throws IOException {
		
		FileChannel 
							in = new FileInputStream("src/hello.txt").getChannel(),
		
							out = new FileOutputStream("src/world.txt").getChannel();
		
		ByteBuffer dst = ByteBuffer.allocate(1024);
		
		//java.nio.CharBuffer cb = dst.asCharBuffer();
		
		while((in.read(dst)) != -1) {
			//反转此缓冲区。首先将限制设置为当前位置(in.read(dst)返回的字节数)，然后将位置设置为 0（即0---in.read(dst)）。如果已定义了标记，则丢弃该标记。
			dst.flip();//由于往dst中填充数据的位置已经在dst的最后填入的数据的位置后，如果不写这句话，那么就会出现一堆乱码
			//相当于复位到0位置，并且出去多余未填充的字节
			//桥汬漠睯牬
			//UTF-8
			//hello world
			dst.rewind();//重置到开始位置
			//dst.asCharBuffer().put('\n');
			System.out.println(dst.asCharBuffer().toString());//乱码
			String charset = System.getProperty("file.encoding");
			System.out.println(charset);
			System.out.println(Charset.forName(charset).decode(dst).toString());
			
			out.write(dst);
			
			dst.clear();
			
		}
		//或者
		//in.transferTo(0, in.size(), out);
		//out.transferFrom(in, 0, in.size());
		
		in.close();
		out.close();
		
		
	}

}
