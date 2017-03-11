package com.interfaceTest;

public interface T {
	
	void hello();
	
	static void print(){}
	
	
	default void yes() {}
	
	/*public static final*/ class MyHello implements T {

		@Override
		public void hello() {
			System.out.println("interface inner class");
			
		}
		
		public static void main(String[] args) {
			new MyHello().hello();
		}
		
		
		
	}
	
	/*public static final*/ class MyHello2{

		public void eee() {
			//hello();//不能引用非静态的方法
			print();
		}
		
		
		
	}
	

}

