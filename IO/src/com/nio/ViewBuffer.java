package com.nio;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * 转换成其他的buffer
 * @author may
 *
 */
public class ViewBuffer {
	
	public static void main(String[] args) {
		
		ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
		bb.rewind();
		while(bb.hasRemaining()){
			System.out.print(bb.position() + "-->" + bb.get() + "  ");
			
		}
		System.out.println();
		java.nio.CharBuffer cb = ((ByteBuffer)(bb.rewind())).asCharBuffer();
		cb.rewind();
		while(cb.hasRemaining()){
			System.out.print(cb.position() + "-->" + cb.get() + "  ");
			
		}
		System.out.println();
		FloatBuffer fb = ((ByteBuffer)(bb.rewind())).asFloatBuffer();
		while(fb.hasRemaining()){
			System.out.print(fb.position() + "-->" + fb.get() + "  ");
			
		}
		
	}

}
