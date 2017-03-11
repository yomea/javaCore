package com._enum;

import java.lang.reflect.Type;

public class E {
	
	public static void main(String[] args) {
		
		Class<?> clazz = Enum.class;
		
		Class<?> _clazz = EnumTest.class;
		
		for (Type type : _clazz.getGenericInterfaces()) {
			System.out.println(type);
	
		}
		
		for (Class<?> string : _clazz.getInterfaces()) {
			System.out.println(string);
		}
		
		Class<?> _superClazz = _clazz.getSuperclass();
		
		System.out.println(_superClazz);
		
		System.out.println("**************************************************************");
		for (Type type : clazz.getGenericInterfaces()) {
			System.out.println(type);
	
		}
		
		for (Class<?> string : clazz.getInterfaces()) {
			System.out.println(string);
		}
		
		Class<?> superClazz = clazz.getSuperclass();
		
		System.out.println(superClazz);
		
	}

}
