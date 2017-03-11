package com.json.json_test;

import com.google.gson.annotations.SerializedName;

public class User extends Person {

	@SerializedName("USER_NAME")
	private String username;
	@SerializedName("AGE")
	private int age;

	private transient double weight;//声明为transient来忽略它，gson不会处理它

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}

	
	
	
}
