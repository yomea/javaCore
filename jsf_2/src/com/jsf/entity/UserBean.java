package com.jsf.entity;

//@ManagedBean
public class UserBean {
	
	private String name;
	
	private String password;
	
	private String errMessage;
	
	public void setName(String name) {
		this.name = name;
		
	}
	public String getName() {
		
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public String verify() {
		if(name.equals("admin") && password.equals("123")) {
			
			return "success";
		}
		
		this.errMessage = "用户名是admin，密码是123";
		
		return "fail";
		
	}

}
