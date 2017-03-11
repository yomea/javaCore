package com.jsf.entity;

import javax.faces.event.ActionEvent;

public class User {

	private String locale = "en_US";
	private String name;
	private String password;
	private String errMessage;
	private String outcome;
	private String type = "中文";
	
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocale() {
		System.out.println("getLocale...");
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	//当按键一按下，就会先触发这个方法
	public void verify(ActionEvent e) {
		if (!name.equals("admin") || !password.equals("123")) {
			errMessage = "名称或密码错误" + e.getSource();
			outcome = "failure";
		} else {
			outcome = "success";
		}
	}

	public String outcome() {
		return outcome;
	}
	
	public void changeLocale(ActionEvent event) {
		
		if(type.equals("中文")) {
			type = "English";
			this.setLocale("zh_CN");
			return ;
		}
		
		type = "中文";
		this.setLocale("en_US");
		
	}

}
