package com.constructQuestion;

class T {

	static {

		System.out.println("dfhgdg");

	}

	void draw() {

		System.out.println("start create T...");

	}

	public T() {
		//在类加载后所有的域的最原始值是默认值。
		this.draw();// 这里的this，如果是子类构造器调用的，那么这个this就是子类对象,但属于父类引用子类（多态）
		System.out.println(this.getClass().getName());
	}

}

class Test1 extends T {

	static final int s = new Integer(1);

	private int a = 10;

	private java.util.Date date = new java.util.Date();

	static {

		System.out.println("testjjjj");

	}

	public Test1() {
		System.out.println("a -->" + a + date);

	}

	@Override
	void draw() {

		System.out.println("a -->" + a + date);

	}

}

public class Test {
	public static void main(String[] args) {

		/**
		 * a -->0 date为null a -->10 date有值
		 */
		// new Test();
		System.out.println(Test1.s);
	}

}
