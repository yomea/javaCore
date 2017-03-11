package com.may.proxy;

import java.lang.reflect.Method;

public interface MyHandler {
	
	
	public Object invoke(Object proxy, Method method, Object[] args)
	        throws Throwable;
}
