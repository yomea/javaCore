package com.reflect.pojo;

public class User {
	
	
	private String username = "youth";
	
	private int age = 21;
	
	
	private int getAge() {
		
		return age;
	}
	
	protected String username() {
		
		return username;
	}
	
	String user() {
		
		return username + "的年龄是" + age;
	}

}
