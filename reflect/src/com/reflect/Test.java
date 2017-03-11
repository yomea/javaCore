package com.reflect;

import java.awt.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Class<User> userClass = User.class;
		
		System.out.println(userClass.getName());
		
		System.out.println(int[].class.getComponentType());//放回数组组件类型，这里返回int
		
		Field[] fields = userClass.getDeclaredFields();
		
		Method[] methods = userClass.getDeclaredMethods();
		
		for (Field field : fields) {
			System.out.print(field.getName() + "-->");
			int modifier = field.getModifiers();
			System.out.println(Modifier.toString(modifier));
		}
		
		for (Method method : methods) {
			System.out.print(method.getName() + "-->");
			Class<?>[] types = method.getParameterTypes();
			for (Class<?> class1 : types) {
				System.out.println(class1.getSimpleName());
			}
			
			Type[] genertypes = method.getGenericParameterTypes();
			
			for (Type type : genertypes) {
				if(type instanceof ParameterizedType) {
					ParameterizedType paranmeterized = (ParameterizedType)type;
					System.out.println("泛型参数的方法" + paranmeterized.getActualTypeArguments()[0]);
					
				}
			}
			
			
		}
		
	
	}

}
