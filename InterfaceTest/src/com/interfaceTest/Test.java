package com.interfaceTest;

interface T1 {
	void f1();
}

interface T2 {
	void f1(int i);
}

interface T3 {
	int f1();
}


public class Test implements T1, T2 {
	
	public static void main(String[] args) {
		T.MyHello tm = new T.MyHello();
		
		tm.hello();
	}
	
	class ImplementsT3 implements T3 {
		//由于外部类实现T3会导致冲突，所以使用内部类来实现。也可以实现多继承
		@Override
		public int f1() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		
	}

	@Override
	public void f1() {
		// TODO Auto-generated method stub
	}

	@Override
	public void f1(int i) {
		// TODO Auto-generated method stub
		
	}
	
}


/*public class Test implements T1, T2, T3 {
	
	private int a = 0;
	
	
	private static class Yes{
		
		{
			
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		T.MyHello tm = new T.MyHello();
		tm.hello();
	}

	@Override
	public void f1() {//会报错
		// TODO Auto-generated method stub
	}

	@Override
	public void f1(int i) {
		// TODO Auto-generated method stub
		
	}
	
}*/