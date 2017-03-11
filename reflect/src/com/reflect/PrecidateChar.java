package com.reflect;

class T {
	
	private int a;
	
	static {
		System.out.println("package com.reflect");
		
		
	}
	
}

public class PrecidateChar {
	
	public static void main(String[] args) {
		
		
		Class<?> t = T.class;
		
		System.out.println(t.getDeclaredFields());
		
		char[] c = new char[2];
		
		Class<?> clazz  =c.getClass();
		
		System.out.println(boolean.class);
		
		System.out.println(Boolean.TYPE );
		
		if(clazz.isArray()) {
			
			System.out.println("这是个数组");
			
		}
		
		System.out.println(clazz);
		
	}

}
