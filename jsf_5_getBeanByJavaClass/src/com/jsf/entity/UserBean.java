package com.jsf.entity;

import java.util.List;

//@ManagedBean
public class UserBean {
	
	private String name;
	
	private UserBean user;
	
	private List<String> hobbies;
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getName() {
		
		return name;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	

}
