package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.reflect.pojo.User;

public class UserTReflectTest {
	
	
	public static void main(String[] args) throws Exception {
		
		Class<User> userClass = User.class;
		
		User user = userClass.newInstance();
		
		Method[] methods = userClass.getDeclaredMethods();
		
		for (Method method : methods) {
			method.setAccessible(true);
			System.out.println(method.invoke(user));
		}
		
		
		
	}

}
