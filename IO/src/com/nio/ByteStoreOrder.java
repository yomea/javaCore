package com.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102] 
 * [0, 97, 0, 98, 0, 99, 0, 100,0, 101, 0, 102]
 * [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]
 * 
 * @author may
 *
 */
public class ByteStoreOrder {

	public static void main(String[] args) {

		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);

		bb.rewind();

		bb.asCharBuffer().put("abcdef");

		System.out.println(Arrays.toString(bb.array()));
		//[0, 97, 0, 98, 0, 99, 0, 100,0, 101, 0, 102]
		bb.order(ByteOrder.BIG_ENDIAN);
		
		bb.rewind();

		bb.asCharBuffer().put("abcdef");

		System.out.println(Arrays.toString(bb.array()));
		//[97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]
		bb.order(ByteOrder.LITTLE_ENDIAN);

		bb.rewind();

		bb.asCharBuffer().put("abcdef");

		System.out.println(Arrays.toString(bb.array()));

	}

}
