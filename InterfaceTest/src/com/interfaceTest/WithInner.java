package com.interfaceTest;

class kAsf extends WithInner.Inner {

	// kAsf() {}报错，不能

	public kAsf(WithInner withInner) {
		// super();//No enclosing instance of type WithInner is available due to
		// some intermediate constructor invocation
		withInner.super(0);//必须先有外部类的对象，才能调用内部类的构造器，如果这个是static的内部类，那么就不需要这个。

	}
	
	class Has extends WithInner.Inner{

		public Has(WithInner withInner, int i) {
			withInner.super(i);
		
		}
		
		
	}

}

public class WithInner {

	public class Inner {

		public Inner(int i) {
			System.out.println(WithInner.this);

		}

	}

}
