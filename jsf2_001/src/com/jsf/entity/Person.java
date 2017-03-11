package com.jsf.entity;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(value="person")
@SessionScoped
public class Person {
	@ManagedProperty(value="org.apache.cn")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
