package com.may.proxy;

import java.lang.reflect.Method;

public class TT  implements MyHandler  {
	
	H h;
	
	public TT(H h) {
		this.h = h;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("动态代理前。。。。");
		String str = (String) method.invoke(h, args);
		
		System.out.println("动态代理后。。。。");
		
		
		
		return str;
	}
	 
	public static void main(String[] args) {
		
		H h = new H();
		
		TT tt = new TT(h);
		
		HHee hhee = (HHee) MyProxy.newProxyInstance(TT.class.getClassLoader(), new Class<?>[] {HHee.class}, tt);
		
		String str = hhee.hh("aaaa");
		
		System.out.println("代理返回的值是：" + str);
		
	}

}
