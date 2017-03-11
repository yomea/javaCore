package com.gc;

import java.sql.Date;

class Test {
	
	public static final int s = 1;
	
	public static final java.util.Date date = new java.util.Date();
	//public static int s = 1;这里有点差别，直接调用final的Test.s将不发生类构造器的执行，即static静态不会被调用。
	
	static {
		
		System.out.println("test...");
	}
	
}

public class GCTest {
	
	public  GCTest() {
		
		
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("gc...");
	}
	
	public static void main(String[] args) {
		System.out.println(Test.s);
		GCTest gcTest = new GCTest();
		gcTest = null;//让垃圾回收器有机会回收它
		System.gc();
		System.runFinalization();
		
	}

}
